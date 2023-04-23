package net.yunzhanyi.common.core.exception;

/**
 * 不登录异常
 *
 * @author bestct
 * @date 2023/04/23
 */
public class NotLoginException extends RuntimeException{

    public NotLoginException(String message) {
        super(message);
    }
}
