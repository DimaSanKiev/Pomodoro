package pomodoro.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pomodoro.model.Pomodoro;
import pomodoro.model.PomodoroKind;
import pomodoro.service.PomodoroService;

@Controller
public class PomodoroController {

    @Autowired
    private PomodoroService pomodoroService;

    @RequestMapping(path = "/toggle", method = RequestMethod.POST, params = "action=play")
    public String play(@RequestParam Long id) {
        Pomodoro pomodoro = pomodoroService.findById(id);
        if (pomodoro == null) {
            pomodoro = new Pomodoro(PomodoroKind.WORK);
            pomodoroService.save(pomodoro);
        }
        pomodoroService.togglePlay(pomodoro);
        pomodoroService.countdown(pomodoro);
        return "redirect:/";
    }

    @RequestMapping(path = "/toggle", method = RequestMethod.POST, params = "action=cancel")
    public String cancel(@RequestParam Long id) {
        Pomodoro pomodoro = pomodoroService.findById(id);
        pomodoroService.togglePlay(pomodoro);
        pomodoroService.countdown(pomodoro);
        return "redirect:/";
    }
}
