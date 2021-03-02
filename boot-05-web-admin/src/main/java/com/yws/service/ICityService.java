package com.yws.service;

import com.yws.bean.City;

public interface ICityService {
    public City getById(Long id);

    public City saveCity(City city);
}
