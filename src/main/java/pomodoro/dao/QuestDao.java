package pomodoro.dao;

import pomodoro.model.Quest;
import org.springframework.data.repository.CrudRepository;

public interface QuestDao extends CrudRepository<Quest, Long> {

    Quest findByName(String name);

}
