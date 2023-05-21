package net.yunzhanyi.common.core.vo;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author bestct
 * @date 2023/4/22
 * description: TODO
 */
@Schema(description = "统一返回结果")
public class AjaxResult<T> {

    /**
     * 代码
     */
    @Schema(description = "相应码")
    private int code;

    /**
     * 信息
     */
    @Schema(description = "消息")
    private String msg;
    /**
     * 数据
     */
    @Schema(description = "数据")
    private T data;

    private AjaxResult() {

    }

    private AjaxResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> AjaxResult<T> success(){
        return success("",null);
    }
    /**
     * 成功
     *
     * @param msg  消息
     * @param data 数据
     * @return {@link AjaxResult}
     */
    public static <T> AjaxResult<T> success(String msg, T data) {
        return createAjaxResult(200, msg, data);
    }

    /**
     * 成功没有消息
     *
     * @param data 数据
     * @return {@link AjaxResult}
     */
    public static <T> AjaxResult<T> successWithoutMsg(T data) {
        return success("请求成功", data);
    }

    /**
     * 错误
     *
     * @param msg 消息
     * @return {@link AjaxResult}
     */
    public static <T> AjaxResult<T> error(String msg) {
        return error(500, msg);
    }

    /**
     * 错误
     *
     * @param code 代码
     * @param msg  消息
     * @return {@link AjaxResult}
     */
    public static <T> AjaxResult<T> error(int code, String msg) {
        return createAjaxResult(code, msg, null);
    }

    /**
     * 创建ajax结果
     *
     * @param code 代码
     * @param msg  消息
     * @param data 数据
     * @return {@link AjaxResult}
     */
    public static <T> AjaxResult<T> createAjaxResult(int code, String msg, T data) {
        return new AjaxResult<>(code, msg, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
