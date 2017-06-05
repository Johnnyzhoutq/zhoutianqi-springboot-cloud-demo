package org.spring.springboot.util.datasource;

/**
 * Created by admin on 2017/5/2.
 */

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class DynamicDataSource extends AbstractRoutingDataSource {


    @Override
    protected Object determineCurrentLookupKey() {
        String type = DataSourceTypeHolder.getCustomerType();
        System.out.println("DynamicDataSource"+type);
        return type;
    }


}
