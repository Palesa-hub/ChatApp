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
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {
    
    // ===== NUMBER 9 TESTS - Test data scenarios =====

    // Test 1 - Message 1 details (valid recipient, valid message, send option)
    @Test
    public void testMessage1ValidRecipient() {
        Message message = new Message(1, "+27718693002", 
        "Hi Mike, can you join us for dinner tonight?");
        assertTrue(message.checkRecipientCell("+27718693002"));
    }

    // Test 2 - Message 1 valid length
    @Test
    public void testMessage1ValidLength() {
        Message message = new Message(1, "+27718693002", 
        "Hi Mike, can you join us for dinner tonight?");
        assertTrue(message.checkMessageLength());
    }

    // Test 3 - Message 1 send option returns correct message
    @Test
    public void testMessage1SendOption() {
        Message message = new Message(1, "+27718693002", 
        "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Message successfully sent.", message.sentMessage("1"));
    }

    // Test 4 - Message 2 invalid recipient
    @Test
    public void testMessage2InvalidRecipient() {
        Message message = new Message(2, "08575975889", 
        "Hi Keegan, did you receive the payment?");
        assertFalse(message.checkRecipientCell("08575975889"));
    }
    // Test 5 - Message 2 discard option returns correct message
    @Test
    public void testMessage2DiscardOption() {
        Message message = new Message(2, "08575975889", 
        "Hi Keegan, did you receive the payment?");
        assertEquals("Press 0 to delete the message.", message.sentMessage("2"));
    }

    // ===== NUMBER 10 TESTS =====

    // Test 6 - Message length success
    @Test
    public void testMessageLengthSuccess() {
        Message message = new Message(1, "+27718693002", 
        "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Message ready to send.", message.checkMessageLengthMessage());
    }

    // Test 7 - Message length failure
    @Test
    public void testMessageLengthFailure() {
        Message message = new Message(1, "+27718693002", 
        "This is a very long message that exceeds the two hundred and fifty character limit "
        + "for this application and should return an error message telling the user to reduce "
        + "the size of their message because it is just way too long for the system to handle "
        + "and needs to be shortened significantly.");
        assertFalse(message.checkMessageLength());
    }
    // Test 8 - Recipient correctly formatted
    @Test
    public void testRecipientCorrectlyFormatted() {
        Message message = new Message(1, "+27718693002", 
        "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Cell phone number successfully captured.", 
        message.checkRecipientCellMessage("+27718693002"));
    }
    // Test 9 - Recipient incorrectly formatted
    @Test
    public void testRecipientIncorrectlyFormatted() {
        Message message = new Message(2, "08575975889", 
        "Hi Keegan, did you receive the payment?");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", 
        message.checkRecipientCellMessage("08575975889"));
    }
    // Test 10 - Message hash is correct for message 1
    @Test
    public void testMessageHashCorrect() {
        Message message = new Message(1, "+27718693002", 
        "Hi Mike, can you join us for dinner tonight?");
        assertEquals("00:1:HITONIGHT", message.createMessageHash());
    }
    // Test 11 - Message ID is generated
    @Test
    public void testMessageIDGenerated() {
        Message message = new Message(1, "+27718693002", 
        "Hi Mike, can you join us for dinner tonight?");
        assertNotNull(message.getMessageID());
        System.out.println("Message ID generated: " + message.getMessageID());
    }
    // Test 12 - Send message option
    @Test
    public void testSendMessageOption() {
        Message message = new Message(1, "+27718693002", 
        "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Message successfully sent.", message.sentMessage("1"));
    }

    // Test 13 - Disregard message option
    @Test
    public void testDisregardMessageOption() {
        Message message = new Message(1, "+27718693002", 
        "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Press 0 to delete the message.", message.sentMessage("2"));
    }
    // Test 14 - Store message option
    @Test
    public void testStoreMessageOption() {
        Message message = new Message(1, "+27718693002", 
        "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Message successfully stored.", message.sentMessage("3"));
    }
}

