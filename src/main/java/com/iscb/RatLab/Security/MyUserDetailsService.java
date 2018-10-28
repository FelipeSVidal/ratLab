package com.iscb.RatLab.Security;

import com.iscb.RatLab.Entity.UserEntity;
import com.iscb.RatLab.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmailUser(s);
        if(userEntity == null){
            throw new UsernameNotFoundException(s);
        }

        return new MyUserPrincipal(userEntity);
    }
}
