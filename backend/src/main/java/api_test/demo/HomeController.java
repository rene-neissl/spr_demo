package api_test.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class HomeController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Rene", "Neissl", 24));
        persons.add(new Person(2, "Erich", "Kainz", 12));

        return persons;
    }
}
