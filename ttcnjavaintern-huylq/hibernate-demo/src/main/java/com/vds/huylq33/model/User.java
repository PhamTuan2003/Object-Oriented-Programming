package com.vds.huylq33.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(
        cascade = CascadeType.ALL
    )
    private Address address;

    @OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL
    )
    @ToString.Exclude
    private Set<Account> accounts = new HashSet<>();

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public void addAccount(Account... accounts) {
        this.accounts.addAll(Arrays.asList(accounts));
        Arrays.asList(accounts).forEach(account -> account.setUser(this));
    }
}
