package kz.iitu.itse1905.komekbay.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;

class ScheduleConfigTest {
    ScheduleConfig scheduleConfig = new ScheduleConfig();

    @Test
    void testConfigureTasks() {
        ScheduledTaskRegistrar scheduledTaskRegistrar = new ScheduledTaskRegistrar();
        scheduleConfig.configureTasks(scheduledTaskRegistrar);
    }

    @Test
    void testSendFixedDelayMessage() {
        scheduleConfig.sendFixedDelayMessage();
    }

    @Test
    void testSendFixedRateMessage() {
        scheduleConfig.sendFixedRateMessage();
    }

    @Test
    void testTaskExecutor() {
        Executor result = scheduleConfig.taskExecutor();
        Assertions.assertNotNull( result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme