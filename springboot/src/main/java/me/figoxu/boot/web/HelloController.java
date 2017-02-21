package me.figoxu.boot.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @ApiOperation(value="默认页面", notes="")
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

}
