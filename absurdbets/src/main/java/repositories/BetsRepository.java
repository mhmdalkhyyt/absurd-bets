package repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import models.Bets;


import java.util.List;

public class BetsRepository {

    private EntityManager entityManager;

    public BetsRepository() {
        var emf = Persistence.createEntityManagerFactory("default");
        entityManager = emf.createEntityManager();
    }

    public Bets getBetId(int id) {
        var bet = entityManager.find(Bets.class, id);
        return bet;
    }

    public List<Bets> getAllBets() {
        var query = entityManager.createQuery("SELECT p FROM Bets p", Bets.class);
        var indivBet = query.getResultList();
        return indivBet;
    }

    public void insert(Bets bet) {
        entityManager.getTransaction().begin();
        entityManager.persist(bet);
        entityManager.getTransaction().commit();
    }

    public void update(Bets bet) {
        entityManager.getTransaction().begin();
        entityManager.merge(bet);
        entityManager.getTransaction().commit();
    }

    public void delete(int id) {
        entityManager.getTransaction().begin();

        var queryString = "DELETE FROM Bets WHERE id=:id";
        var query = entityManager.createQuery(queryString);

        query.setParameter("id", id);

        query.executeUpdate();

        entityManager.getTransaction().commit();
    }
}
