package com.gaoyang.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableDiscoveryClient
@ImportResource({"classpath*:META-INF/applicationContext-bean.xml"})
public class PaycenterbasecoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaycenterbasecoreApplication.class, args);
    }

}
