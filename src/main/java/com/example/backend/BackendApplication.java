package com.example.backend;

import com.example.backend.redis.RedisPublisher;
import com.example.backend.redis.dto.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.Admin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(BackendApplication.class, args);
        Environment environment = context.getEnvironment();
        Admin kafkaAdminClient = context.getBean(Admin.class);
        RedisPublisher redisPublisher = context.getBean(RedisPublisher.class);
        Long a = redisPublisher.publish(new OrderEvent(1, 2, "a", 12, 5));


    }
}
