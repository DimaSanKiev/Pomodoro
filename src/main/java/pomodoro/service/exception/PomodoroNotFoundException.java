package pomodoro.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PomodoroNotFoundException extends RuntimeException {
    public PomodoroNotFoundException() {
        super("Pomodoro not found.");
    }
}
