package com.iscb.RatLab.Repository;

import com.iscb.RatLab.Entity.ModifierEntity;
import com.iscb.RatLab.Entity.ModifierEntityPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModifierRepository extends CrudRepository<ModifierEntity, ModifierEntityPK> {
    ModifierEntity findFirstByProjectIdProjectOrderByDateModifierDesc(int project_ID);
    List<ModifierEntity> findAllByProjectIdProject(int project_ID);
}
