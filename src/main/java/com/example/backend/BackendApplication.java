package com.example.backend;

import com.example.backend.domain.entity.Course;
import com.example.backend.domain.entity.CourseType;
import com.example.backend.domain.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.ListTopicsOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Slf4j
@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(BackendApplication.class, args);
        Environment environment = context.getEnvironment();
        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        AdminClient adminClient = AdminClient.create(properties);
        ListTopicsOptions listTopicsOptions = new ListTopicsOptions();
        listTopicsOptions.listInternal(true);
        System.out.println("topics:" + adminClient.listTopics(listTopicsOptions).names().get());

    }
}
