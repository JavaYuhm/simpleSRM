package com.simplesrm.api.controller.auth;

import com.simplesrm.oauth.entity.ProviderType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthReqModel {
    private String id;
    private String password;
}
