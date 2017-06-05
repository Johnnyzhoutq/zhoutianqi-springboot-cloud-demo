package org.spring.springboot.service.impl;

import org.spring.springboot.dao.CityDao;
import org.spring.springboot.dao.UserDao;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.UserService;
import org.spring.springboot.util.annotation.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现层
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao; // 主数据源

    @Autowired
    private CityDao cityDao; // 从数据源

    @Override
    @DataSourceType(type = "masterDataSource")
    public User findByName(String userName) {
        User user = userDao.findByName(userName);
        return user;
    }
}
