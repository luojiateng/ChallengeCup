package com.tongxin.system.entity.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @Description:
 * @Title: LoginUser
 * @ProjectName: xsyu
 * @date: 2022/8/25 1:19
 * @author: Luo
 */

public class LoginUser {
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
