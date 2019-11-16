package main.models;
import java.util.*;

public class Event {

    public Calendar startTime;
    public String title;
    public int duration;

    public Event(String title, Calendar StartTime, int duration){
        this.title = title;
        this.startTime = startTime;
        this.duration = duration;
    }

}
