package org.example.manage.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(NoLoginException.class)
    @ResponseBody
    public AppResponse noLoginExceptionHandler(NoLoginException e) {
        return AppResponse.error(ErrorCodeEnum.E_NOT_LOGIN, "Abnormal user information");
    }

    @ExceptionHandler(value = Exception.class)
    public AppResponse<String> handleException(Exception ex) {
        if (ex instanceof HttpRequestMethodNotSupportedException) {
            return AppResponse.error("Request type error");
        }
        return AppResponse.error(ErrorCodeEnum.E_EXCEPTION);
    }

    @ExceptionHandler(value = Throwable.class)
    public AppResponse<String> handleThrowable(Throwable t) {
        LOGGER.error("Application Throwable Exception: [" + t.getClass().getName() + "]", t);
        return AppResponse.error(ErrorCodeEnum.E_EXCEPTION);
    }
}
