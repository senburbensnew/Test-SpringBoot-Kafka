package com.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    private final WebSocketController webSocketController;

    public ConsumerService(WebSocketController webSocketController) {
        this.webSocketController = webSocketController;
    }

    @KafkaListener(topics = "test_topic", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
        webSocketController.sendMessageToWebSocket(message); // Send the Kafka message to WebSocket clients
    }
}