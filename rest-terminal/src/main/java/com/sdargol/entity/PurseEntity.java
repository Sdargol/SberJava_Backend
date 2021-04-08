package com.sdargol.entity;

import javax.persistence.*;

@Entity
@Table(name = "purse" )
public class PurseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer balance;

    public PurseEntity() {
    }

    public PurseEntity(Integer balance) {
        this.balance = balance;
    }

    public PurseEntity(Integer id, Integer balance) {
        this.id = id;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

}
