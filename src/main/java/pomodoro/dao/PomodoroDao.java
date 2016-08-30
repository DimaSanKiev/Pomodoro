package pomodoro.dao;

import org.springframework.data.jpa.repository.Query;
import pomodoro.model.Pomodoro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PomodoroDao extends CrudRepository<Pomodoro, Long> {

    @Query("select p from Pomodoro p where p.user.id=:#{principal.id}")
    List<Pomodoro> findAll();

}
