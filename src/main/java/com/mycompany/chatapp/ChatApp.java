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
        
        // Create login object and register
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
                
                boolean running = true;
                while (running) {
                    System.out.println("\nPlease choose an option:");
                    System.out.println("1. Send messages");
                    System.out.println("2. Show recently sent messages:");
                    System.out.println("3. Quit");
                    
                    String choice = scanner.nextLine();
                    
                    switch (choice) {
                        case "1":
                            System.out.println("Sendong messages coming soon...");
                            break;
                        case "2":
                            System.out.println("Coming soon");
                            break;
                        case "3":
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