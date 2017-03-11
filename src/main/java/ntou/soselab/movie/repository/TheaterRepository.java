package ntou.soselab.movie.repository;

import ntou.soselab.movie.model.Theater;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TheaterRepository extends MongoRepository<Theater, String> {
}
