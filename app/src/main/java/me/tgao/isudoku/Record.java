package me.tgao.isudoku;

import java.time.Duration;
import java.time.LocalDate;

public class Record {
    private Duration time;
    private LocalDate date;

    public Record(Duration time, LocalDate date) {
        this.time = time;
        this.date = date;
    }

    public Duration getTime() {
        return time;
    }

    public void setTime(Duration time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // format time used to solve sudoku puzzle in seconds to HH:MM:SS
    public String getTimeString() {
        long seconds = time.getSeconds();
        String durationStr = String.format(
                "%d:%02d:%02d",
                seconds / 3600,
                (seconds % 3600) / 60,
                seconds % 60);
        return durationStr;
    }
}
