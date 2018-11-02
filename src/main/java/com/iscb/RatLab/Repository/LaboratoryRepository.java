package com.iscb.RatLab.Repository;

import com.iscb.RatLab.Entity.LaboratoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LaboratoryRepository extends CrudRepository<LaboratoryEntity, Integer> {
    List<LaboratoryEntity> findAllByUserIdUser(int id);
    LaboratoryEntity findByNameLaboratory(String name);
}
