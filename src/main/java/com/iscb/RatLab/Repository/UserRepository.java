package com.iscb.RatLab.Repository;

import com.iscb.RatLab.Entity.UserEntity;
import com.iscb.RatLab.Entity.UserEntityPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, UserEntityPK> {
    List<UserEntity> findAllByUserTypeIdUserType(int i);
    UserEntity findByEmailUser(String s);
}
