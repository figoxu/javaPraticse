package me.figoxu.boot.web;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value="默认页面", notes="")
    @RequestMapping("/hello")
    public String index() {


        logger.debug("Logger Level ：DEBUG");
        logger.info("Logger Level ：INFO");
        logger.error("Logger Level ：ERROR");

        return "Hello World";
    }

}
