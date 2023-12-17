package com.example.springmq.legacy.transaction;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transaction {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private BigDecimal exchangeRate;
    private BigDecimal krwFee;
    private Long toCurrencyId;
    private Long toCountryId;

    @Builder
    private Transaction(Long id, BigDecimal exchangeRate, BigDecimal krwFee, Long toCurrencyId, Long toCountryId) {
        this.id = id;
        this.exchangeRate = exchangeRate;
        this.krwFee = krwFee;
        this.toCurrencyId = toCurrencyId;
        this.toCountryId = toCountryId;
    }
}
