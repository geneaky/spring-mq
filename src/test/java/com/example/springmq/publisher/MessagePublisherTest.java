package com.example.springmq.publisher;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessagePublisherTest {
    
    @Autowired
    private MessagePublisher messagePublisher;
    
    @Test
    public void 메시지_발송() throws Exception{
        messagePublisher.publish("hihihih");
        Thread.sleep(1000L);
    }
}