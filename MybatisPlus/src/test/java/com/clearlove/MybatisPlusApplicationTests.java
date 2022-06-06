package com.clearlove;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clearlove.mapper.UserMapper;
import com.clearlove.pojo.User;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

  // 测试乐观锁成功
  @Test
  public void testOptimisticLocker() {
    // 1.查询用户信息
    User user = userMapper.selectById(1L);
    // 2.修改用户信息
    user.setName("uzi").setEmail("2800@qq.com");
    // 3.执行更新操作
    userMapper.updateById(user);
  }




  // 测试乐观锁失败 多线程下
  @Test
  public void testOptimisticLocker2() {
    // 线程1
    User user = userMapper.selectById(1L);
    user.setName("uzi111").setEmail("2800@qq.com");

    // 模拟另外一个线程执行插队操作
    User user2 = userMapper.selectById(1L);
    user2.setName("uzi222").setEmail("2800@qq.com");
    userMapper.updateById(user2);

    // 如果没有乐观锁就会覆盖插队线程的值
    // 自旋锁来多次尝试提交
    userMapper.updateById(user);
  }

  // 测试查询
  @Test
  public void testSelectById() {
    User user = userMapper.selectById(1L);
    System.out.println(user);
  }


  // 测试批量查询
  @Test
  public void testSelectByBatchId() {
    List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
    users.forEach(System.out::println);
  }

  // 条件查询其中之一map
  @Test
  public void testSelectByBatchIds() {
    HashMap<String, Object> map = new HashMap<>();
    // 自定义查询
    map.put("name", "明凯");
    map.put("age", 3);
    List<User> users = userMapper.selectByMap(map);
    users.forEach(System.out::println);
  }

  // 测试分页查询
  @Test
  public void testPage() {
    // 参数一：当前页
    // 参数二：页面大小
    Page<User> page = new Page<>(1, 5);
    userMapper.selectPage(page, null);
    page.getRecords().forEach(System.out::println);
    System.out.println(page.getTotal());
  }

  // 测试删除
  @Test
  public void testDeleteById() {
    userMapper.deleteById(1529471335606878211L);
  }

  // 通过id批量删除
  @Test
  public void testDeleteBatchId() {
    userMapper.deleteBatchIds(Arrays.asList(1529471335606878210L,1529471335606878212L));
  }


  // 通过map删除
  @Test
  public void testDeleteByMap() {
    HashMap<String, Object> map = new HashMap<>();
    map.put("name", "uzi222");
    userMapper.deleteByMap(map);
  }
  

}
