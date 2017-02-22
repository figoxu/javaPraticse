package me.figoxu.boot.common.exception;

import me.figoxu.boot.webmodel.response.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorResponse jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        ErrorResponse r = new ErrorResponse();
        r.setMessage(e.getMessage());
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

}
