package com.geoway.webstore.controller;

import com.geoway.common.utils.R;
import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.dto.StuDTO;
import com.geoway.webstore.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Lencho
 * @CreateTime: 2021/11/24 10:30
 * @Description:
 */
@Controller
@RequestMapping("/stu")
public class StuController {

    @ResponseBody
    @PostMapping("/save")
    public R saveUser(@Validated(StuDTO.Save.class) @RequestBody StuDTO dto) {

        return R.ok();
    }

    @ResponseBody
    @PostMapping("/update")
    public R updateUser(@Validated(StuDTO.Update.class) @RequestBody StuDTO dto) {

        return R.ok();
    }

    @GetMapping("/login")
    public String testLogin(){
        return "redirect:" + "http://www.baidu.com" + "?token=123";
    }
}
