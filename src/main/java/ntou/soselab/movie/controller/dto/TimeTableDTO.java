package ntou.soselab.movie.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TimeTableDTO {
    private String theaterId;
    private String movieName;
    private String runTime;
    private long start;
}
