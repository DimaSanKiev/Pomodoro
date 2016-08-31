package pomodoro.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pomodoro.model.Pomodoro;
import pomodoro.service.PomodoroService;

@Controller
public class PomodoroController {

    @Autowired
    private PomodoroService pomodoroService;

    @RequestMapping({"/", "/pomodoro"})
    public String pomodorosList(Model model) {
        Iterable<Pomodoro> pomodoros = pomodoroService.findAll();
        model.addAttribute("pomodoros", pomodoros);
        model.addAttribute("newPomodoro", new Pomodoro());
        return "pomodoro";
    }
}
