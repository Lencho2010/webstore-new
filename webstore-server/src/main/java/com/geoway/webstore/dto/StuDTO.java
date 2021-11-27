package com.geoway.webstore.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Author: Lencho
 * @CreateTime: 2021/11/24 10:29
 * @Description:
 */
@Data
public class StuDTO {
    @Min(value = 10000000000000000L, groups = Update.class)
    private Long userId;

    @NotNull(groups = {Save.class, Update.class})
    @Length(min = 2, max = 10, groups = {Save.class, Update.class})
    private String userName;

    @NotNull(groups = {Save.class, Update.class})
    @Length(min = 6, max = 20, groups = {Save.class, Update.class})
    private String account;

    @NotNull(groups = {Save.class, Update.class}, message = "密码不能为空")
    @Length(min = 6, max = 20, groups = {Save.class, Update.class})
    private String password;

    public interface Save {
    }

    public interface Update {
    }
}
