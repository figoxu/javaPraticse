package me.figoxu.boot.web;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RestTemplate restTemplate;

    @ApiOperation(value="默认页面", notes="")
    @RequestMapping("/hello")
    public String index() {
        logger.debug("Logger Level ：DEBUG");
        logger.info("Logger Level ：INFO");
        logger.error("Logger Level ：ERROR");
        String resp = restTemplate.getForObject("http://www.baidu.com", String.class);
        logger.info(resp);
        return "Hello World";
    }

}
