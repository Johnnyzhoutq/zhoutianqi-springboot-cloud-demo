package org.spring.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.User;
import org.spring.springboot.util.annotation.DataSourceType;


@Mapper
public interface UserDao {

    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    @DataSourceType(type ="masterDataSource")
    User findByName(@Param("userName") String userName);
}
