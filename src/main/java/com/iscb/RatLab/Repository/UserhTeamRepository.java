package com.iscb.RatLab.Repository;

import com.iscb.RatLab.Entity.UserHasTeamEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserhTeamRepository extends CrudRepository<UserHasTeamEntity, String> {
}
