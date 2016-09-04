package pomodoro.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Pomodoro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int remainingSeconds;
    private PomodoroKind kind;
    private Countdown countdown;
    private Date dateStart;
    private Date dateFinish;
    @Size(max = 50)
    private String comment;

    public Pomodoro(PomodoroKind kind) {
        this.kind = kind;
        remainingSeconds = kind.getTotalSeconds();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRemainingSeconds() {
        return remainingSeconds;
    }

    public void setRemainingSeconds(int remainingSeconds) {
        this.remainingSeconds = remainingSeconds;
    }

    public PomodoroKind getKind() {
        return kind;
    }

    public void setKind(PomodoroKind kind) {
        this.kind = kind;
    }

    public Countdown getCountdown() {
        return countdown;
    }

    public void setCountdown(Countdown countdown) {
        this.countdown = countdown;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
