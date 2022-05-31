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

  // 测试插入
  @Test
  public void testInsert() {
    User user = new User();
    user.setName("明凯").setAge(3).setEmail("234234@qq.com");
    // 帮我们自动生成id
    // result 受影响的行数
    int result = userMapper.insert(user);
    System.out.println(result);
    // id 会自动回填
    System.out.println(user);
  }

  // 测试更新
  @Test
  public void testUpdate() {
    User user = new User();
    // 通过条件自动拼接sql
    user.setName("简自豪").setId(1529471335606878212L).setAge(21);
    // 注意：updateById 但是参数是一个对象
    int i = userMapper.updateById(user);
    System.out.println(i);
  }
  

}
