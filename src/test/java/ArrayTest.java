/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Palesa
 */
import com.mycompany.chatapp.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class ArrayTest {

    @BeforeEach
    public void setUp() {
        // Clear arrays before each test
        Message.getSentMessages().clear();
        Message.getDisregardedMessages().clear();
        Message.getStoredMessages().clear();
        Message.getMessageHashes().clear();
        Message.getMessageIDs().clear();
    }

    // Test 1 - Message 1 sent successfully
    @Test
    public void testMessage1Sent() {
        Message message = new Message(1, "+27834557896", "Did you get the cake?");
        message.sentMessage("1");
        assertTrue(Message.getSentMessages().contains("Did you get the cake?"));
    }

    // Test 2 - Message 2 stored successfully
    @Test
    public void testMessage2Stored() {
        Message message = new Message(2, "+27838884567", 
        "Where are you? You are late! I have asked you to be on time.");
        message.sentMessage("3");
        assertTrue(Message.getStoredMessages().contains(
        "Where are you? You are late! I have asked you to be on time."));
    }

    // Test 3 - Message 3 disregarded successfully
    @Test
    public void testMessage3Disregarded() {
        Message message = new Message(3, "+27834484567", "Yohoooo, I am at your gate.");
        message.sentMessage("2");
        assertTrue(Message.getDisregardedMessages().contains("Yohoooo, I am at your gate."));
    }

    // Test 4 - Message 4 invalid recipient fails
    @Test
    public void testMessage4InvalidRecipient() {
        Message message = new Message(4, "0838884567", "It is dinner time!");
        assertFalse(message.checkRecipientCell("0838884567"));
    }

    // Test 5 - Message 5 stored successfully
    @Test
    public void testMessage5Stored() {
        Message message = new Message(5, "+27838884567", "Ok, I am leaving without you.");
        message.sentMessage("3");
        assertTrue(Message.getStoredMessages().contains("Ok, I am leaving without you."));
    }

    // Test 6 - Sent messages array is populated correctly
    @Test
    public void testSentMessagesArray() {
        Message message1 = new Message(1, "+27834557896", "Did you get the cake?");
        message1.sentMessage("1");
        Message message4 = new Message(4, "+27834557896", "It is dinner time!");
        message4.sentMessage("1");
        assertEquals(2, Message.getSentMessages().size());
    }

    // Test 7 - Stored messages array is populated correctly
    @Test
    public void testStoredMessagesArray() {
        Message message2 = new Message(2, "+27838884567", 
        "Where are you? You are late! I have asked you to be on time.");
        message2.sentMessage("3");
        Message message5 = new Message(5, "+27838884567", "Ok, I am leaving without you.");
        message5.sentMessage("3");
        assertEquals(2, Message.getStoredMessages().size());
    }

    // Test 8 - Disregarded messages array is populated correctly
    @Test
    public void testDisregardedMessagesArray() {
        Message message3 = new Message(3, "+27834484567", "Yohoooo, I am at your gate.");
        message3.sentMessage("2");
        assertEquals(1, Message.getDisregardedMessages().size());
    }

    // Test 9 - Message hashes array is populated when message is sent
    @Test
    public void testMessageHashesArray() {
        Message message = new Message(1, "+27834557896", "Did you get the cake?");
        message.sentMessage("1");
        assertFalse(Message.getMessageHashes().isEmpty());
    }

    // Test 10 - Message IDs array is populated when message is sent
    @Test
    public void testMessageIDsArray() {
        Message message = new Message(1, "+27834557896", "Did you get the cake?");
        message.sentMessage("1");
        assertFalse(Message.getMessageIDs().isEmpty());
    }
}
