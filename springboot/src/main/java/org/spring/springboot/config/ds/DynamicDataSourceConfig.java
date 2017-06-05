package org.spring.springboot.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.spring.springboot.util.datasource.DynamicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/5/4.
 */
@Configuration
@MapperScan(basePackages = DynamicDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory")
public class DynamicDataSourceConfig {

    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "org.spring.springboot.dao";
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Value("${cluster.datasource.url}")
    private String cluster_url;

    @Value("${cluster.datasource.username}")
    private String cluster_user;

    @Value("${cluster.datasource.password}")
    private String cluster_password;

    @Value("${cluster.datasource.driverClassName}")
    private String cluster_driverClass;

    public DataSource clusterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(cluster_driverClass);
        dataSource.setUrl(cluster_url);
        dataSource.setUsername(cluster_user);
        dataSource.setPassword(cluster_password);
        return dataSource;
    }

    @Value("${master.datasource.url}")
    private String url;

    @Value("${master.datasource.username}")
    private String user;

    @Value("${master.datasource.password}")
    private String password;

    @Value("${master.datasource.driverClassName}")
    private String driverClass;

    public DataSource masterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        targetDataSources.put("masterDataSource",masterDataSource());
        targetDataSources.put("clusterDataSource",clusterDataSource());
        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(masterDataSource());
        return dataSource;
    }



    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("dynamicDataSource") DynamicDataSource dynamicDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dynamicDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DynamicDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
