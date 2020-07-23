package com.atguigu.springcloud.result;


import lombok.Data;

/**
 * @ClassName CommonResult
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/18 9:59
 */
@Data
public class CommonResult<T> {
    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回错误信息
     */
    private String msg;
    /**
     * 返回错误数据
     */
    private T data;

    public CommonResult() {
    }

    public CommonResult(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }

    public CommonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResult(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public CommonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
