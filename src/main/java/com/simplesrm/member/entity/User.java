package com.simplesrm.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.simplesrm.oauth.entity.ProviderType;
import com.simplesrm.oauth.entity.RoleType;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER")
public class User {
    @JsonIgnore
    @Id
    @Column(name = "USER_SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Column(name = "USER_ID", length = 64, unique = true)
    @NotNull
    private String userId;

    @Column(name = "USERNAME", length = 100)
    @NotNull
    @Setter
    private String username;

    @JsonIgnore
    @Column(name = "PASSWORD", length = 128)
    @NotNull
    private String password;

    @Column(name = "EMAIL", length = 512, unique = true)
    @NotNull
    private String email;

    @Column(name = "EMAIL_VERIFIED_YN", length = 1)
    @NotNull
    @Setter
    private String emailVerifiedYn;

    @Column(name = "PROFILE_IMAGE_URL", length = 512)
    @NotNull
    @Setter
    private String profileImageUrl;

    @Column(name = "PROVIDER_TYPE", length = 20)
    @Enumerated(EnumType.STRING)
    @NotNull
    private ProviderType providerType;

    @Column(name = "ROLE_TYPE", length = 20)
    @Enumerated(EnumType.STRING)
    @NotNull
    private RoleType roleType;

    @Column(name = "CREATED_AT")
    @NotNull
    private LocalDateTime createdAt;

    @Column(name = "MODIFIED_AT")
    @NotNull
    private LocalDateTime modifiedAt;

    @Setter
    private LocalDateTime emailVerifiedDt;
    @Setter
    private String emailAuthKey;

    public void createLocalUser(
            @NotNull String userId,
            @NotNull String username,
            @NotNull String email,
            @NotNull String password,
            @NotNull LocalDateTime createdAt,
            @NotNull LocalDateTime modifiedAt,
            String emailAuthKey

    ) {

        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.emailVerifiedYn = "N";
        this.profileImageUrl = "NO_URL";
        this.providerType = ProviderType.LOCAL;
        this.roleType = RoleType.USER;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.emailAuthKey = emailAuthKey;

    }

    public User(
            @NotNull String userId,
            @NotNull String username,
            @NotNull String email,
            @NotNull String emailVerifiedYn,
            @NotNull String profileImageUrl,
            @NotNull ProviderType providerType,
            @NotNull RoleType roleType,
            @NotNull LocalDateTime createdAt,
            @NotNull LocalDateTime modifiedAt
    ) {
        this.userId = userId;
        this.username = username;
        this.password = "NO_PASS";
        this.email = email != null ? email : "NO_EMAIL";
        this.emailVerifiedYn = emailVerifiedYn;
        this.profileImageUrl = profileImageUrl != null ? profileImageUrl : "";
        this.providerType = providerType;
        this.roleType = roleType;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}