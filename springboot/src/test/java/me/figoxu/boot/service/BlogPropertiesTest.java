package me.figoxu.boot.service;

import me.figoxu.boot.BaseSpringTest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BlogPropertiesTest extends BaseSpringTest {


    private static final Log log = LogFactory.getLog(BlogPropertiesTest.class);

    @Autowired
    private BlogProperties blogProperties;


    @Test
    public void test1() throws Exception {
        Assert.assertEquals("Figo.xu", blogProperties.getName());
        Assert.assertEquals("Spring Boot练习", blogProperties.getTitle());
        Assert.assertEquals("Figo.xu正在努力写《Spring Boot练习》", blogProperties.getDesc());

        log.info("随机数测试输出：");
        log.info("随机字符串 : " + blogProperties.getValue());
        log.info("随机int : " + blogProperties.getNumber());
        log.info("随机long : " + blogProperties.getBignumber());
        log.info("随机10以下 : " + blogProperties.getTest1());
        log.info("随机10-20 : " + blogProperties.getTest2());

    }
}
