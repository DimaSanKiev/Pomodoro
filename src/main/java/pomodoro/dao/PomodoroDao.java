package pomodoro.dao;

import pomodoro.model.Pomodoro;
import org.springframework.data.repository.CrudRepository;

public interface PomodoroDao extends CrudRepository<Pomodoro, Long> {
}
