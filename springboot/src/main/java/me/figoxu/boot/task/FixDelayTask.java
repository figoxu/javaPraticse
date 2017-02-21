package me.figoxu.boot.task;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FixDelayTask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(fixedDelay = 6000)
    public void reportCurrentTime() throws InterruptedException {
        logger.info("FixedDelay Task Execute");
        Thread.sleep(1000*3);
    }
}
