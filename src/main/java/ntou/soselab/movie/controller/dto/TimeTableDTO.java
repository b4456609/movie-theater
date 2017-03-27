package ntou.soselab.movie.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
public class TimeTableDTO {
    private String theaterId;
    private String movieName;
    private String runTime;
    private long start;
    private int emptySeat;

    @Tolerate
    TimeTableDTO(){}
}
