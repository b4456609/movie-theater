package ntou.soselab.movie.client;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import ntou.soselab.movie.client.dto.MovieDTO;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class MovieClientTest {

    @Rule
    public PactProviderRule mockProvider = new PactProviderRule("movie", "localhost", 8085, this);

    @Autowired
    private MovieClient movieClient;

    private final String movieId = "5ef2bf0d-6dbf-4de8-a095-93690854da5b";

    @Test
    @PactVerification
    public void getMovieDetail() throws Exception {
        MovieDTO movieDetail = movieClient.getMovieDetail(movieId);
        assertThat(movieDetail)
                .hasFieldOrPropertyWithValue("title", "La La Land")
                .hasFieldOrPropertyWithValue("rated", "PG-13")
                .hasFieldOrPropertyWithValue("runTime", "128 min");
    }


    @Pact(consumer = "theater")
    public PactFragment createFragment(PactDslWithProvider builder) {
        JSONObject jsonObject = new JSONObject("{\n" +
                "  \"title\": \"La La Land\",\n" +
                "  \"year\": \"2016\",\n" +
                "  \"rated\": \"PG-13\",\n" +
                "  \"runTime\": \"128 min\",\n" +
                "  \"genre\": \"Comedy, Drama, Musical\",\n" +
                "  \"director\": \"Damien Chazelle\",\n" +
                "  \"actors\": \"Ryan Gosling, Emma Stone, Amiée Conn, Terry Walters\",\n" +
                "  \"plot\": \"A jazz pianist falls for an aspiring actress in Los Angeles.\"\n" +
                "}");
        return builder
                .given(String.format("The La la land exists in db And id is '%s'", movieId))
                .uponReceiving("Get la la land movie detail")
                    .path("/id/" + movieId)
                    .method("GET")
                .willRespondWith()
                    .status(200)
                    .body(jsonObject)
                .toFragment();
    }
}