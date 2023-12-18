package com.example.springmq.subscriber;

import com.example.springmq.refactoring.transaction.events.TransactionCreatedTaskEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageSubscriber {
    
    @RabbitListener(queues = "transaction_created_task")
    public void onTransactionCreatedEvent(TransactionCreatedTaskEvent transactionCreatedTaskEvent) {
        System.out.println(transactionCreatedTaskEvent.getEmail());
        System.out.println(transactionCreatedTaskEvent.getPhoneNumber());
        System.out.println(transactionCreatedTaskEvent.getChannel());
        System.out.println(transactionCreatedTaskEvent.getContent());
        //부가 로직 처리
    }
}
