package com.efun.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SpringBoot启动类
 */
@ImportResource(locations = {"classpath:applicationContext-springboot.xml"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,RedisAutoConfiguration.class})
@ComponentScan
@Controller
@EnableCaching
public class Application {

    @ResponseBody
    @RequestMapping("/")
    public String hello() {
        return "hello world!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
