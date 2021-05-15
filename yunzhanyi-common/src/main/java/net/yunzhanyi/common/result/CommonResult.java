package net.yunzhanyi.common.result;

import java.io.Serializable;

/**
 * @author TingChang
 * @code CommonResult
 * @date 2021/4/26
 * description:
 */

/**
 * @author TingChang
 * @code CommonResult
 * @date 2021/4/18
 * description:
 */

public class CommonResult <T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public CommonResult() {

    }

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public static <T> CommonResult<T> successWithData(T data){
        return new CommonResult<>(1,"数据返回成功",data);
    }


    public static CommonResult<String> successWithoutData(String message){
        return new CommonResult<>(1,message);
    }


    public static CommonResult<String> failure(String message){
        return new CommonResult<>(0,message);
    }

}
