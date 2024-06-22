package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course2 {
    /**
     * 策略會依照 表 entity來判斷使用哪個策略
     * 水平拆分 分庫+分表測試
     * 規則:
     * 1. 分別在庫  edu_db_1(userid=偶數) edu_db_2(userid=基數數)
     * 2. 分別在表 course_1(cid=偶數) course_2(cid=基數) 分散存
     */

    private Long cid ;

    private String cname ;

    private Long userId ;

    private String cstatus ;


}
