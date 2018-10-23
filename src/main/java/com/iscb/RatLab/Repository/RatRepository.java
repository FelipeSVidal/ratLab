package com.iscb.RatLab.Repository;

import com.iscb.RatLab.Entity.RatEntity;
import org.springframework.data.repository.CrudRepository;

public interface RatRepository extends CrudRepository<RatEntity, String> {
}
