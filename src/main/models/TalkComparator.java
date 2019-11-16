package main.models;

import java.util.Comparator;

public class TalkComparator implements Comparator<Event> {
    public int compare(Event talk1, Event talk2) {
        return talk2.duration - talk1.duration;
    }
}