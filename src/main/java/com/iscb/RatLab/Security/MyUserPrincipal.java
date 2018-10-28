package com.iscb.RatLab.Security;

import com.iscb.RatLab.Entity.UserEntity;
import com.iscb.RatLab.Entity.UserTypeEntity;
import com.iscb.RatLab.Repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class MyUserPrincipal implements UserDetails {
    @Autowired
    UserTypeRepository userTypeRepository;

    UserEntity userEntity;

    public MyUserPrincipal(UserEntity userEntity){
        this.userEntity = userEntity;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userEntity.getPasswordUser();
    }

    @Override
    public String getUsername() {
        return userEntity.getNameUser();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public int getUserTypeID(){
        return userEntity.getUserTypeIdUserType();
    }

}
