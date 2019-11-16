package main.controllers;

import Resources.Config;
import main.models.Event;
import main.models.Session;
import main.models.TalkComparator;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConferenceManager {
    public ArrayList<Event> loadAsEvents(HashMap<String, Integer> list){
        ArrayList<Event> events = new ArrayList<>();
        Iterator it = list.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            String title = (String)pair.getKey();
            int duration = Integer.parseInt(pair.getValue().toString());
            Event e = new Event(title, null, duration);
            events.add(e);
            it.remove();
        }
        Collections.sort(events, new TalkComparator());
        return events;
    }

    public ArrayList<String> fillSession(ArrayList<Event> events, String session) throws Exception{
        ArrayList<String> track = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        Session s = new Session();
        if(session.equals("Lunch")){
            String lunch = "12:00 PM" +  " " + "Lunch";
            track.add(lunch);
        }else if(session.equals("am")){
            s.title = "am";
            s.startTime = setTime(9,0);
            s.durationLeft = Config.MORNING_SESSION_DURATION_MINUTES;
            track = getSchedule(s, events);
        }else{
            s.title = "pm";
            s.startTime = setTime(13,0);
            s.durationLeft = Config.AFTERNOON_SESSION_DURATION_MINUTES;
            track = getSchedule(s, events);
        }
        return track;
    }

    public Calendar setTime(int hours, int mins){
        Calendar date = new GregorianCalendar();
        date.set(Calendar.HOUR_OF_DAY, hours);
        date.set(Calendar.MINUTE, mins);
        return date;
    }

    public ArrayList<String> getSchedule(Session s, ArrayList<Event> events) throws Exception{
        ArrayList<String> track = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        Calendar startTime = s.startTime;
        int durationLeft = s.durationLeft;
        int counter = 0;
        Event e = events.get(counter);
        while(durationLeft>0 && durationLeft>=e.duration && counter<=events.size()){
            if(counter>=events.size()-1){
                counter = 0;
            }
            e = events.get(counter);
            events.remove(e);
            int duration = e.duration;
            durationLeft = durationLeft - duration;
            e.startTime = startTime;
            s.events.add(e);
            String event = sdf.format(e.startTime.getTime()) +  " " + e.title;
            startTime.add(Calendar.MINUTE, duration);
            track.add(event);
            counter++;
        }
        if(s.title.equals("pm")){
            long startTimeInMillis = setTime(16,0).getTimeInMillis();
            long endTimeInMillis = setTime(17,0).getTimeInMillis();
            if(startTime.getTime().getTime() >= startTimeInMillis && startTime.getTime().getTime() <= endTimeInMillis){
                String networkingEvent = sdf.format(startTime.getTime()) +  " Networking";
                track.add(networkingEvent);
            }
        }
        return track;
    }
}
