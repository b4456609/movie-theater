package ntou.soselab.movie.repository;

import ntou.soselab.movie.model.Show;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShowRepository extends MongoRepository<Show, String> {
}
