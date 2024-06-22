package mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.example.entity.Udict;
import org.example.mapper.UdictMapper;
import org.junit.Test;

import javax.annotation.Resource;


public class UdictMapperTest extends BaseTest{



    @Resource
    private UdictMapper udictMapper;

    /**
     * 共用表
     * 規則: 添加共用表在 edu_db_1 edu_db_2 t_user 中都添加t_udict表 可以同事對三個庫裡的 t_udict 增刪改查
     */
    @Test
    public void addUdictMapperTest(){
        for(int i = 0 ; i < 10 ; i++){
            Udict udict = Udict
                    .builder()
                    .ustatus("tony"+i)
                    .uvalue("other"+i)
                    .build();

            int insert = udictMapper.insert(udict);
        }
    }
    @Test
    public void findUdictMapperTest(){
        QueryWrapper<Udict> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("dict_id",1010544342206513153L);
        Udict user = udictMapper.selectOne(objectQueryWrapper);
        System.out.println(user);
    }

    @Test
    public void updateUdictMapperTest(){
        UpdateWrapper<Udict> objectQueryWrapper = new UpdateWrapper<>();
        objectQueryWrapper.eq("dict_id",1010544342080684033L);
        Udict udict = Udict
                .builder()
                .ustatus("eeee")
                .uvalue("rrrrr")
                .build();
        int user = udictMapper.update(udict,objectQueryWrapper);
        System.out.println(user);
    }

    @Test
    public void DeleteUdictMapperTest(){
        QueryWrapper<Udict> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("dict_id",1010544342151987200L);
        int user = udictMapper.delete(objectQueryWrapper);
        System.out.println(user);
    }




}
