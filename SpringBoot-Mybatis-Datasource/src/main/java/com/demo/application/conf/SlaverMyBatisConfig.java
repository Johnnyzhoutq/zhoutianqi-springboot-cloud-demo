package com.demo.application.conf;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**  
* @Title：SlaverMyBatisConfig.java
* @Author:zhoutianqi
* @Description:从数据源配置
* @Date：2017年5月24日下午5:47:02  
*/
@Configuration
@MapperScan(basePackages = {"com.demo.application.slavermapper"}, sqlSessionFactoryRef = "slaverSqlSessionFactory")
public class SlaverMyBatisConfig{
	//@Primary
    @Bean(name = "slaverDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slaver")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
	//@Primary
    @Bean(name = "slaverTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("slaverDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
	//@Primary
    @Bean(name = "slaverSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("slaverDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("com.demo.application.entity");
        try {
        	factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/**/*.xml"));
            return factoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
	//@Primary
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("slaverSqlSessionFactory")SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
