package com.g7go.demo;

import com.g7go.config.EnableDynamicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamicDataSource
public class DynamicDatasourceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceDemoApplication.class, args);
    }

}
