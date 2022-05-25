package com.clearlove.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author promise
 * @date 2022/5/23 - 22:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {

  // 对应数据库中的主键(uuid  自增id  雪花算法  redis  zookeeper)
  // IdType.INPUT  一旦手动输入id以后，就需要自己配置id了
  @TableId(type = IdType.INPUT)
  private Long id;

  private String name;

  private Integer age;

  private String email;

}
