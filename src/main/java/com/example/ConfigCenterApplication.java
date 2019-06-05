package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * curl -X POST http://localhost:8080/actuator/bus-refresh 刷新配置信息
 * @author tw0519
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
@RestController
public class ConfigCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterApplication.class, args);
    }

    @RequestMapping("/test")
    public String test(){
        return "this is a test";
    }

}
