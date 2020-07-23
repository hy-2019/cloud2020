package com.atguigu.springcloud.result;

/**
 * @ClassName ResultEnum
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/18 10:08
 */
public enum ResultEnum {
    SUCCESS(200, "成功"),
    FAIL(500, "失败");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
