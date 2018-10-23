package com.iscb.RatLab.Repository;

import com.iscb.RatLab.Entity.TeamEntity;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<TeamEntity, String> {
}
