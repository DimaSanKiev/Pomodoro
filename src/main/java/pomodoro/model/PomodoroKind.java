package pomodoro.model;

public enum PomodoroKind {
    WORK(25 * 60, "Working time"),
    BREAK(5 * 60, "Break time");

    private int totalSeconds;
    private String name;

    PomodoroKind(int totalSeconds, String name) {
        this.totalSeconds = totalSeconds;
        this.name = name;
    }

    public int getTotalSeconds() {
        return totalSeconds;
    }

    public String getName() {
        return name;
    }
}
