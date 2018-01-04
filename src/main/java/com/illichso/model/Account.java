package com.illichso.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.NONE;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"user"})
@ToString(exclude = {"user"})
@NoArgsConstructor
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Setter(NONE)
    private long id;

    private String number;

    private BigDecimal amount;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId", nullable = false)
    @JsonIgnore
    private User user;

    public Account(long id, String number) {
        this.id = id;
        this.number = number;
    }

    public Account(String number, User user) {
        this.number = number;
        this.user = user;
    }
}
