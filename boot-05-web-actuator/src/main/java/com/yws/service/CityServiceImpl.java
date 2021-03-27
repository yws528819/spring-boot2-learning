package com.yws.service;

import com.yws.bean.City;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl {

    Counter counter;

    public CityServiceImpl(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("cityService.getCity.count");
    }

//    @Autowired
//    private MeterRegistry meterRegistry;


    public City getCity() {
        counter.increment();
        //meterRegistry.counter("cityService.getCity.count").increment();
        return new City("1", "北京");
    }
}
