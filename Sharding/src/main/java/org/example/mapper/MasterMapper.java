package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.entity.Master;
import org.springframework.stereotype.Repository;

/**
 * 1主 2從
 * 規則:
 * 1. 增刪改 主
 * 2. 查詢 從1,2
 * 數據同步需要在mysql中配置
 */

@Repository
public interface MasterMapper extends BaseMapper<Master> {
}
