package com.yws.controller;

import com.yws.bean.City;
import com.yws.service.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {



    @Autowired
    CityServiceImpl cityService;

    @GetMapping("/city")
    public City getCity() {

        return cityService.getCity();
    }

}
