package com.shiro.demoshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 扫描mapper类必须要有这句否则找不到
@MapperScan("com.shiro.demoshiro.mapper")
public class DemoshrioApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoshrioApplication.class, args);
    }

}
