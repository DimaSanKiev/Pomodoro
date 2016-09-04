package pomodoro.service;

import pomodoro.model.Pomodoro;

public interface PomodoroService {

    void togglePlay(Pomodoro pomodoro);

    void cancel(Pomodoro pomodoro);
}
