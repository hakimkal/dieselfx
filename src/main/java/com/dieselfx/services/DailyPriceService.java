package com.dieselfx.services;

import com.dieselfx.domains.DailyPrice;
import com.dieselfx.repositories.DailyPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by macbook on 5/27/17.
 */

@Service
public class DailyPriceService {

    @Autowired
    private DailyPriceRepository dailyPriceRepository;

    public DailyPrice save(DailyPrice dailyPrice) {
        return dailyPriceRepository.save(dailyPrice);
    }

    public Iterable<DailyPrice> findAll(){
        return dailyPriceRepository.findAll();
    }

    public DailyPrice findOne(Long id){
        return dailyPriceRepository.findOne(id);
    }

    public void delete(Long id){
        dailyPriceRepository.delete(id);
    }
}
