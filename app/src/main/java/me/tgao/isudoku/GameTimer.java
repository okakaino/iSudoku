package me.tgao.isudoku;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

public class GameTimer {

    private static long startTime;
    private static long finishTime;

    private static GameTimer instance;

    private GameTimer() { }

    public static GameTimer getInstance() {
        if (instance == null) {
            instance = new GameTimer();
        }

        return instance;
    }

    public void start() {
        startTime = Instant.now().getEpochSecond();
    }

    public void finish() {
        finishTime = Instant.now().getEpochSecond();
    }

    public Record getRecord() {
        Record record = new Record(finishTime - startTime, finishTime);
        return record;
    }
}
