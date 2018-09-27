package lab.spring.cepik.driver.repository;

import lab.spring.cepik.driver.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaDataDriverRepository
        extends JpaRepository<Driver, Long> {


    @Query("select d from Driver d where d.firstName=:firstName")
    List<Driver> selectByFirstName(@Param("firstName") String firstName);


    List<Driver> findAllByFirstNameOrderByLastName(String firstName);


}
