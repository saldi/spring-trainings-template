package lab.spring.cepik.driver.repository;

import lab.spring.cepik.driver.Driver;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Primary
public class JpaDriverRepository implements DriverRepository {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional()
    public void save(Driver driver) {
        entityManager.persist(driver);
    }

    @Override
    public List<Driver> selectAll() {
        Query query = entityManager.createQuery("select d from Driver d");
        return query.getResultList();
    }
}
