package com.dieselfx.controllers;

import com.dieselfx.domains.InfoSource;
import com.dieselfx.repositories.DailyPriceRepository;
import com.dieselfx.repositories.InfoSourceRepository;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ozo on 27/05/2017.
 */

@Controller
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    private InfoSourceRepository infoSourceRepository;
    @Autowired
    private DailyPriceRepository dailyPriceRepository;


    @RequestMapping("/infoSources")
    public @ResponseBody List<InfoSource> getInfoSources() {

        List<InfoSource> infoSources = IteratorUtils.toList(infoSourceRepository.findAll().iterator());

        return infoSources;
    }

    @RequestMapping(value = "/infoSources", method = RequestMethod.POST)
    public @ResponseBody InfoSource savedInfoSource(@RequestBody InfoSource infoSource) {

        InfoSource source = infoSourceRepository.save(infoSource);

        return source;
    }
}
