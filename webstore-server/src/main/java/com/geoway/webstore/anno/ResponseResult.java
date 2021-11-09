package com.geoway.webstore.anno;

import java.lang.annotation.*;

/**
 * @author Lencho
 * @create 2021-08-18 20:26
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseResult {
}
