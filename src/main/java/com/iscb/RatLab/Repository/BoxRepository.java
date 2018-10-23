package com.iscb.RatLab.Repository;

import com.iscb.RatLab.Entity.BoxEntity;
import org.springframework.data.repository.CrudRepository;

public interface BoxRepository extends CrudRepository<BoxEntity, String> {
}
