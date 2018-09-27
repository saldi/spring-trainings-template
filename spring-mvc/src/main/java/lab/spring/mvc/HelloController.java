package lab.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    public String hello(@RequestParam("message") String message,
                        Map model) {
        model.put("message", message);
        return "hello/helloWorld";
    }

    @RequestMapping(value = "/helloWorld/{message}", method = RequestMethod.GET)
    public String helloURI(@PathVariable("message") String message,
                        Map model) {
        model.put("message", message);
        return "hello/helloWorld";
    }


}
