package me.figoxu.boot.web;

import io.swagger.annotations.ApiOperation;
import me.figoxu.boot.common.exception.MyException;
import me.figoxu.boot.webmodel.response.HelloRespBean;
import me.figoxu.boot.webmodel.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RestTemplate restTemplate;

    @ApiOperation(value="默认页面", notes="")
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String index() {
        logger.debug("Logger Level ：DEBUG");
        logger.info("Logger Level ：INFO");
        logger.error("Logger Level ：ERROR");
        String resp = restTemplate.getForObject("http://www.baidu.com", String.class);
        logger.info(resp);
        return "Hello World";
    }


    @ApiOperation(value="默认页面", notes="")
    @RequestMapping(value="/helloJson", method=RequestMethod.GET)
    public Response jsonSample() {
        HelloRespBean respBean = new HelloRespBean();
        respBean.setFoo("Foo String");
        respBean.setBar(1024);
        respBean.setMoney(100000000.0f);
        Response response = new Response();
        response.setContent(respBean);
        response.setCode(200);
        return response;
    }


    @ApiOperation(value="默认页面", notes="")
    @RequestMapping(value="/helloJson/{id}", method=RequestMethod.GET)
    public Response jsonSample(@PathVariable Long id) throws Exception {
        if(id>100 && id<200){
            throw new Exception("发生错误");
        }else if(id>=200){
            throw new MyException("发生错误2");
        }
        HelloRespBean respBean = new HelloRespBean();
        respBean.setFoo("Foo String");
        respBean.setBar(1024);
        respBean.setMoney(100000000.0f);
        Response response = new Response();
        response.setContent(respBean);
        response.setCode(200);
        return response;
    }


}
