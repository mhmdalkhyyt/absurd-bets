package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int betId;

    private int userId;

    private Long amount;


    public Bets() {
    }

    public Bets(int betId, int userId, Long amount) {
        this.betId = betId;
        this.userId = userId;
        this.amount = amount;

    }

    public int getBetId() {
        return betId;
    }

    public void setBetId(int betId) {
        this.betId = betId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }


}