package org.spring.springboot.util.datasource;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.spring.springboot.util.annotation.DataSourceType;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2017/5/2.
 */
@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("execution(public * org.spring.springboot.service.impl..*.*(..))")
    public void changeDataSource(){}


    @Before("changeDataSource() && @annotation(type)")
    public void setDataSource(DataSourceType type) throws Throwable{
        System.out.println(type.type());
        DataSourceTypeHolder.setCustomerType(type.type());
    }


    @After("changeDataSource() && @annotation(type)")
    public void resetDataSource(DataSourceType type) throws Throwable{
        DataSourceTypeHolder.clearCustomerType();
    }


}
