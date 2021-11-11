package com.dspringmvc.controller.carpark;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "carparkHomeController")
public class HomeController {

    @RequestMapping(value = "/car-park/home-page", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home/home");
        return modelAndView;
    }
}
