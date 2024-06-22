package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.entity.Udict;
import org.springframework.stereotype.Repository;


/**
 * 共用表
 * 規則: 添加共用表在 edu_db_1 edu_db_2 t_user course_db 中都添加t_udict表 可以同事對三個庫裡的 t_udict 增刪改查
 */
@Repository
public interface UdictMapper extends BaseMapper<Udict> {
}
