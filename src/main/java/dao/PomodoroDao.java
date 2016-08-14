package dao;

import model.Pomodoro;
import org.springframework.data.repository.CrudRepository;

public interface PomodoroDao extends CrudRepository<Pomodoro, Long> {
}
