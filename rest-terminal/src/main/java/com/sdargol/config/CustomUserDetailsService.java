package com.sdargol.config;

import com.sdargol.entity.UserEntity;
import com.sdargol.service.UserService;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByLogin(s);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity);
    }
}
