package com.atguigu.springcloud.util;

import com.atguigu.springcloud.result.CommonResult;
import com.atguigu.springcloud.result.ResultEnum;

/**
 * @ClassName ResultUtil
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/18 10:07
 */
public class ResultUtil {

    public static <T> CommonResult<T> SUCCESS(ResultEnum resultEnum, T data) {
        return new CommonResult<T>(resultEnum, data);
    }

    public static <T> CommonResult<T> SUCCESS(Integer code, String msg, T data) {
        return new CommonResult<T>(code, msg,data);
    }

    public static <T> CommonResult<T> SUCCESS(ResultEnum resultEnum) {
        return new CommonResult<T>(resultEnum);
    }

    public static <T> CommonResult<T> SUCCESS(Integer code, String msg) {
        return new CommonResult<T>(code, msg);
    }

    public static <T> CommonResult<T> Fail(ResultEnum resultEnum) {
        return new CommonResult<T>(resultEnum, null);
    }

    public static <T> CommonResult<T> Fail(Integer code, String msg) {
        return new CommonResult<T>(code, msg);
    }
}
