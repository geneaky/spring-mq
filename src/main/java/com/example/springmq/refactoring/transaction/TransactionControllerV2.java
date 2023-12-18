package com.example.springmq.refactoring.transaction;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/transaction")
public class TransactionControllerV2 {
    
    private final TransactionServiceV2 transactionServiceV2;
    
    public TransactionControllerV2(TransactionServiceV2 transactionServiceV2) {this.transactionServiceV2 = transactionServiceV2;}
    
    @PostMapping("/send")
    public void send() {
        transactionServiceV2.send();
    }
    
}
