package com.dieselfx.repositories;

import com.dieselfx.domains.DailyPrice;
import com.dieselfx.domains.InfoSource;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by macbook on 5/27/17.
 */
public interface DailyPriceRepository  extends CrudRepository<DailyPrice, Long>, JpaSpecificationExecutor<DailyPrice> {
}
