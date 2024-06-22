package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.entity.Course;
import org.example.entity.Course2;
import org.springframework.stereotype.Repository;



/**
 * 水平拆分 分庫+分表測試
 * 規則:
 * 1. 分別在庫  edu_db_1(userid=偶數) edu_db_2(userid=基數數)
 * 2. 分別在表 course_1(cid=偶數) course_2(cid=基數) 分散存
 */
@Repository
public interface Courses2Mapper extends BaseMapper<Course2> {
}
