package com.example.backend.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;


@RequiredArgsConstructor
public class RedisSubscriber implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("sub2");
        System.out.println(new String(message.getBody()));
        System.out.println(new String(message.getChannel()));
    }
}
