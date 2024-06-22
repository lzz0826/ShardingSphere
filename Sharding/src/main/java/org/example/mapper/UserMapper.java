package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.entity.Course;
import org.example.entity.User;
import org.springframework.stereotype.Repository;


/**
 * 垂直拆分 專庫專表
 * 規則:
 * 1. 專庫 user_db
 * 2. 專表 t_user
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
