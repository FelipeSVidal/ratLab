package com.iscb.RatLab.Repository;

import com.iscb.RatLab.Entity.BoxEntity;
import com.iscb.RatLab.Entity.BoxEntityPK;
import org.springframework.data.repository.CrudRepository;

public interface BoxRepository extends CrudRepository<BoxEntity, BoxEntityPK> {
}
