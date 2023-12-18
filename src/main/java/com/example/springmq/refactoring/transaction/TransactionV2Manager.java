package com.example.springmq.refactoring.transaction;

import com.example.springmq.Transaction;
import com.example.springmq.TransactionRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionV2Manager {
    private final TransactionRepository transactionRepository;
    
    public TransactionV2Manager(TransactionRepository transactionRepository) {this.transactionRepository = transactionRepository;}
    
    @Transactional
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
