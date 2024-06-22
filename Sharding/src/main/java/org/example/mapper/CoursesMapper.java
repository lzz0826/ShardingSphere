package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.entity.Course;
import org.springframework.stereotype.Repository;



/**
 * 水平分表測試 同樣的數據結構分別在不同表 course_1  course_2
 * 規則:在同一個庫 course_db 中 分別在 course_1(cid=偶數) course_2(cid=基數) 分散存
 */
@Repository
public interface CoursesMapper extends BaseMapper<Course> {
}
