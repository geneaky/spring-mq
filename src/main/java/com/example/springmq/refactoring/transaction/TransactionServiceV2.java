package com.example.springmq.refactoring.transaction;

import com.example.springmq.*;
import com.example.springmq.publisher.MessagePublisher;
import com.example.springmq.refactoring.transaction.events.TransactionCreatedTaskEvent;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceV2 {

    private final TransactionV2Manager transactionManager;
    private final MessagePublisher messagePublisher;
    
    public TransactionServiceV2(TransactionV2Manager transactionManager, MessagePublisher messagePublisher) {
        this.transactionManager = transactionManager;
        this.messagePublisher = messagePublisher;
    }
    
    public void send() {
        //핵심 비지니스 로직
        
        //수취인 정보 검증
        //거래 생성
        Transaction transaction = Transaction.builder()
            .exchangeRate(BigDecimal.valueOf(1328.12))
            .krwFee(BigDecimal.valueOf(5000))
            .toCountryId(2L)
            .toCurrencyId(2L)
            .build();
        
        transactionManager.save(transaction);

/*
        if(1==1) {
            throw new RuntimeException("test");
        }
*/

        //3개의 외부 api 호출을 1개로 묶어서 응답을 기대하지 않고 thread를 종료
        messagePublisher.publish(new TransactionCreatedTaskEvent("test@gmail.com", "01012341234", "test@channel", "송금 신청 완료"));
    }
}
