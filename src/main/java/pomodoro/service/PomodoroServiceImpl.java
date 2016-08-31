package pomodoro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pomodoro.dao.PomodoroDao;
import pomodoro.model.Pomodoro;
import pomodoro.service.exception.PomodoroNotFoundException;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
    public void togglePlay(Pomodoro pomodoro) {
        pomodoro.setPaused(!pomodoro.isPaused());
    }

    @Override
    public void countdown(Pomodoro pomodoro) {
        final Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            int remainingTime = pomodoro.getRemainingTime();

            @Override
            public void run() {
                System.out.println(remainingTime--);

                if (pomodoro.isPaused()) {
                    timer.cancel();
                }

                if (remainingTime < 0) {
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }
}
