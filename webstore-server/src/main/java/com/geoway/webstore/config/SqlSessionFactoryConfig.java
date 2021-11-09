package com.geoway.webstore.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author Lencho
 * @create 2021-08-18 21:47
 */
//@Configuration
public class SqlSessionFactoryConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        try {
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));//设置对应的xml文件地址
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        sqlSessionFactoryBean.setDataSource(dataSource);
        System.out.println("1122" + dataSource);
        SqlSessionFactory factory = null;
        try {
            factory = sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }
}
