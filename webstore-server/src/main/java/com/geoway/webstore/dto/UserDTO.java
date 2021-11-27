package com.geoway.webstore.dto;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @Author: Lencho
 * @CreateTime: 2021/11/24 10:03
 * @Description:
 */
@Data
@ToString
public class UserDTO {

    private Long userId;

    @NotNull
    @Length(min = 2, max = 10)
    private String userName;

    @NotNull
    @Length(min = 6, max = 20)
    private String account;

    @NotNull
    @Length(min = 6, max = 20)
    private String password;
}
