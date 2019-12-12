package me.tgao.isudoku;

import java.time.Duration;
import java.time.LocalDate;

public class Record {
    private long time;
    private long date;

    public Record(long time, long date) {
        this.time = time;
        this.date = date;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    // format time used to solve sudoku puzzle in seconds to HH:MM:SS
//    public String getTimeString() {
//        long seconds = time.getSeconds();
//        String durationStr = String.format(
//                "%d:%02d:%02d",
//                seconds / 3600,
//                (seconds % 3600) / 60,
//                seconds % 60);
//        return durationStr;
//    }
}
