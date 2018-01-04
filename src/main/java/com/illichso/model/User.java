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
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.NONE;

@Entity
@Getter
@Setter
@ToString(exclude = {"accounts"})
@EqualsAndHashCode(exclude = {"accounts"})
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Setter(NONE)
    private long id;

    private String name;

    @OneToMany(cascade = ALL, mappedBy = "user", fetch = LAZY)
    @JsonIgnore
    private Set<Account> accounts;


    public User(String name) {
        this.name = name;
    }

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

}
