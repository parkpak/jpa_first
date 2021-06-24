package com.example.jpa.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.security.InvalidParameterException;

import static com.example.jpa.web.common.constant.ViewConstant.VIEW_ERROR_400;
import static com.example.jpa.web.common.constant.ViewConstant.VIEW_ERROR_500;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    /**
     * request queryString Exception..
     *
     * @param e
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public String illegalArgumentException(IllegalArgumentException e) {

        log.info("** illegalArgumentException");

        return VIEW_ERROR_400;
    }

    /**
     * request param bind Exception..
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public String bindException(BindException e) {

        log.info("** bindException");

        return VIEW_ERROR_400;
    }

    @ExceptionHandler(InvalidParameterException.class)
    public String invalidParameterException(InvalidParameterException e) {

        log.info("** invalidParameterException");

        return VIEW_ERROR_400;
    }

    /**
     * Entity validation Error...
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public String constraintViolationException(ConstraintViolationException e) {

        log.info(" ** ConstraintViolationException");
        log.info(e.getMessage());

        return VIEW_ERROR_500;
    }
}
