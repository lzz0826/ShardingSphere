package mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.entity.Course;
import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.junit.Test;

import javax.annotation.Resource;


public class UserMapperTest extends BaseTest{



    @Resource
    private UserMapper userMapper;

    /**
     * 垂直拆分 專庫專表
     * 規則:
     * 1. 專庫 user_db
     * 2. 專表 t_user
     */
    @Test
    public void addUserMapperTest(){
        for(int i = 0 ; i < 10 ; i++){

            User user = User
                    .builder()
                    .username("tony"+i)
                    .ustatus(String.valueOf(i))
                    .build();

            int insert = userMapper.insert(user);
        }

    }
    @Test
    public void findUserMapperTest(){
        QueryWrapper<User> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("user_id",1010244063342886913L);
        User user = userMapper.selectOne(objectQueryWrapper);
        System.out.println(user);
    }




}
