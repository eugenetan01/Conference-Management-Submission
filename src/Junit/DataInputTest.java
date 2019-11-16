package Junit;
import Resources.Config;
import main.DataInput;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DataInputTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testGetAllTalksFilled() throws Exception {
        HashMap<String, Integer> talks = DataInput.getAllTalks(Config.LIST_OF_TALKS);
        Assert.assertEquals(19, talks.size());
    }

    @Test
    public void testGetAllTalksEmpty() throws Exception{
        HashMap<String, Integer> talks = DataInput.getAllTalks("/Users/Eugene/IdeaProjects/ThoughtWorksQn2/src/Resources/EmptyInput");
        exception.expect(Exception.class);
    }
    
}