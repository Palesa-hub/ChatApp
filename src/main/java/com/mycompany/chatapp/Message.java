/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/**
 *
 * @author Palesa
 */
import java.util.ArrayList;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;


public class Message {
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    private boolean messageSent;
    private boolean messageReceived;
    private boolean messageRead;

    // Static list to store all messages
    private static ArrayList<Message> messageList = new ArrayList<>();
    private static int totalMessages = 0;
    
    // The 5 required arrays
    private static ArrayList<String> sentMessages = new ArrayList<>();
    private static ArrayList<String> disregardedMessages = new ArrayList<>();
    private static ArrayList<String> storedMessages = new ArrayList<>();
    private static ArrayList<String> messageHashes = new ArrayList<>();
    private static ArrayList<String> messageIDs = new ArrayList<>();

    // Constructor
    public Message(int messageNumber, String recipient, String messageText) {
        this.messageID = generateMessageID();
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
        this.messageSent = false;
        this.messageReceived = false;
        this.messageRead = false;
    }

    // Generates a random 10 digit message ID
    private String generateMessageID() {
        Random random = new Random();
        long id = (long)(random.nextDouble() * 9000000000L) + 1000000000L;
        return String.valueOf(id);
    }

    // Method 1 - checks message ID is not more than 10 characters
    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }

    // Method 2 - checks recipient cell number format
    public boolean checkRecipientCell(String recipient) {
        return recipient.matches("\\+27\\d{9}");
    }

    // Method 3 - creates and returns the message hash
    public String createMessageHash() {
        String[] words = messageText.trim().split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        String firstTwoID = messageID.length() >= 2 ? messageID.substring(0, 2) : messageID;
        return (firstTwoID + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();
    }

    // Method 4 - handles send, store or disregard options
    public String sentMessage(String choice) {
        switch (choice) {
            case "1":
                messageSent = true;
                messageReceived = true;
                totalMessages++;
                messageList.add(this);
                // Add to sent messages array
                sentMessages.add(this.messageText);
                // Add hash and ID to their arrays
                messageHashes.add(this.messageHash);
                messageIDs.add(this.messageID);
                return "Message successfully sent.";
            case "2":
                // Add to disregarded messages array
                disregardedMessages.add(this.messageText);
                return "Press 0 to delete the message.";
            case "3":
                messageList.add(this);
                // Add to stored messages array
                storedMessages.add(this.messageText);
                // Add hash and ID to their arrays
                messageHashes.add(this.messageHash);
                messageIDs.add(this.messageID);
                return "Message successfully stored.";
            default:
                return "Invalid option, please try again";
        }
    }

    // Method 5 - returns all messages sent while program is running
    public static String printMessages() {
        if (messageList.isEmpty()) {
            return "No messages sent yet";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== Recently Sent Messages ===\n");
        for (Message m : messageList) {
            sb.append("\nMessage ID: ").append(m.messageID)
              .append("\nMessage Hash: ").append(m.messageHash)
              .append("\nRecipient: ").append(m.recipient)
              .append("\nMessage: ").append(m.messageText)
              .append("\n");
        }
        return sb.toString();
    }

    // Method 6 - returns total number of messages sent
    public static int returnTotalMessages() {
        return totalMessages;
    }

    // Reference: JSON Simple library for Java
    // Source: https://code.google.com/archive/p/json-simple/downloads
    // Date accessed: 22 May 2026
    // Method 7 - stores messages in JSON file
    public static void storeMessage() {
        JSONArray jsonArray = new JSONArray();
        for (Message m : messageList) {
            JSONObject obj = new JSONObject();
            obj.put("MessageID", m.messageID);
            obj.put("MessageHash", m.messageHash);
            obj.put("Recipient", m.recipient);
            obj.put("Message", m.messageText);
            obj.put("MessageSent", m.messageSent);
            obj.put("MessageReceived", m.messageReceived);
            obj.put("MessageRead", m.messageRead);
            jsonArray.add(obj);
        }
        try (FileWriter file = new FileWriter("messages.json")) {
            file.write(jsonArray.toJSONString());
            System.out.println("Messages successfully stored in JSON file");
        } catch (IOException e) {
            System.out.println("Error storing messages: " + e.getMessage());
        }
    }

    // Check message length
    public String checkMessageLengthMessage() {
    if (messageText.length() <= 250) {
        return "Message ready to send.";
    } else {
        int excess = messageText.length() - 250;
        return "Message exceeds 250 characters by " + excess + "; please reduce the size.";
    }
}
    
    // Check message length - returns boolean
    public boolean checkMessageLength() {
         return messageText.length() <= 250;
}

    // Check recipient cell - returns specific messages
    public String checkRecipientCellMessage(String recipient) {
    if (recipient.matches("\\+27\\d{9}")) {
        return "Cell phone number successfully captured.";
    } else {
        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }
}

    // Get sent messages array
public static ArrayList<String> getSentMessages() {
    return sentMessages;
}

// Get disregarded messages array
public static ArrayList<String> getDisregardedMessages() {
    return disregardedMessages;
}

// Get stored messages array
public static ArrayList<String> getStoredMessages() {
    return storedMessages;
}

// Get message hashes array
public static ArrayList<String> getMessageHashes() {
    return messageHashes;
}

// Get message IDs array
public static ArrayList<String> getMessageIDs() {
    return messageIDs;
}

// Load stored messages from JSON file into array
// Reference: JSON Simple library for Java
// Source: https://code.google.com/archive/p/json-simple/downloads
// Date accessed: 22 May 2026
public static void loadStoredMessagesFromJSON() {
    try {
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new java.io.FileReader("messages.json"));
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            String message = (String) jsonObject.get("Message");
            if (!storedMessages.contains(message)) {
                storedMessages.add(message);
            }
        }
        System.out.println("Stored messages loaded successfully");
    } catch (Exception e) {
        System.out.println("No stored messages file found");
    }
}

// Display sender and recipient of all stored messages
public static String displayStoredMessagesDetails(String sender) {
    if (sentMessages.isEmpty() && storedMessages.isEmpty()) {
        return "No stored messages found";
    }
    StringBuilder sb = new StringBuilder();
    sb.append("\n=== Stored Message Details ===\n");
    for (Message m : messageList) {
        sb.append("\nSender: ").append(sender)
          .append("\nRecipient: ").append(m.recipient)
          .append("\n");
    }
    return sb.toString();
}

// Display longest stored message
public static String displayLongestMessage() {
    if (messageList.isEmpty()) {
        return "No messages found";
    }
    Message longest = messageList.get(0);
    for (Message m : messageList) {
        if (m.messageText.length() > longest.messageText.length()) {
            longest = m;
        }
    }
    return "Longest message: " + longest.messageText;
}

// Search for message by ID
public static String searchMessageByID(String messageID) {
    for (Message m : messageList) {
        if (m.messageID.equals(messageID)) {
            return "Recipient: " + m.recipient + "\nMessage: " + m.messageText;
        }
    }
    return "Message ID not found";
}

// Search all messages for a particular recipient
public static String searchMessagesByRecipient(String recipient) {
    StringBuilder sb = new StringBuilder();
    boolean found = false;
    for (Message m : messageList) {
        if (m.recipient.equals(recipient)) {
            sb.append("\nMessage: ").append(m.messageText).append("\n");
            found = true;
        }
    }
    if (!found) {
        return "No messages found for recipient: " + recipient;
    }
    return sb.toString();
}

// Delete message using message hash
public static String deleteMessageByHash(String hash) {
    for (int i = 0; i < messageList.size(); i++) {
        if (messageList.get(i).messageHash.equals(hash)) {
            messageList.remove(i);
            return "Message successfully deleted";
        }
    }
    return "Message hash not found";
}

// Display full report of all stored messages
public static String displayFullReport() {
    if (messageList.isEmpty()) {
        return "No messages found";
    }
    StringBuilder sb = new StringBuilder();
    sb.append("\n=== Full Message Report ===\n");
    for (Message m : messageList) {
        sb.append("\nMessage ID: ").append(m.messageID)
          .append("\nMessage Hash: ").append(m.messageHash)
          .append("\nRecipient: ").append(m.recipient)
          .append("\nMessage: ").append(m.messageText)
          .append("\nMessage Sent: ").append(m.messageSent)
          .append("\nMessage Received: ").append(m.messageReceived)
          .append("\nMessage Read: ").append(m.messageRead)
          .append("\n");
    }
    return sb.toString();
}

    // Getters
    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
    public boolean isMessageSent() { return messageSent; }
    public void setMessageSent(boolean messageSent) { this.messageSent = messageSent; }
}
