package com.ecommerce;
import java.math.RoundingMode;

import java.math.BigDecimal;

public record Money(BigDecimal amount, String currency) {
     public Money {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount ne doit pas être null ou négatif");
        }

        if (!currency.equals("FCFA") && !currency.equals("EUR")) {
            throw new InvalidCurrencyException("Currency doit être soit FCFA ou EUR");
        }

        amount = amount.setScale(2, RoundingMode.HALF_UP);
    }

    public Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Impossible d'additionner des montants de devises différentes");
        }

        return new Money(this.amount.add(other.amount), this.currency);
    }

}
