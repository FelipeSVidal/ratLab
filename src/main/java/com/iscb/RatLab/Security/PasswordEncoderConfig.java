package com.iscb.RatLab.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder customPasswordEncoder() {
        return new PasswordEncoder() {


            @Override
            public String encode(CharSequence rawPassword) {
                return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(4));
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
            }
        };
    }
}