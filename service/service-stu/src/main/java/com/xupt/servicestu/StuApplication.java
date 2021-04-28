package com.xupt.servicestu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.xupt"})
@MapperScan("com.xupt.servicestu.mapper")
public class StuApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.xupt.servicestu.StuApplication.class, args);
    }
}
