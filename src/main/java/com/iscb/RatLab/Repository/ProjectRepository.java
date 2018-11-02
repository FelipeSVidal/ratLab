package com.iscb.RatLab.Repository;

import com.iscb.RatLab.Entity.LaboratoryEntity;
import com.iscb.RatLab.Entity.ProjectEntity;
import com.iscb.RatLab.Entity.ProjectEntityPK;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<ProjectEntity, ProjectEntityPK> {

}
