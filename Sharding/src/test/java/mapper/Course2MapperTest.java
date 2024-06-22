package mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.entity.Course2;
import org.example.mapper.Courses2Mapper;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;


public class Course2MapperTest extends BaseTest{



    @Resource
    private Courses2Mapper courses2Mapper;

    /**
     * 水平拆分 水平 分庫+分表測試
     * 規則:
     * 1. 分別在庫  edu_db_1(userid=偶數) edu_db_2(userid=基數數)
     * 2. 分別在表 course_1(cid=偶數) course_2(cid=基數) 分散存
     */
    @Test
    public void addCourses2MapperTest() throws InterruptedException {
        for(int i = 0 ; i < 20 ; i++){
            Course2 course2 = Course2
                    .builder()
                    .cname("tony"+i)
                    .userId((long) i)
                    .cstatus("normal"+i)
                    .build();
            int insert = courses2Mapper.insert(course2);
            Thread.sleep((int)(Math.random()*10));

        }

    }
    @Test
    public void findCourses2MapperTest(){
        QueryWrapper<Course2> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("cid",1011284255428313089L);
        Course2 course2 = courses2Mapper.selectOne(objectQueryWrapper);
        System.out.println(course2);
    }

    @Test
    public void findCourses2AroundMapperTest(){
        QueryWrapper<Course2> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.gt("cid",100L);
        List<Course2> course2 = courses2Mapper.selectList(objectQueryWrapper);

        for (Course2 course : course2) {
            System.out.println(course.getCid());

        }
    }



}
