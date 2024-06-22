package mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.entity.Master;
import org.example.mapper.MasterMapper;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;

import javax.annotation.Resource;


public class MasterMapperTest extends BaseTest{



    @Resource
    private MasterMapper masterMapper;
    /**
     * 1主 2從
     * 規則:
     * 1. 增刪改 主
     * 2. 查詢 從1,2
     * 數據同步需要在mysql中配置
     */
    @Test
    public void addMasterMapperTest(){

        //14:22:40.016 [main] INFO  ShardingSphere-SQL - Actual SQL: m1 ::: INSERT INTO t_master   (mname, mstatus, masterid) VALUES (?, ?, ?) ::: [woo0, w0, 1010916854371188737]
        for(int i = 0 ; i < 10 ; i++){
            Master master = Master
                    .builder()
                    .mname("woo"+i)
                    .mstatus("w"+i)
                    .build();

            int insert = masterMapper.insert(master);
        }


    }
    @Test
    public void findMasterMapperTest(){
    //14:21:08.249 [main] INFO  ShardingSphere-SQL - Actual SQL: s1 ::: SELECT  masterid,mname,mstatus  FROM t_master
    //14:21:08.263 [main] INFO  ShardingSphere-SQL - Actual SQL: s2 ::: SELECT  masterid,mname,mstatus  FROM t_master

        for (int i = 0 ; i < 2 ; i++ ){
            print(1011212792910315521L);
        }

    }
    private void print(Long id){
        QueryWrapper<Master> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("masterid",id);
        Master master = masterMapper.selectOne(objectQueryWrapper);
        System.out.println(master);

    }




}
