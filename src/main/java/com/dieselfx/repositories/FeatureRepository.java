package com.dieselfx.repositories;

import com.dieselfx.domains.Feature;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ozo on 28/05/2017.
 */
public interface FeatureRepository extends CrudRepository<Feature, Long>, JpaSpecificationExecutor<Feature> {
}