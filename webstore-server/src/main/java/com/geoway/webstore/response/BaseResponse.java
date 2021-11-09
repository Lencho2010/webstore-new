package com.geoway.webstore.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: Lencho
 * @CreateTime: 2021/11/5 17:49
 * @Description:
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    private Integer code;
    private String message;
}
