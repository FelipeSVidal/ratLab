package com.iscb.RatLab.Security;

public interface PasswordEncoder extends org.springframework.security.crypto.password.PasswordEncoder {
    String encode(CharSequence rawPassword);

    boolean matches(CharSequence rawPassword, String encodedPassword);

}
