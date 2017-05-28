package com.dieselfx.controllers;

import com.dieselfx.domains.DailyPrice;
import com.dieselfx.domains.Feature;
import com.dieselfx.domains.InfoResponse;
import com.dieselfx.domains.InfoSource;
import com.dieselfx.repositories.DailyPriceRepository;
import com.dieselfx.repositories.FeatureRepository;
import com.dieselfx.repositories.InfoSourceRepository;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Autowired
    private FeatureRepository featureRepository;


    @RequestMapping("/depots")
    public
    @ResponseBody
    List<InfoSource> getInfoSources() {

        List<InfoSource> infoSources = IteratorUtils.toList(infoSourceRepository.findAll().iterator());

        return infoSources;
    }

    @RequestMapping(value = "/depots", method = RequestMethod.POST)
    public
    @ResponseBody
    InfoSource savedInfoSource(@RequestBody InfoSource infoSource) {

        InfoSource source = infoSourceRepository.save(infoSource);
        return source;
    }

    @RequestMapping(value = "/inforesponse")
    public @ResponseBody InfoResponse getInfoResponses() {
        InfoResponse infoResponse = new InfoResponse();
        List<Feature> features = IteratorUtils.toList(featureRepository.findAll().iterator());

        infoResponse.setType("FeatureCollection");
        infoResponse.setFeatures(features);

        return infoResponse;
    }

    @RequestMapping(value = "/features", method = RequestMethod.POST)
    public @ResponseBody Feature saveFeature (@RequestBody Feature feature) {
        return featureRepository.save(feature);
    }

    @RequestMapping("/prices")
    public
    @ResponseBody
    List<DailyPrice> getPrices() {

        List<DailyPrice> dailyPrices = IteratorUtils.toList(dailyPriceRepository.findAll().iterator());
        return dailyPrices;
    }

    @RequestMapping(value = "/prices", method = RequestMethod.POST)
    public
    @ResponseBody
    DailyPrice savedDailyPrice(@RequestBody DailyPrice dailyPrice) {

        DailyPrice source = dailyPriceRepository.save(dailyPrice);

        return source;
    }


}
