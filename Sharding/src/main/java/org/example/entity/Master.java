package org.example.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_master")
public class Master {

    /**
     * 1主 2從
     * 規則:
     * 1. 增刪改 主
     * 2. 查詢 從1,2
     * 數據同步需要在mysql中配置
     */

    private Long masterid ;

    private String mname ;

    private String mstatus ;





}
