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
@TableName("t_user")
public class User {

    /**
     * 垂直拆分 專庫專表
     * 規則:
     * 1. 專庫 user_db
     * 2. 專表 t_user
     */

    private Long userId ;

    private String username ;


    private String ustatus ;





}
