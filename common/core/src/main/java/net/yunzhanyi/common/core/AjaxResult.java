package net.yunzhanyi.common.core;

/**
 * @author bestct
 * @date 2023/4/22
 * description: TODO
 */
public class AjaxResult {

    /**
     * 代码
     */
    private int code;

    /**
     * 信息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;

    private AjaxResult() {

    }

    private AjaxResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功
     *
     * @param msg  消息
     * @param data 数据
     * @return {@link AjaxResult}
     */
    public static AjaxResult success(String msg, Object data) {
        return createAjaxResult(200, msg, data);
    }

    /**
     * 成功没有消息
     *
     * @param data 数据
     * @return {@link AjaxResult}
     */
    public static AjaxResult successWithoutMsg(Object data) {
        return success(null, data);
    }

    /**
     * 错误
     *
     * @param msg 消息
     * @return {@link AjaxResult}
     */
    public static AjaxResult error(String msg) {
        return error(500,msg);
    }

    /**
     * 错误
     *
     * @param code 代码
     * @param msg  消息
     * @return {@link AjaxResult}
     */
    public static AjaxResult error(int code, String msg) {
       return createAjaxResult(code,msg, null);
    }

    /**
     * 创建ajax结果
     *
     * @param code 代码
     * @param msg  消息
     * @param data 数据
     * @return {@link AjaxResult}
     */
    public static AjaxResult createAjaxResult(int code, String msg, Object data) {
        return new AjaxResult(code,msg,data);
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

    public void setData(Object data) {
        this.data = data;
    }
}
