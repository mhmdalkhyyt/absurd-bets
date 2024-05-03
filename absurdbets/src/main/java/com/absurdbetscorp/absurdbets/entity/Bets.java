package com.absurdbetscorp.absurdbets.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long betId;
    private Long userId;
    private double betAmount;

    // Constructors, getters, and setters

    public Bets() {
    }

    public Bets(Long userId, double betAmount) {
        this.userId = userId;
        this.betAmount = betAmount;
    }

    public Long getBetId() {
        return betId;
    }

    public void setBetId(Long betId) {
        this.betId = betId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(double betAmount) {
        this.betAmount = betAmount;
    }
}
