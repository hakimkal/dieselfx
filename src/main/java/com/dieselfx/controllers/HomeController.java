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

        return "index" ;
    }


}
