package com.example.backend.redis;


import com.example.backend.redis.dto.OrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisPublisher {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic channelTopic;

    public Long publish(OrderEvent orderEvent) {
        return redisTemplate.convertAndSend(channelTopic.getTopic(), orderEvent);
    }
}
