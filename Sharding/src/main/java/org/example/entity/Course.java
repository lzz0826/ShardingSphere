package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    /**
     * 策略會依照 表 entity來判斷使用哪個策略
     * 水平分表測試 同樣的數據結構分別在不同表 course_1  course_2
     * 規則:在同一個庫 course_db 中 分別在 course_1(cid=偶數) course_2(cid=基數) 分散存
     */

    private Long cid ;

    private String cname ;

    private Long userId ;

    private String cstatus ;


}
