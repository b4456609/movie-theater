package ntou.soselab.movie.controller;

import ntou.soselab.movie.repository.ShowRepository;
import ntou.soselab.movie.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UATController {
    private final ShowRepository showRepository;
    private final TheaterRepository theaterRepository;

    @Autowired
    public UATController(ShowRepository showRepository, TheaterRepository theaterRepository) {
        this.showRepository = showRepository;
        this.theaterRepository = theaterRepository;
    }

    @DeleteMapping("/reset")
    public void resetDB() {
        showRepository.deleteAll();
        theaterRepository.deleteAll();
    }
}
