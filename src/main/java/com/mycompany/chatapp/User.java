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
    private String password;
    
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
    
    public boolean setPassword(String password) {
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        boolean hasMinLength = password.length() >= 8;
    
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasCapital = true;
            if (Character.isDigit(c)) hasNumber = true;
            if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        
        if (hasMinLength && hasCapital && hasNumber && hasSpecial) {
            this.password = password;
            System.out.println("Password successfully captured");
            return true;
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number and a special character");
            return false;
        }
    }
    
    public String getUsername() {
       return username;
    }
    
    public String getPassword() {
        return password;
    }
}
