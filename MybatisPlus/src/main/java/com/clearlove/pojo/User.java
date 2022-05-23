package com.clearlove.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author promise
 * @date 2022/5/23 - 22:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private Long id;

  private String name;

  private Integer age;

  private String email;

}
