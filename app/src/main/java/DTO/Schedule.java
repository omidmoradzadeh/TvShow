package DTO;

import java.util.List;


public class Schedule
{
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    String time;

    public List<String> getDays() {
        return this.days;
    }
    public void setDays(List<String> days) {
        this.days = days;
    }
    List<String> days;

}
