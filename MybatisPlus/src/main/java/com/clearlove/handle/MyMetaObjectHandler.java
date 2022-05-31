package com.clearlove.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author promise
 * @date 2022/5/31 - 22:29
 */
@Slf4j
// 一定不要忘记将处理器加到IOC容器中
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

  // 插入时的填充策略
  @Override
  public void insertFill(MetaObject metaObject) {
    log.info("start insert fill.....");
    this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
    this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
  }

  // 更新时的填充策略
  @Override
  public void updateFill(MetaObject metaObject) {
    log.info("start update fill.....");
    this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
  }
}
