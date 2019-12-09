package me.tgao.isudoku;

import java.time.Duration;
import java.time.LocalDateTime;

public class GameTimer {

    private static LocalDateTime startTime;
    private static LocalDateTime finishTime;

    private static GameTimer instance;

    private GameTimer() { }

    public static GameTimer getInstance() {
        if (instance == null) {
            instance = new GameTimer();
        }

        return instance;
    }

    public void start() {
        startTime = LocalDateTime.now();
    }

    public void finish() {
        finishTime = LocalDateTime.now();
    }

    public Duration getDuration() {
        System.out.print("Start time: ");
        System.out.println(startTime);
        System.out.print("Finish time: ");
        System.out.println(finishTime);
        return Duration.between(startTime, finishTime);
    }
}
