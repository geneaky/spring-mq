package com.example.springmq.legacy.transaction;

import static org.junit.jupiter.api.Assertions.*;

import com.example.springmq.IntegrationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@Rollback(value = false)
@Transactional
class TransactionServiceTest extends IntegrationTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    @DisplayName("송금 신청 테스트")
    void send() throws Exception {
        transactionService.send();
    }
}