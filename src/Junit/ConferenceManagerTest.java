package Junit;

import Resources.Config;
import main.DataInput;
import main.controllers.ConferenceManager;
import main.models.Event;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ConferenceManagerTest {

    @Test
    void loadAsEvents() throws Exception{
        ConferenceManager cManager = new ConferenceManager();
        ArrayList<Event> events = cManager.loadAsEvents(DataInput.getAllTalks(Config.LIST_OF_TALKS));
        Assert.assertTrue(events.size() == 19);
    }
}