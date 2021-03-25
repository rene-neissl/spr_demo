package api_test.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@RestController
public class HomeController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
