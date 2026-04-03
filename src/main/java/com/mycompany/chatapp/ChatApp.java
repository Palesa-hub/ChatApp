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
        
        System.out.println("Please enter your first name: ");
        String firstNameInput = scanner.nextLine();
        user.setFirstName(firstNameInput);
        
        System.out.println("Please enter your last name: ");
        String lastNameInput = scanner.nextLine();
        user.setLastName(lastNameInput);
        
        System.out.println("Please enter a username: ");
        String usernameInput = scanner.nextLine();
        user.setUsername(usernameInput);
        
        System.out.println("Please enter a password: ");
        String passwordInput = scanner.nextLine();
        user.setPassword(passwordInput);
        
        System.out.println("Please enter your cellphone number (e.g. +27876543211)");
        String cellPhoneInput = scanner.nextLine();
        user.setCellPhoneNumber(cellPhoneInput);
        
        System.out.println("\n=== Login ===");
        System.out.println("Please enter your username to login: ");
        String loginUsername = scanner.next();
        
        System.out.println("Please enter your password to login: ");
        String loginPassword = scanner.next();
        
        user.login(loginUsername, loginPassword);
    }
}
