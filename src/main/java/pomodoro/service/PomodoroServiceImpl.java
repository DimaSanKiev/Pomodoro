package pomodoro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pomodoro.dao.PomodoroDao;
import pomodoro.model.Pomodoro;
import pomodoro.model.PomodoroKind;

@Service
public class PomodoroServiceImpl implements PomodoroService {
    @Autowired
    private PomodoroDao pomodoroDao;

    @Override
    public void togglePlay(Pomodoro pomodoro) {
        // TODO: 04.09.2016
    }

    @Override
    public void cancel(Pomodoro pomodoro) {
        pomodoro.getCountdown().cancel();
        pomodoro = new Pomodoro(PomodoroKind.WORK);
    }

    /*@Override
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
    }*/
}
