package lab.spring.mvc;

import lab.spring.cepik.driver.DriverService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/driver")
public class DriverController {

    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Map model){
        model.put("drivers", driverService.selectAll());

        return "driver/list";
    }



}
