package com.geoway.webstore.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Lencho
 * @create 2021-09-08 20:04
 * @desc
 */
public class ExtractUtil {

    public static Integer extractTbCount(String jsonStr){
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        Object count = jsonObject.get("num");
        return Integer.parseInt(count.toString());
    }
}
