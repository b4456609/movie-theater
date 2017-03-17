package ntou.soselab.movie.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
public class BookResultDTO {
    private boolean success;
    private String reason;

    @Tolerate
    BookResultDTO(){}
}
