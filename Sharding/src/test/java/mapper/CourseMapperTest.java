package mapper;


import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.tomcat.jni.Time;
import org.example.entity.Course;
import org.example.mapper.CoursesMapper;
import org.junit.Test;


public class CourseMapperTest extends BaseTest{



    @Resource
    private CoursesMapper coursesMapper;

    /**
     * 水平分表測試 同樣的數據結構分別在不同表 course_1  course_2
     * 規則:在同一個庫 course_db 中 分別在 course_1(cid=偶數) course_2(cid=基數) 分散存
     */
    @Test
    public void addCoursesMapperTest(){
        for(int i = 0 ; i < 10 ; i++){
            Course course = Course
                    .builder()
                    .cname("tony"+i)
                    .userId(1L)
                    .cstatus("normal"+i)
                    .build();
            int insert = coursesMapper.insert(course);
        }

    }
    @Test
    public void findCoursesMapperTest(){
        QueryWrapper<Course> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("cid",1009885116882747313L);
        Course course = coursesMapper.selectOne(objectQueryWrapper);
        System.out.println(course);
    }




}
