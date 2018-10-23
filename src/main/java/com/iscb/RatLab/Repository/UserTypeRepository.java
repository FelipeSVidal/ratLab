package com.iscb.RatLab.Repository;

import com.iscb.RatLab.Entity.UserTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTypeRepository extends CrudRepository<UserTypeEntity, Integer> {
        List<UserTypeEntity> findAllByUserType(String s);
}
