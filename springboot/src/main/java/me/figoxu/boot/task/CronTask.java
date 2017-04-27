package me.figoxu.boot.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CronTask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(cron = "0/12 * * * * ? ")
    void cronBusiness(){
        logger.info("CronTask Execute");
    }
}
