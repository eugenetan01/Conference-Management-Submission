package main.models;

import java.util.ArrayList;
import java.util.Calendar;

public class Session {

    public ArrayList<Event> events;
    public String title;
    public Calendar startTime;
    public int durationLeft;

    public Session(){
        events = new ArrayList<>();
    }

    public Session(String title, Calendar startTime, int durationLeft){
        this.title = title;
        this.startTime = startTime;
        this.durationLeft = durationLeft;
        this.events = new ArrayList<>();
    }

}
