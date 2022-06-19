package com.clearlove;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clearlove.mapper.UserMapper;
import com.clearlove.pojo.User;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author promise
 * @date 2022/6/19 - 16:11
 */
@SpringBootTest
public class WrapperTest {

  // 继承了baseMapper，所有的方法都来自父类
  // 也可以编写自己的扩展方法
  @Autowired
  private UserMapper userMapper;

  @Test
  void contextLoads() {
    // 查询name不为空的用户，并且邮箱不为空的用户，年龄大于等于12
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    wrapper.isNotNull("name").isNotNull("email").ge("age", 12);
    userMapper.selectList(wrapper).forEach(System.out::println);
  }

  @Test
  void test2() {
    // 查询名字为简自豪
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    wrapper.eq("name", "简自豪");
    // 查询一个数据，出现多个结果使用List，或者map
    User user = userMapper.selectOne(wrapper);
    System.out.println(user);
  }

  @Test
  void test3() {
    // 查询年龄在20-30岁之间的用户
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    // 区间
    wrapper.between("age", 20, 30);
    // 查询结果数
    Integer count = userMapper.selectCount(wrapper);
    System.out.println(count);
  }

  // 模糊查询
  @Test
  void test4() {
    // 查询名字不包含e，且邮箱以t开头的
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    // 左和右 %e%
    wrapper.notLike("name", "e").likeRight("email", "t");

    // 查询结果数
    List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
    maps.forEach(System.out::println);
  }

  @Test
  void test5() {
    // 查询
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    // id在子查询中查出来
    wrapper.inSql("id", "select id from user where id < 3");

    // 查询结果数
    List<Object> objects = userMapper.selectObjs(wrapper);
    objects.forEach(System.out::println);
  }

  @Test
  void test6() {
    // 查询
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    // 通过id进行排序
    wrapper.orderByDesc("id");

    // 查询结果数
    List<Object> objects = userMapper.selectObjs(wrapper);
    objects.forEach(System.out::println);
  }


}
