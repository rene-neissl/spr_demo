package api_test.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  //@GetMapping()
  /*public JSONObject test() throws IOException {
      //Create HttpURLConnection
      URL url = new URL("https://api.github.com/repos/rene-neissl/spr_demo");
      HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
      httpcon.addRequestProperty("User-Agent", "Mozilla/5.0");
      httpcon.setRequestMethod("GET");
      httpcon.connect();

      int responsecode = httpcon.getResponseCode();

      if (responsecode != 200) {
          throw new RuntimeException("HttpResponseCode: " + responsecode);
      } else {
          String inline = "";
          Scanner scanner = new Scanner(url.openStream());

          while (scanner.hasNext()) {
              inline += scanner.nextLine();
          }

          //Close scanner
          scanner.close();
          //JSONObject data_obj = (JSONObject) parse.parse(inline);

          return (JSONObject) parse.parse(inline);
      }
  }

    @GetMapping("/issues")
    public JSONArray issues() throws IOException, ParseException {
        //Create HttpURLConnection
        URL url = new URL("https://api.github.com/repos/microsoft/Web-Dev-For-Beginners/issues");
        HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
        httpcon.setRequestMethod("GET");
        httpcon.connect();

        int responsecode = httpcon.getResponseCode();

        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {
            String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }

            //Close scanner
            scanner.close();

            //Parse string into json
            JSONParser parse = new JSONParser();
            return (JSONArray) parse.parse(inline);
        }
    }*/
}
