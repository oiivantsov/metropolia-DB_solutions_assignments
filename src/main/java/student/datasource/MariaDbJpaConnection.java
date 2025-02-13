package student.datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

// connection to MariaDB using JPA
public class MariaDbJpaConnection {

    // actually configure the connection based in the persistence.xml file
    // singleton pattern
    private static EntityManagerFactory emf;

    private static synchronized void initializeFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("DbSolutionsCourseMariaDbUnit");
        }
    }

    // get the entity manager - the connection to the database and execute the queries
    public static EntityManager getInstance() {
        initializeFactory();
        return emf.createEntityManager();
    }

    // close the connection
    public static void closeFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
