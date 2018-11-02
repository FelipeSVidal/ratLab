package com.iscb.RatLab.Repository;

import com.iscb.RatLab.Entity.UserHasTeamEntity;
import com.iscb.RatLab.Entity.UserHasTeamEntityPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserhTeamRepository extends CrudRepository<UserHasTeamEntity, UserHasTeamEntityPK> {
    List<UserHasTeamEntity> findAllByUserIdUser(int id);
}
