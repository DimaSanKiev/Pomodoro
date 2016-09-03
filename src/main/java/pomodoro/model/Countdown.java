package pomodoro.model;

import java.util.Timer;
import java.util.TimerTask;

public class Countdown {
    private final Timer timer = new Timer();

    public void countdown(int seconds) {
        timer.scheduleAtFixedRate(new TimerTask() {
            int remaining = seconds;

            @Override
            public void run() {
                remaining--;
                if (remaining < 0) {
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }

    public void cancel() {
        timer.cancel();
    }

}
