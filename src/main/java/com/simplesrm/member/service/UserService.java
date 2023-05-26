package com.simplesrm.member.service;

import com.simplesrm.api.common.ApiResponse;
import com.simplesrm.api.common.SignUpRequest;
import com.simplesrm.mail.component.MailComponents;
import com.simplesrm.member.entity.User;
import com.simplesrm.member.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final MailComponents mailComponents;


    public User getUser(String userId) {
        return userRepository.findByUserId(userId);
    }
    public User signUp(SignUpRequest parameter){

        if(userRepository.existsByEmail(parameter.getEmail())) {
            log.error("Email address already in use.");
            return null;
        }
        if(userRepository.existsByUserId(parameter.getId())) {
            log.error("Duplicate UserId");
            return null;
        }

        String uuid = UUID.randomUUID().toString();


        // Creating user's account
        User user = new User();
        user.createLocalUser(
                parameter.getId(),
                parameter.getName(),
                parameter.getEmail(),
                passwordEncoder.encode(parameter.getPassword()),
                LocalDateTime.now(),
                LocalDateTime.now(),
                uuid
        );
        User result = userRepository.save(user);

        String email = parameter.getEmail();
        String subject = "[simple SRM] 이메일 인증";
        String text = "<p>사이트 가입을 축하드립니다.</p> <p>아래 링크를 클릭하셔서 가입을 완료 하세요.</p>"
                + "<div><a target='_blank' href='http://localhost:8080/member/email-auth?id=" + uuid + "'> 가입 완료 </a></div>";

        mailComponents.sendMail(email,subject,text);



        return result;
    }

    public boolean emailAuth(String id) {

        Optional<User> optionalUser = userRepository.findByEmailAuthKey(id);

        if (!optionalUser.isPresent()) {
            return false;
        }

        User user = optionalUser.get();

        if (user.getEmailVerifiedYn().equals("Y")) {
            log.info("이미 승인된 사용자입니다.");
            return false;
        }

        user.setEmailVerifiedYn("Y");

        userRepository.save(user);
        return true;
    }


}
