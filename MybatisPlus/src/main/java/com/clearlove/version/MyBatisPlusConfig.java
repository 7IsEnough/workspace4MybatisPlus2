package com.clearlove.version;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
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

  // sql执行效率插件
  @Bean
  // 设置dev test环境开启，保证开发效率
  @Profile({"dev","test"})
  public PerformanceInterceptor performanceInterceptor() {
    PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
    // 设置sql执行的最大时间，如果超过了则不执行
    // ms
    // 在工作中，不允许用户等待
    performanceInterceptor.setMaxTime(100);
    // 是否格式化代码
    performanceInterceptor.setFormat(true);

    return performanceInterceptor;
  }
}
