package com.clearlove;

import com.clearlove.mapper.UserMapper;
import com.clearlove.pojo.User;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusApplicationTests {

  // 继承了baseMapper，所有的方法都来自父类
  // 也可以编写自己的扩展方法
  @Autowired private UserMapper userMapper;

  @Test
  void contextLoads() {
    // 查询全部用户
    // 参数是一个Wrapper，条件构造器，这里先不用，设为null
    List<User> users = userMapper.selectList(null);
    users.forEach(System.out::println);
  }

}
