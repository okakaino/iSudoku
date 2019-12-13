package me.tgao.isudoku;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    public String getTimeString() {
        String durationStr = String.format(
                "%d:%02d:%02d",
                time / 3600,
                (time % 3600) / 60,
                time % 60);
        return durationStr;
    }

    public String getDateString() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("Date in record is: " + getDate());
        Date date = new Date(getDate() * 1000L);
        return sf.format(date);
    }
}
