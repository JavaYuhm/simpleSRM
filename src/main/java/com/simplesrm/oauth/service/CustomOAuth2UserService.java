package com.simplesrm.oauth.service;

import com.simplesrm.member.User;
import com.simplesrm.oauth.entity.ProviderType;
import com.simplesrm.oauth.entity.RoleType;
import com.simplesrm.oauth.entity.UserPrincipal;
import com.simplesrm.oauth.exception.OAuthProviderMissMatchException;
import com.simplesrm.oauth.info.OAuth2UserInfo;
import com.simplesrm.oauth.info.OAuth2UserInfoFactory;
import com.simplesrm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
        OAuth2User user = super.loadUser(userRequest);

        try {
            return this.process(userRequest, user);
        } catch (Exception e) {
            throw new InternalAuthenticationServiceException(e.getMessage(), e.getCause());
        }

    }

    private OAuth2User process(OAuth2UserRequest userRequest, OAuth2User user) {
        ProviderType providerType = ProviderType.valueOf(userRequest.getClientRegistration().getRegistrationId().toUpperCase());

        OAuth2UserInfo userInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(providerType, user.getAttributes());
        User savedUser = userRepository.findByUserId(userInfo.getId());

        if(savedUser != null){
            if(providerType != savedUser.getProviderType()){
                throw new OAuthProviderMissMatchException(
                        "이미 가입된 것 "+providerType + "계정 : " + savedUser.getProviderType() + "account to login"
                );
            }
            updateUser(savedUser, userInfo);
        }
        else {
            savedUser = createUser(userInfo, providerType);
        }


        return UserPrincipal.create(savedUser, user.getAttributes());
    }

    private User createUser(OAuth2UserInfo userInfo, ProviderType providerType) {
        LocalDateTime now = LocalDateTime.now();
        User user = new User(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), "Y", userInfo.getImageUrl(), providerType, RoleType.USER, now, now);

        return userRepository.saveAndFlush(user);
    }

    private User updateUser(User user, OAuth2UserInfo userInfo) {
        if (userInfo.getName() != null && !user.getUsername().equals(userInfo.getName())) {
            user.setUsername(userInfo.getName());
        }

        if (userInfo.getImageUrl() != null && !user.getProfileImageUrl().equals(userInfo.getImageUrl())) {
            user.setProfileImageUrl(userInfo.getImageUrl());
        }

        return user;    }

}
