package api_test.demo;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

//This File is no longer needed, but kept for testing purpose
public class GitHubDeserializer extends StdDeserializer<GithubDetails> {
    public GitHubDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public GithubDetails deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {
        GithubDetails det = new GithubDetails();

        while(!parser.isClosed()) {
            JsonToken jsonToken = parser.nextToken();

            if(JsonToken.FIELD_NAME.equals(jsonToken)) {
                String fieldName = parser.getCurrentName();
                System.out.println(fieldName);

                jsonToken = parser.nextToken();

                if("followers".equals(fieldName)) {
                    det.setFollowers(parser.getValueAsInt());
                } else if ("login".equals(fieldName)) {
                    det.setLogin(parser.getValueAsString());
                }
            }
        }
        return det;
    }


}
