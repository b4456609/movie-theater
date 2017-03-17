package ntou.soselab.movie.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
public class BookRequestDTO {
    private String showId;
    private int tickets;

    @Tolerate
    BookRequestDTO(){}
}
