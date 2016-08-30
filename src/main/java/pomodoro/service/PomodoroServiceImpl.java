package pomodoro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pomodoro.dao.PomodoroDao;
import pomodoro.model.Pomodoro;

import java.util.List;

@Service
public class PomodoroServiceImpl implements PomodoroService {

    @Autowired
    private PomodoroDao pomodoroDao;

    @Override
    public List<Pomodoro> findAll() {
        return pomodoroDao.findAll();
    }

    @Override
    public Pomodoro findById(Long id) {
        Pomodoro pomodoro = pomodoroDao.findOne(id);
        if (pomodoro == null) {
            throw new PomodoroNotFoundException();
        }
        return pomodoro;
    }

    @Override
    public void save(Pomodoro pomodoro) {
        pomodoroDao.save(pomodoro);
    }

    @Override
    public void delete(Pomodoro pomodoro) {
        pomodoroDao.delete(pomodoro);
    }

    @Override
    public void play(Pomodoro pomodoro) {
        // TODO: 31.08.2016
    }

    @Override
    public void pause(Pomodoro pomodoro) {
        // TODO: 31.08.2016
    }
}
