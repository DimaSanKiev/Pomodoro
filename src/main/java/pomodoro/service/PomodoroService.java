package pomodoro.service;

import pomodoro.model.Pomodoro;

import java.util.List;

public interface PomodoroService {

    List<Pomodoro> findAll();

    Pomodoro findById(Long id);

    void save(Pomodoro pomodoro);

    void delete(Pomodoro pomodoro);
}
