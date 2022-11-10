package kz.iitu.itse1905.komekbay.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.time.LocalTime;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Scheduled(fixedDelayString = "${fixed.delay}",initialDelayString = "${initial.delay}")
    public void sendFixedDelayMessage(){
        System.out.println(LocalTime.now() + "This is a fixedDelay Message with initialDelay");
    }

    @Scheduled(fixedRateString = "${fixed.rate}",initialDelayString = "${initial.delay}")
    public void sendFixedRateMessage(){
        System.out.println(LocalTime.now() + "It is a fixedRate Message");
    }

    @Bean(destroyMethod="shutdown")
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(100);
    }



}
