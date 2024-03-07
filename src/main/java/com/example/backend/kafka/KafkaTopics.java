package com.example.backend.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopics {

    public static final String TOPIC_1 = "test-topic-1";
    public static final String TOPIC_2 = "test-topic-2";

    @Bean
    public NewTopic singlePartitionTopic() {
        return TopicBuilder.name(TOPIC_1)
                .partitions(1)
                .replicas(3)
                .build();
    }

    @Bean
    public NewTopic multiPartitionTopic() {
        return TopicBuilder.name(TOPIC_2)
                .partitions(10)
                .replicas(3)
                .build();
    }
}
