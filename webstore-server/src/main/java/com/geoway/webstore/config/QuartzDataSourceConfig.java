package com.geoway.webstore.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/12 15:15
 * @Description:
 */
//@Configuration
public class QuartzDataSourceConfig {
    private static HikariDataSource createHikariDataSource(DataSourceProperties properties) {
        // 创建 HikariDataSource 对象
        HikariDataSource dataSource = properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
        // 设置线程池名
        if (StringUtils.hasText(properties.getName())) {
            dataSource.setPoolName(properties.getName());
        }
        return dataSource;
    }

    /**
     * 创建 quartz 数据源的配置对象
     */
    @Primary
    @Bean(name = "quartzDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource")
    // 读取 spring.datasource  配置到 DataSourceProperties 对象
    public DataSourceProperties quartzDataSourceProperties() {

        return new DataSourceProperties();
    }

    /**
     * 创建 quartz 数据源
     */
    @Bean(name = "quartzDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.quartz.hikari")
    @QuartzDataSource
    public DataSource quartzDataSource() {
        // 获得 DataSourceProperties 对象
        DataSourceProperties properties = this.quartzDataSourceProperties();
        // 创建 HikariDataSource 对象
        return createHikariDataSource(properties);
    }
}
