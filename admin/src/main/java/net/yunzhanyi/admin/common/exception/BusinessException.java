package net.yunzhanyi.admin.common.exception;

import lombok.Getter;
import net.yunzhanyi.admin.common.result.IResultCode;

/**
 * 自定义业务异常
 *
 * @author haoxr
 * @since 2022/7/31
 */
@Getter
public class BusinessException extends RuntimeException {

    public IResultCode resultCode;

    public BusinessException(IResultCode errorCode) {
        super(errorCode.getMsg());
        this.resultCode = errorCode;
    }

    public BusinessException(String message){
        super(message);
    }

    public BusinessException(String message, Throwable cause){
        super(message, cause);
    }

    public BusinessException(Throwable cause){
        super(cause);
    }


}
