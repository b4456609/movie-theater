package ntou.soselab.movie.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResultDTO {
    private boolean success;
    private String reason;
}
