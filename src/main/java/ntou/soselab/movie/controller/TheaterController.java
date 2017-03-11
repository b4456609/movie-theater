package ntou.soselab.movie.controller;

import ntou.soselab.movie.controller.dto.BookRequestDTO;
import ntou.soselab.movie.controller.dto.BookResultDTO;
import ntou.soselab.movie.controller.dto.TimeTableDTO;
import ntou.soselab.movie.model.Show;
import ntou.soselab.movie.model.Theater;
import ntou.soselab.movie.repository.ShowRepository;
import ntou.soselab.movie.repository.TheaterRepository;
import ntou.soselab.movie.service.ShowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TheaterController {
    private final ShowService showService;
    private final TheaterRepository theaterRepository;
    private final ShowRepository showRepository;

    public TheaterController(ShowService showService, TheaterRepository theaterRepository, ShowRepository showRepository) {
        this.showService = showService;
        this.theaterRepository = theaterRepository;
        this.showRepository = showRepository;
    }

    @GetMapping("/theater/timetable")
    public List<TimeTableDTO> getTimetable() {
        return showService.getTimeTable();
    }

    @GetMapping("/theater/{theaterId}")
    public Theater getTheaterDetail(@PathVariable("theaterId") String theaterId) {
        return theaterRepository.findOne(theaterId);
    }

    @GetMapping("/theater/show/{showId}")
    public Show getShowDetail(@PathVariable("showId") String showId) {
        return showRepository.findOne(showId);
    }

    @PostMapping("/theater/book")
    public BookResultDTO bookTickets(@RequestBody BookRequestDTO bookRequestDTO){
        return showService.bookTickets(bookRequestDTO);
    }
//    GET /theater/timetable 電影時刻表
//    GET /theater/{theatherId} 電影廳資訊
//    GET /theater/show/{showId} 電影廳該場次資訊
//    POST /theater/book/{showId} 預約座位

}
