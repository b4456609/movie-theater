package ntou.soselab.movie.model;

import lombok.Data;

@Data
public class Show {
    String id;
    String theaterId;
    String movieId;
    long start;
    long end;
    int emptySeat;
}
