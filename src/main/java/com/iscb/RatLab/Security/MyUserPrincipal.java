package com.iscb.RatLab.Security;

import com.iscb.RatLab.Entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MyUserPrincipal implements UserDetails {

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

    public int getTypeUser(){return userEntity.getTypeUser();}

    public UserEntity getUserEntity(){return userEntity;}


}
