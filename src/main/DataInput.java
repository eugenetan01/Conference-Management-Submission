package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import Resources.Config;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DataInput {
    public static HashMap<String, Integer> getAllTalks(String fileName) throws Exception{
        HashMap<String, Integer> talkList = new HashMap<>();
        File file = new File(Config.LIST_OF_TALKS);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line = null;
        int minutes = 0;

        while ((line = br.readLine()) != null) {
            String title = line.substring(0, line.lastIndexOf(" "));
            String minutes_temp = line.substring(line.lastIndexOf(" ") + 1);
            minutes_temp = minutes_temp.replaceAll("min", "");
            if (minutes_temp.equals("lightning")) {
                minutes = Config.LIGHTNING_TALK_DURATION_MINUTES;
            } else {
                minutes = Integer.parseInt(minutes_temp);
            }
            talkList.put(title, minutes);
        }

        if(talkList.isEmpty()){
            throw new Exception("Input file is empty. Please enter talks into input file.");
        }

        br.close();
        return talkList;
    }
}
