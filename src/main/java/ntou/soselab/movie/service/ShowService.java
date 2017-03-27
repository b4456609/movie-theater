package ntou.soselab.movie.service;

import lombok.extern.slf4j.Slf4j;
import ntou.soselab.movie.client.MovieClient;
import ntou.soselab.movie.client.dto.MovieDTO;
import ntou.soselab.movie.controller.dto.BookRequestDTO;
import ntou.soselab.movie.controller.dto.BookResultDTO;
import ntou.soselab.movie.controller.dto.TimeTableDTO;
import ntou.soselab.movie.model.Show;
import ntou.soselab.movie.repository.ShowRepository;
import ntou.soselab.movie.repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ShowService {

    private final ShowRepository showRepository;
    private final TheaterRepository theaterRepository;
    private final MovieClient movieClient;

    public ShowService(ShowRepository showRepository, TheaterRepository theaterRepository, MovieClient movieClient) {
        this.showRepository = showRepository;
        this.theaterRepository = theaterRepository;
        this.movieClient = movieClient;
    }

    public List<TimeTableDTO> getTimeTable() {
        List<Show> all = showRepository.findAll();
        List<TimeTableDTO> timeTableDTOS = new ArrayList<>();
        for (Show show : all) {
            log.info("get movie id {}", show.getMovieId());
            MovieDTO movieDetail = movieClient.getMovieDetail(show.getMovieId());
            log.info("{}", movieDetail);
            TimeTableDTO build = TimeTableDTO.builder()
                    .movieName(movieDetail.getTitle())
                    .runTime(movieDetail.getRunTime())
                    .theaterId(show.getTheaterId())
                    .start(show.getStart())
                    .emptySeat(show.getEmptySeat())
                    .build();
            timeTableDTOS.add(build);
        }
        return timeTableDTOS;
    }

    public BookResultDTO bookTickets(BookRequestDTO bookRequestDTO) {
        Show show = showRepository.findOne(bookRequestDTO.getShowId());
        if(show.getEmptySeat() < bookRequestDTO.getTickets()) throw new NotEnoughSeatException("Not Enough Seat");
        return BookResultDTO.builder()
                .success(true)
                .reason("")
                .build();
    }
}
