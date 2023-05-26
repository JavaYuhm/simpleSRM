package com.simplesrm.oauth.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum RoleType {
    USER("USER", "일반사용자 권한"),
    ADMIN("ADMIN", "관리자 권한"),
    VENDOR("VENDOR", "업체 권한");

    private final String code;
    private final String displayName;

    public static RoleType of(String code){
        return Arrays.stream(RoleType.values())
                .filter(r -> r.getCode().equals(code))
                .findAny()
                .orElse(VENDOR);
    }
}
