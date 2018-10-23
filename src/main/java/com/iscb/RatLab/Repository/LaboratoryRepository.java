package com.iscb.RatLab.Repository;

import com.iscb.RatLab.Entity.LaboratoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface LaboratoryRepository extends CrudRepository<LaboratoryEntity, String> {
}
