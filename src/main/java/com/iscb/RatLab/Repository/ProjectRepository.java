package com.iscb.RatLab.Repository;

import com.iscb.RatLab.Entity.ProjectEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<ProjectEntity, String> {
}
