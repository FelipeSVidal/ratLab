package com.iscb.RatLab.Repository;

import com.iscb.RatLab.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByLoginUser(String login);
    List<UserEntity> findAllByTypeUser(int type);
}
