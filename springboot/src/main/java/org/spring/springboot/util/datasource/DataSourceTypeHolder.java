package org.spring.springboot.util.datasource;

/**
 * Created by admin on 2017/5/2.
 */
public class DataSourceTypeHolder {

    private static final ThreadLocal<String> typeHolder = new ThreadLocal<String>();

    public static void setCustomerType(String customerType) {
        typeHolder.set(customerType);
    }

    public static String getCustomerType() {
        return typeHolder.get();
    }

    public static void clearCustomerType() {
        typeHolder.remove();
    }
}