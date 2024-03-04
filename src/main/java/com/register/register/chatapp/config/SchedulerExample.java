package com.register.register.chatapp.config;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class SchedulerExample {
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void scheduleTasks() {
        // Delayed execution after 5 seconds
        scheduler.schedule(() -> {
            System.out.println("Task executed after 5 seconds");
        }, 5, TimeUnit.SECONDS);

        // Periodic task with an initial delay of 2 seconds and repeated every 3 seconds
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Periodic task executed every 3 seconds");
        }, 2, 3, TimeUnit.SECONDS);

        // Shutdown the scheduler after 20 seconds (for demonstration purposes)
        scheduler.schedule(() -> {
            scheduler.shutdown();
        }, 20, TimeUnit.SECONDS);
}
}
