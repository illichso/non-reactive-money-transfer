package com.illichso.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

@Entity
@Data
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;

    private String number;

    private BigDecimal amount;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId", nullable = false)
    @JsonIgnore
    private User user;

    public Account() {
    }

    public Account(long id, String number) {
        this.id = id;
        this.number = number;
    }

    public Account(String number, User user) {
        this.number = number;
        this.user = user;
    }

    public Account(User user) {
        this.user = user;
        generateAccountNumber();
        setDefaultAmount();
    }

    private void setDefaultAmount() {
        amount = BigDecimal.ZERO;
    }

    private void generateAccountNumber() {
        number = randomAlphanumeric(20);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (number != null ? !number.equals(account.number) : account.number != null) return false;
        return amount != null ? amount.equals(account.amount) : account.amount == null;
    }

    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
