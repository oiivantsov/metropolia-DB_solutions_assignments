package student.dao;

import jakarta.persistence.*;
import student.datasource.MariaDbJpaConnection;
import student.model.TimeSpent;

public class TimeSpentDAO {

    public void addTimeSpent(TimeSpent timeSpent) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(timeSpent);
        tx.commit();
        em.close();
    }
}

