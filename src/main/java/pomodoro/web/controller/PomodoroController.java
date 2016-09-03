package pomodoro.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pomodoro.service.PomodoroService;

@Controller
public class PomodoroController {

    @Autowired
    private PomodoroService pomodoroService;

}
