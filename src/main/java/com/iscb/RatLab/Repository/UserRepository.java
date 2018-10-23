package com.iscb.RatLab.Repository;

import com.iscb.RatLab.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {
}
