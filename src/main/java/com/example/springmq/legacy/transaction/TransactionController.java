package com.example.springmq.legacy.transaction;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

        private final TransactionService transactionService;

        public TransactionController(TransactionService transactionService) {
            this.transactionService = transactionService;
        }

        @PostMapping("/send")
        public void send() {
            transactionService.send();
        }
}
