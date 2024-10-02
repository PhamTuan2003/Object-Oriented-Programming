package com.vds.huylq33.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer id;

    @Column
    private String name;

    @OneToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    private Wallet wallet;

    public Person(String name) {
        this.name = name;
    }
}
