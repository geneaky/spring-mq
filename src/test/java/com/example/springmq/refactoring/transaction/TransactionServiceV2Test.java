package com.example.springmq.refactoring.transaction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class TransactionServiceV2Test {
    
    @Autowired
    private TransactionServiceV2 transactionServiceV2;
    
    @Test
    public void send() throws Exception{
        transactionServiceV2.send();
        
        Thread.sleep(1000L);
    }
}