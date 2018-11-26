package com.iscb.RatLab.Repository;

import com.iscb.RatLab.Entity.LaboratoryEntity;
import com.iscb.RatLab.Entity.ProjectEntity;
import com.iscb.RatLab.Entity.ProjectEntityPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<ProjectEntity, ProjectEntityPK> {
    List<ProjectEntity> findAllByUserIdUser(int user_id);
    List<ProjectEntity> findAllByLaboratoryIdLaboratory(int lab_id);
    ProjectEntity findByIdProject(int project_id);
}
