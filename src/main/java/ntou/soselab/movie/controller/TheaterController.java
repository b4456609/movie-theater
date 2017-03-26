package ntou.soselab.movie.controller;

import feign.Body;
import ntou.soselab.movie.controller.dto.BookRequestDTO;
import ntou.soselab.movie.controller.dto.BookResultDTO;
import ntou.soselab.movie.controller.dto.TimeTableDTO;
import ntou.soselab.movie.model.Show;
import ntou.soselab.movie.model.Theater;
import ntou.soselab.movie.repository.ShowRepository;
import ntou.soselab.movie.repository.TheaterRepository;
import ntou.soselab.movie.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class TheaterController {
    private final ShowService showService;
    private final TheaterRepository theaterRepository;
    private final ShowRepository showRepository;

    @Autowired
    public TheaterController(ShowService showService, TheaterRepository theaterRepository,
                             ShowRepository showRepository) {
        this.showService = showService;
        this.theaterRepository = theaterRepository;
        this.showRepository = showRepository;
    }

    @GetMapping("/timetable")
    public List<TimeTableDTO> getTimetable(@RequestParam(value = "q", required = false) String name) {
        List<TimeTableDTO> timeTable = showService.getTimeTable();
        if(name == null){
            return timeTable;
        }
        return timeTable.stream()
                .filter(item -> item.getMovieName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{theaterId}")
    public Theater getTheaterDetail(@PathVariable("theaterId") String theaterId) {
        return theaterRepository.findOne(theaterId);
    }

    @GetMapping("/show/{showId}")
    public Show getShowDetail(@PathVariable("showId") String showId) {
        return showRepository.findOne(showId);
    }

    @PostMapping("/book")
    public BookResultDTO bookTickets(@RequestBody BookRequestDTO bookRequestDTO){
        return showService.bookTickets(bookRequestDTO);
    }

    @PostMapping("/show")
    public Show addShow(@RequestBody Show showDTO){
        showDTO.setId(UUID.randomUUID().toString());
        showRepository.save(showDTO);
        return showDTO;
    }

    @PostMapping("/")
    public Theater addTheater(@RequestBody Theater theaterDTO){
        theaterRepository.save(theaterDTO);
        return theaterDTO;
    }
}
