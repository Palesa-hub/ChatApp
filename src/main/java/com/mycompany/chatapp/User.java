/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/**
 *
 * @author Palesa
 */
public class User {
    private String username;
    
    public boolean setUsername(String username) {
        if (username.contains("_") && username.length() <= 5) {
            this.username = username;
            System.out.println("Username successfully captured");
            return true;
        } else {
            System.out.println("Username is not correctly formatted; please  ensure that your username contains an underscore and is no more than five characters in length");
            return false;
        }
    }
    
    public String getUsername() {
       return username;
    }
}
