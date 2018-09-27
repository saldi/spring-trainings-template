package lab.spring.cepik.driver.repository;

import lab.spring.cepik.driver.DefaultDriverService;
import lab.spring.cepik.driver.Driver;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DefaultDriverRepository implements DriverRepository {

    private JdbcTemplate jdbcTemplate;

    public DefaultDriverRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Driver driver) {

        jdbcTemplate.update("insert into driver (pesel, first_name, last_name, birth_date) " +
                        "values (?, ?, ?, ?)", driver.getPesel(), driver.getFirstName(),
                driver.getLastName(), driver.getBirthDate());
        System.out.println(driver);
    }

    @Override
    public List<Driver> selectAll() {
        return jdbcTemplate.query("select * from driver", new RowMapper<Driver>() {
            @Override
            public Driver mapRow(ResultSet resultSet, int i) throws SQLException {
                Driver driver = new Driver(
                        resultSet.getString("pesel"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("birth_date")
                );
                driver.setId(resultSet.getLong("id"));
                return driver;
            }
        });


    }
}
