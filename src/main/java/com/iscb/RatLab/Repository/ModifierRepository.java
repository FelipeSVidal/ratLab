package com.iscb.RatLab.Repository;

import com.iscb.RatLab.Entity.ModifierEntity;
import com.iscb.RatLab.Entity.ModifierEntityPK;
import org.springframework.data.repository.CrudRepository;

public interface ModifierRepository extends CrudRepository<ModifierEntity, ModifierEntityPK> {
    ModifierEntity findFirstByProjectIdProjectOrderByDateModifierDesc(int project_ID);
}
