package api_test.demo;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@RestController
public class HomeController {

    public static void main(String[] args) {
        SpringApplication.run(HomeController.class, args);
    }

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
          StringBuilder inline = new StringBuilder();
          Scanner scanner = new Scanner(url.openStream());
          while (scanner.hasNext()) {
              inline.append(scanner.nextLine());
          }

          //Close scanner
          scanner.close();

          SimpleModule module =
                  new SimpleModule("GitHubDeserializer", new Version(3,1,8,null,null,null));
          module.addDeserializer(GithubDetails.class, new GitHubDeserializer(GithubDetails.class));

          ObjectMapper objectMapper = new ObjectMapper();
          objectMapper.registerModule(module);
          Reader reader = new StringReader(inline.toString());

          return objectMapper.readValue(reader, GithubDetails.class);
      }
  }
}
