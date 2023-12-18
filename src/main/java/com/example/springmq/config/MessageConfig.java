package com.example.springmq.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MessageConfig {
    
    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if(!ack) {
                Message message = correlationData.getReturned().getMessage();
                byte[] body = message.getBody();
                
            }
        });
        
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        
        return rabbitTemplate;
    }
}
