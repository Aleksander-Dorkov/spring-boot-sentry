package com.example.backend.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.example.backend.kafka.KafkaConfiguration.TOPIC_1;

@Service
@RequiredArgsConstructor
public class Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void topic1(String topic, String msg) {
        this.kafkaTemplate.send(TOPIC_1, "", msg);

        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, msg);
        kafkaTemplate.send(producerRecord);

    }
}

