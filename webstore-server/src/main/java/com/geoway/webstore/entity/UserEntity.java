package com.geoway.webstore.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: Lencho
 * @CreateTime: 2021/11/27 9:24
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Excel(name = "ID", orderNum = "0", isColumnHidden = true)
    private Long id;
    @Excel(name = "姓名", orderNum = "1")
    private String userName;
    @Excel(name = "年龄", orderNum = "2")
    private Integer age;
    @Excel(name = "邮箱", orderNum = "3")
    private String email;
    @Excel(name = "性别", replace = {"男_1", "女_2"}, orderNum = "5")
    private Integer sex;
    @Excel(name = "出生日期", exportFormat = "yyyy-MM-dd", importFormat = "yyyy-MM-dd", orderNum = "4")
    private Date birth;
}
