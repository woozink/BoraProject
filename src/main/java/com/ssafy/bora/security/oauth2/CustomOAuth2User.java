package com.ssafy.bora.security.oauth2;


import com.ssafy.bora.entity.enums.Role;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.util.Collection;
import java.util.Map;


@Getter
public class CustomOAuth2User extends DefaultOAuth2User {
        private String nickname;
        private String email;
        private Role role;

    public CustomOAuth2User(Collection<? extends GrantedAuthority> authorities, Map<String, Object> attributes, String nameAttributeKey,  String email, Role role) {
        super(authorities, attributes, nameAttributeKey);
        this.nickname = nickname;
        this.email = email;
        this.role = role;
    }
}