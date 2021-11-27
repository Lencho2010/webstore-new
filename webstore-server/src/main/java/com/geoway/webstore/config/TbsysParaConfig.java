package com.geoway.webstore.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lencho
 * @create 2021-09-09 9:35
 * @desc
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "sys-para")
public class TbsysParaConfig {

    private String scanIntervalKey;
    private String scanPathKey;
    private String scanPathsKey;
    private String serviceStatusKey;
    private String reportYearKey;
}
