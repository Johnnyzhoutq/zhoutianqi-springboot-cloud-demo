package org.spring.springboot.service.impl;


import org.spring.springboot.dao.CityDao;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.spring.springboot.util.annotation.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/5/2.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @DataSourceType(type="clusterDataSource")
    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

}
