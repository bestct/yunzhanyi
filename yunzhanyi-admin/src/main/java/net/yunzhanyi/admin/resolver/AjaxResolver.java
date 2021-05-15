package net.yunzhanyi.admin.resolver;

import net.yunzhanyi.admin.exception.ChangePasswordException;
import net.yunzhanyi.admin.exception.WritingAddException;
import net.yunzhanyi.common.result.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author TingChang
 * @code AjaxResolver
 * @date 2021/5/6
 * description:
 */

@RestControllerAdvice
public class AjaxResolver {

    @ExceptionHandler(WritingAddException.class)
    public CommonResult<String> writingAddExceptionHandler(WritingAddException exception){

      return CommonResult.failure(exception.getMessage());
    }

    @ExceptionHandler(ChangePasswordException.class)
    public CommonResult<String> changePasswordExceptionHandler(ChangePasswordException exception){

        return CommonResult.failure(exception.getMessage());
    }

}