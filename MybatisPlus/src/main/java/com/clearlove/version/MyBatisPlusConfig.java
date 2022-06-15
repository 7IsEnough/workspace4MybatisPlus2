package com.clearlove.version;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author promise
 * @date 2022/6/3 - 15:25
 */
// 配置类
// 扫描mapper文件夹
@MapperScan("com.clearlove.mapper")
@EnableTransactionManagement
@Configuration
public class MyBatisPlusConfig {

  // 注册乐观锁插件
  @Bean
  public OptimisticLockerInterceptor optimisticLockerInterceptor() {
    return new OptimisticLockerInterceptor();
  }

  // 分页插件
  @Bean
  public PaginationInterceptor paginationInterceptor() {
    PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
    return paginationInterceptor;
  }


  // 逻辑删除组件
  @Bean
  public ISqlInjector sqlInjector() {
    return new LogicSqlInjector();
  }
}
