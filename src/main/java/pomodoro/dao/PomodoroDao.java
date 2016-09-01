package pomodoro.dao;

import org.springframework.data.repository.CrudRepository;
import pomodoro.model.Pomodoro;

import java.util.List;

public interface PomodoroDao extends CrudRepository<Pomodoro, Long> {

    List<Pomodoro> findAll();

}
