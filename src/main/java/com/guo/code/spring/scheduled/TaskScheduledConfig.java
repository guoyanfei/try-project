package com.guo.code.spring.scheduled;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by gyf .
 * 16/7/28 .
 */
@Configuration
@ComponentScan("com.guo.code.spring.scheduled")
@EnableScheduling
public class TaskScheduledConfig {
}
