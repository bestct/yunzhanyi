package net.yunzhanyi.admin.exception;

/**
 * @author TingChang
 * @code ChangePasswordException
 * @date 2021/5/15
 * description:
 */

public class ChangePasswordException extends RuntimeException {
    public ChangePasswordException() {
        super();
    }

    public ChangePasswordException(String message) {
        super(message);
    }

    public ChangePasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChangePasswordException(Throwable cause) {
        super(cause);
    }

    protected ChangePasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
