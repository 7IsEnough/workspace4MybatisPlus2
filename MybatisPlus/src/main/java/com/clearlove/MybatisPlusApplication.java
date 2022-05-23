package com.clearlove;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 扫描mapper文件夹
@MapperScan("com.clearlove.mapper")
public class MybatisPlusApplication {

  public static void main(String[] args) {
    SpringApplication.run(MybatisPlusApplication.class, args);
  }

}
