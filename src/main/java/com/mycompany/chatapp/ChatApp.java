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
        User user = new User();
        
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
        System.out.println(login.registerUser());
        
        // Login section
        System.out.println("\n=== Login ===");
        System.out.println("Please enter your username to login: ");
        String loginUsername = scanner.nextLine();
        
        System.out.println("Please enter your password to login: ");
        String loginPassword = scanner.nextLine();
        
        System.out.println(login.returnLoginStatus(loginUsername, loginPassword));
        
        user.login(loginUsername, loginPassword);
    }
}
