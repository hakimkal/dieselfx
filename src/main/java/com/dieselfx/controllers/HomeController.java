package com.dieselfx.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by abdulhakim on 10/12/16.
 */
@RequestMapping("/")
@Controller
public class HomeController   {

    @RequestMapping(method = RequestMethod.GET)

    public String index(Principal principal, Model model){

        return "home" ;
    }


    @RequestMapping(method = RequestMethod.GET, value = "map")

    public String showMap(Principal principal, Model model){

        return "maps" ;
    }

    @RequestMapping(method = RequestMethod.GET, value = "location")

    public String showLocation(Principal principal, Model model){

        return "location" ;
    }

    @RequestMapping(method = RequestMethod.GET, value = "daily")

    public String showDaily(Principal principal, Model model){

        return "daily" ;
    }

}
