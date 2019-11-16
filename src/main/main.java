package main;

import Resources.Config;
import main.controllers.ConferenceManager;
import main.models.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

public class main {

    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        ConferenceManager c = new ConferenceManager();
        try{
            ArrayList<Event>  talkList = c.loadAsEvents(DataInput.getAllTalks(Config.LIST_OF_TALKS));
            int counter = 0;
            while(talkList.size() > 0){
                System.out.println();
                ArrayList<String> track  = c.fillSession(talkList, "am");
                for (String s : track) {
                    if(s.substring(0,2).equals("09")){
                        counter++;
                        System.out.println("Track " + counter + ": ");
                    }
                    System.out.println(s);
                }
                ArrayList<String> track1  = c.fillSession(talkList, "Lunch");
                for (String s : track1) {
                    System.out.println(s);
                }
                ArrayList<String> track2  = c.fillSession(talkList, "pm");
                for (String s : track2) {
                    System.out.println(s);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Please input time in minutes or \"lightning\" for lightning talks.");
        } catch (IOException e){
            System.out.println("Please input valid file into the config file.");
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
