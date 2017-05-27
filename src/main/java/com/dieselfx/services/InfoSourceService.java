package com.dieselfx.services;

import com.dieselfx.domains.DailyPrice;
import com.dieselfx.domains.InfoSource;
import com.dieselfx.repositories.InfoSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by macbook on 5/27/17.
 */
@Service
public class InfoSourceService  {
@Autowired
    InfoSourceRepository infoSourceRepository;

public InfoSource save(InfoSource infoSource){
    return  infoSourceRepository.save(infoSource);
}

    public Iterable<InfoSource> findAll(){
        return infoSourceRepository.findAll();
    }

    public InfoSource findOne(Long id){
        return infoSourceRepository.findOne(id);
    }

    public void delete(Long id){
       infoSourceRepository.delete(id);
    }

}
