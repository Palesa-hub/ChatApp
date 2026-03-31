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
        System.out.println("Please enter a username: ");
        String usernameInput = scanner.nextLine();
        
        user.setUsername(usernameInput);
        
        System.out.println("Please enter a password: ");
        String passwordInput = scanner.nextLine();
        user.setPassword(passwordInput);
    }
}
