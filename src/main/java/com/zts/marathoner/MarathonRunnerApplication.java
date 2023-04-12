package com.zts.marathoner;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zts.**.mapper")
public class MarathonRunnerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarathonRunnerApplication.class, args);
    }

}
