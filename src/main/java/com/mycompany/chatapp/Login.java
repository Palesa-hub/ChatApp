/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/**
 *
 * @author Palesa
 */
public class Login {
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;
    
public Login(String firstName, String lastName, String username, String password, String cellPhoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.cellPhoneNumber = cellPhoneNumber;
}
    // Method 1 checks the username has underscore and is no more than 5 characters
public boolean checkUsername() {
    return username.contains("_") && username.length() <= 5;
}
    // Method 2 checks the password complexity rules
public boolean checkPasswordComplexity() {
    boolean hasCapital = false;
    boolean hasNumber = false;
    boolean hasSpecial = false;
    boolean hasMinLength = password.length() >= 8;
    
    for (char c : password.toCharArray()) {
        if (Character.isUpperCase(c)) hasCapital = true;
        if (Character.isDigit(c)) hasNumber = true;
        if (Character.isLetterOrDigit(c)) hasSpecial = true;
    }
    return hasMinLength && hasCapital && hasNumber && hasSpecial;
}
    // Reference: W3Schools - Java Regular Expressions
    // Source: https://www.w3schools.com/java/java_regex.asp
    // Date accessed: 31 March 2026

    // Method 3 checks the cellphone number format
public boolean checkCellPhoneNumber() {
    return cellPhoneNumber.matches("\\+27\\d{9}");
}
    // Method 4 registers the user and returns appropriate message
public String registerUser() {
    if (!checkUsername()) {
        return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length";
    }
    if (!checkPasswordComplexity()) {
        return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number and a special character";
    }
    if (!checkCellPhoneNumber()) {
        return "Cellphone number incorrectly formatted or does not contain international code";
    }
    return "Username successfully captured\nPassword successfully captured\nCellphone number successfully added";
    }

    // Method 5 checks if login details match registered details
public boolean loginUser(String enteredUsername, String enteredPassword) {
    return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
}

   // Method 6 returns the login status message
public String returnLoginStatus(String enteredUsername, String enteredPassword) {
   if (loginUser(enteredUsername, enteredPassword)) {
      return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
} else {
      return "Username or password incorrect, please try again.";
        }
    }
}