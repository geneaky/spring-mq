package com.example.springmq.refactoring.transaction.events;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TransactionCreatedTaskEvent {
    
    private String email;
    private String phoneNumber;
    private String channel;
    private String content;
    
    public TransactionCreatedTaskEvent(String email, String phoneNumber, String channel, String content) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.channel = channel;
        this.content = content;
    }
}
