package com.epam.esm.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

/**
 * Class of error handler controller for exception handling
 */
@ControllerAdvice
@EnableWebMvc
public class ErrorHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ModelAndView handleNotFound(HttpServletRequest request, Exception exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("status", HttpStatus.NOT_FOUND);
        mav.addObject("message", exception.getMessage());
        mav.setViewName("page404");
        return mav;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleExceptionServerError(Exception exception) {
        ModelAndView model = new ModelAndView();
        model.addObject("exception",  exception.getMessage());
        model.setViewName("page500");
        return model;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception exception) {
        ModelAndView model = new ModelAndView();
        model.addObject("exception",  exception.getMessage());
        model.setViewName("pageError");
        return model;
    }
}
