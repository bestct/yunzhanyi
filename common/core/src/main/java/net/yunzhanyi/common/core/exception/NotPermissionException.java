package net.yunzhanyi.common.core.exception;

import java.util.Arrays;

/**
 * 没有权限异常
 *
 * @author bestct
 * @date 2023/04/23
 */
public class NotPermissionException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public NotPermissionException(String permission)
    {
        super(permission);
    }

    public NotPermissionException(String[] permissions)
    {
        super(Arrays.toString(permissions));
    }
}

