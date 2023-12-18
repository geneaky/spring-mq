package com.example.springmq.legacy.transaction;

import com.example.springmq.Transaction;
import com.example.springmq.TransactionRepository;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Transactional
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

        transactionRepository.save(transaction);


        //부가적인 로직 & 외부 api 호출

        //1. 신청 내역 이메일 발송
        sendEmail();
        //2. 신청 내역 SMS 발송
        sendSms();
        //3. 신청 내역 슬랙 발송
        sendSlack();

        //실패 조합
        // 1
        // 1, 2
        // 1, 2, 3
    }

    private void sendSlack() {
        throw new RuntimeException("슬랙 발송 실패");
    }

    private void sendSms() {
        throw new RuntimeException("SMS 발송 실패");
    }

    private void sendEmail() {
        throw new RuntimeException("이메일 발송 실패");
    }
}
