package main.models;

import java.util.ArrayList;

public class Track {

    public Session amSession;
    public Session pmSession;
    public int id;

    public Track(int id, Session amSession, Session pmSession){
        this.id = id;
        this.amSession = amSession;
        this.pmSession = pmSession;
    }

}
