package ntou.soselab.movie.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class NotEnoughSeatException extends RuntimeException {
    public NotEnoughSeatException(String message) {
        super(message);
    }
}
