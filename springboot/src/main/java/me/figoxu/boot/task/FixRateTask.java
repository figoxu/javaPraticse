package me.figoxu.boot.task;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FixRateTask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() throws InterruptedException {
        logger.info("FixedRate Task Execute");
        Thread.sleep(1000*3);
    }
}
