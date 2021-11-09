package com.geoway.webstore.advice;

import com.alibaba.fastjson.JSON;
import com.geoway.common.utils.R;
import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.util.HttpContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lencho
 * @create 2021-08-18 20:31
 */
@RestControllerAdvice
@Slf4j
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    public static final String RESPONSE_RESULT_ANN = "RESPONSE-RESULT-ANN";
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        HttpServletRequest request = HttpContextUtil.getRequest();
        //判断请求是否有包装标志
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(RESPONSE_RESULT_ANN);
        return responseResultAnn != null;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (body instanceof R) {
            return body;
        } else if (body instanceof String) {
            return JSON.toJSONString(R.ok().setData(body));
        } else {
            return R.ok().setData(body);
        }
    }
}
