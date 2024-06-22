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
@TableName("t_udict")
public class Udict {

    /**
     * 共用表
     * 規則: 添加共用表在 edu_db_1 edu_db_2 t_user course_db 中都添加t_udict表 可以同事對三個庫裡的 t_udict 增刪改查
     */

    private Long dictId ;

    private String ustatus ;

    private String uvalue ;


}
