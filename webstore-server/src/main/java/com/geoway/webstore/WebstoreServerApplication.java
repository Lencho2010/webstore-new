package com.geoway.webstore;

import com.geoway.webstore.util.IDWorker;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@EnableAsync
@SpringBootApplication
@EnableSwagger2Doc
@MapperScan(basePackages = {"com.geoway.webstore.dao"})
public class WebstoreServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebstoreServerApplication.class, args);
    }

    @Bean
    public IDWorker getBean(){
        return new IDWorker(1,1);
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
