package com.yuki.bigdata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yuki.bigdata.mapper")
public class DataWarehouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataWarehouseApplication.class, args);
        System.out.println("启动成功");
    }

}
