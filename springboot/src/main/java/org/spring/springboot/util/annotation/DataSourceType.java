package org.spring.springboot.util.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceType {
    String type() default "masterDataSource";
}
