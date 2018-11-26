package com.iscb.RatLab.Repository;

import com.iscb.RatLab.Entity.BoxEntity;
import com.iscb.RatLab.Entity.BoxEntityPK;
import com.iscb.RatLab.Entity.ProjectEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoxRepository extends CrudRepository<BoxEntity, BoxEntityPK> {
    List<BoxEntity> findAllByProjectIdProject(int project_id);
}
