/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

/**
 *
 * @author Palesa
 */
import java.util.Scanner;

public class ChatApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Welcome to the Chat App ===");
        System.out.println("=== Register ===");
        
        // Collect registration details
        System.out.println("Please enter your first name: ");
        String firstName = scanner.nextLine();
        
        System.out.println("Please enter your last name: ");
        String lastName = scanner.nextLine();
        
        System.out.println("Please enter a username: ");
        String username = scanner.nextLine();
        
        System.out.println("Please enter a password: ");
        String password = scanner.nextLine();
        
        System.out.println("Please enter your cellphone number (e.g. +27876543211)");
        String cellPhone = scanner.nextLine();
        
        // Register user
        Login login = new Login(firstName, lastName, username, password, cellPhone);
        String registrationResult = login.registerUser();
        System.out.println(registrationResult);
        
        // Only allow login if registration is successful
        if (registrationResult.contains("successfully")) {
        
        // Login section
        System.out.println("\n=== Login ===");
        System.out.println("Please enter your username to login: ");
        String loginUsername = scanner.nextLine();
        
        System.out.println("Please enter your password to login: ");
        String loginPassword = scanner.nextLine();
        
        String loginStatus = login.returnLoginStatus(loginUsername, loginPassword);
        System.out.println(loginStatus);
        
        // Only show messaging features if login is successful
        if (loginStatus.contains("great to see you")) {
                System.out.println("\nWelcome to QuickChat.");
                
        // Ask how many messages to send
                System.out.println("How many messages would you like to send?");
                int maxMessages = Integer.parseInt(scanner.nextLine());
                int messageCount = 0;
                
                boolean running = true;
                while (running) {
                    System.out.println("\nPlease choose an option:");
                    System.out.println("1. Send messages");
                    System.out.println("2. Show recently sent messages:");
                    System.out.println("3. Stored messages");
                    System.out.println("4. Quit");
                    
                    String choice = scanner.nextLine();
                    
                    switch (choice) {
                        case "1":
                            if (messageCount >= maxMessages) {
                                System.out.println("You have reached your message limit of " + maxMessages);
                                break;
                            }
                System.out.println("\nMessage " + (messageCount + 1) + " of " + maxMessages);
                        
        // Get recipient
                System.out.println("Enter recipient cell number (e.g. +27987654321): ");
                    String recipient = scanner.nextLine();

        // Get message text
                System.out.println("Enter your message (max 250 characters): ");
                    String messageText = scanner.nextLine();
                    
        // Create message object
                    Message message = new Message(messageCount + 1, recipient, messageText);

        // Check recipient
                    if (!message.checkRecipientCell(recipient)) {
                        System.out.println("Cellphone number incorrectly formatted or does not contain international code");
                                break;
                            }

        // Check message length
                    if (!message.checkMessageLength()) {
                        System.out.println("Please enter a message of less than 250 characters");
                                break;
                            }
        // Display message details
                        System.out.println("\nMessage ID: " + message.getMessageID());
                        System.out.println("Message Hash: " + message.getMessageHash());
                        System.out.println("Recipient: " + message.getRecipient());
                        System.out.println("Message: " + message.getMessageText());

        // Send options
                        System.out.println("\nWhat would you like to do with this message?");
                        System.out.println("1) Send message");
                        System.out.println("2) Disregard message");
                        System.out.println("3) Store message to send later");
                        System.out.println("4) Store message in JSON file");

                    String messageChoice = scanner.nextLine();
                        if (messageChoice.equals("4")) {
                                Message.storeMessage();
                            } else {
                                String result = message.sentMessage(messageChoice);
                                System.out.println(result);
                                if (messageChoice.equals("1") || messageChoice.equals("3")) {
                                    messageCount++;
                                }
                                if (messageChoice.equals("2")) {
                                    System.out.println("Enter 0 to confirm delete: ");
                                    String deleteChoice = scanner.nextLine();
                                    if (deleteChoice.equals("0")) {
                                        System.out.println("Message deleted");
                                    }
                        }
                            }
                            break;
                        case "2":
                            System.out.println("Coming soon");
                            break;
                        case "3":
                            System.out.println("\n=== Stored Messages Menu ===");
                            System.out.println("1) Display sender and recipient of all stored messages");
                            System.out.println("2) Display longest stored message");
                            System.out.println("3) Search for a message by ID");
                            System.out.println("4) Search messages by recipient");
                            System.out.println("5) Delete a message using message hash");
                            System.out.println("6) Display full message report");
                            System.out.println("7) Back to main menu");

                    String storedChoice = scanner.nextLine();

                switch (storedChoice) {
                        case "1":
                           System.out.println(Message.displayStoredMessagesDetails(firstName));
                           break;
                        case "2":
                           System.out.println(Message.displayLongestMessage());
                    break;
                        case "3":
                           System.out.println("Enter message ID to search: ");
            String searchID = scanner.nextLine();
                           System.out.println(Message.searchMessageByID(searchID));
                    break;
                        case "4":
                           System.out.println("Enter recipient number to search: ");
            String searchRecipient = scanner.nextLine();
                           System.out.println(Message.searchMessagesByRecipient(searchRecipient));
                    break;
                        case "5":
                           System.out.println("Enter message hash to delete: ");
            String deleteHash = scanner.nextLine();
                           System.out.println(Message.deleteMessageByHash(deleteHash));
                    break;
                        case "6":
                           System.out.println(Message.displayFullReport());
                    break;
                        case "7":
                           System.out.println("Returning to main menu...");
                    break;
                    default:
                           System.out.println("Invalid option, please try again");
            break;
    }
            break;
                        case "4":
                            System.out.println("\nTotal messages sent: " + Message.returnTotalMessages());
                            System.out.println("Thank you for using QuickChat. Goodbye!");
                            running = false;
                            break;
                            
                        default:
                            System.out.println("Invalid option, please try again.");
                            break;
                    }
                }
            } else {
                System.out.println("Login failed. Please restart and try again.");
            }
        } else {
            System.out.println("Registration failed. Please restart and try again.");
        }
    }
} 