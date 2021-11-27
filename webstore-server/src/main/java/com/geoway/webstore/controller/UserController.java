package com.geoway.webstore.controller;

import com.geoway.common.utils.R;
import com.geoway.webstore.dto.UserDTO;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Lencho
 * @CreateTime: 2021/11/24 10:04
 * @Description:
 */
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/save")
    public R saveUser(@Validated @RequestBody UserDTO userDTO) {

        return R.ok();
    }

    @PostMapping("/save2")
    public R saveUser2(@Validated @RequestBody UserDTO userDTO, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            return R.error("检查参数有误").setData(errors);
        }
        return R.ok();
    }

    @GetMapping("{userId}")
    public R detail(@PathVariable("userId") @Min(10000000000000000L) Long userId) {

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setAccount("11111111111111111");
        userDTO.setUserName("xixi");
        userDTO.setAccount("11111111111111111");
        return R.ok().setData(userDTO);
    }

    @GetMapping("getByAccount")
    public R getByAccount(@Length(min = 6, max = 20) @NotNull String account) {

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(10000000000000003L);
        userDTO.setAccount(account);
        userDTO.setUserName("xixi");
        userDTO.setAccount("11111111111111111");
        return R.ok().setData(userDTO);
    }
}
