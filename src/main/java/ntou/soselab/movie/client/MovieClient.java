package ntou.soselab.movie.client;

import ntou.soselab.movie.client.dto.MovieDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("movie")
public interface MovieClient {
    @RequestMapping(method = RequestMethod.GET, path = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    MovieDTO getMovieDetail(@PathVariable("id") String id);
}
