package lab.spring.cepik.driver;

import lab.spring.cepik.aspect.Log;
import lab.spring.cepik.driver.events.DriverEventsEmitter;
import lab.spring.cepik.driver.repository.DriverRepository;
import lab.spring.cepik.driver.supports.DriverFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultDriverService implements DriverService {

    private DriverFactory driverFactory;

    private DriverEventsEmitter eventsEmitter;

    private DriverRepository driverRepository;

    public DefaultDriverService(DriverFactory driverFactory,
                                DriverEventsEmitter eventsEmitter,
                                DriverRepository driverRepository) {
        this.driverFactory = driverFactory;
        this.eventsEmitter = eventsEmitter;
        this.driverRepository = driverRepository;
    }

    @Transactional
    public Driver registerNewDriver(String pesel, String firstName, String lastName, String birthDate) {
        Driver driver = driverFactory.createDriver(pesel, firstName, lastName, birthDate);
        return driver;
    }

    @Override
    public List<Driver> selectAll() {
        return driverRepository.selectAll();
    }


}
