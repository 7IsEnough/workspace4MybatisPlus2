package com.clearlove.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clearlove.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author promise
 * @date 2022/5/23 - 23:01
 * 在对应的Mapper上面继承基本的类 BaseMapper
 * @Repository 代表持久层
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    // 所有的CRUD操作都已经编写完成了
    // 你不需要像以前的配置一大堆文件了
}
