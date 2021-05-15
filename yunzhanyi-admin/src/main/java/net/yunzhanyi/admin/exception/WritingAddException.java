package net.yunzhanyi.admin.exception;

/**
 * @author TingChang
 * @code WritingAddException
 * @date 2021/5/6
 * description:
 */

public class WritingAddException extends RuntimeException{
    public WritingAddException() {
        super();
    }

    public WritingAddException(String message) {
        super(message);
    }

    public WritingAddException(String message, Throwable cause) {
        super(message, cause);
    }

    public WritingAddException(Throwable cause) {
        super(cause);
    }

    protected WritingAddException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
