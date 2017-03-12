package ntou.soselab.movie.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Show {
    String id;
    String theaterId;
    String movieId;
    long start;
    long end;
    int emptySeat;
}
