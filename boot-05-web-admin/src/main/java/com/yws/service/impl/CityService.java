package com.yws.service.impl;

import com.yws.bean.City;
import com.yws.mapper.CityMapper;
import com.yws.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityMapper cityMapper;

    public City getById(Long id) {
        return cityMapper.getById(id);
    }
}
