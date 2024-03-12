package com.example.backend.redis.dto;

import lombok.Builder;

@Builder
public record OrderEvent(
        int orderId,
        int userId,
        String productName,
        int price,
        int quantity) {

}
