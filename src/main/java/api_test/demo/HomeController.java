package api_test.demo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
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

    @GetMapping("/github")
    public GithubDetails test() throws IOException {
      //Create HttpURLConnection
      URL url = new URL("https://api.github.com/users/malthee");
      HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
      httpcon.addRequestProperty("User-Agent", "Mozilla/5.0");
      httpcon.setRequestMethod("GET");
      httpcon.connect();

      int responsecode = httpcon.getResponseCode();

      if (responsecode != 200) {
          throw new RuntimeException("HttpResponseCode: " + responsecode);
      } else {
          ObjectMapper objectMapper = new ObjectMapper();
          objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

          return objectMapper.readValue(url, GithubDetails.class);
      }
  }
}
