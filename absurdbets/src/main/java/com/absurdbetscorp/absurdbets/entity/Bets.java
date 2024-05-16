package com.absurdbetscorp.absurdbets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Bets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String betDescription;
    private long userId;

    public Bets() {
        // Default constructor for JPA
    }

    public Bets(String betDescription, long userId) {
        this.betDescription = betDescription;
        this.userId = userId;
    }

    public String getBetDescription() {
        return betDescription;
    }

    public void setBetDescription(String betDescription) {
        this.betDescription = betDescription;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
