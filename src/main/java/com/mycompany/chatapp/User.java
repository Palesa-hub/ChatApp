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
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;
    
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
    
    // Reference: W3Schools - Java Regular Expressions
    // Source: https://www.w3schools.com/java/java_regex.asp
    // Date accessed: 31 March 2026
    public boolean setCellPhoneNumber(String cellPhoneNumber) {
        if (cellPhoneNumber.matches("\\+27\\d{9}")) {
            this.cellPhoneNumber = cellPhoneNumber;
            System.out.println("Cellphone number successfully added");
            return true;
        } else {
            System.out.println("Cellphone number incorrectly formatted or does not contain international code");
            return false;
        }
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public boolean login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("Welcome " + firstName + ", " + lastName + "it is great to see you again.");
            return true;
        } else {
            System.out.println("Username or password incorrect, please try again.");
            return false;
        }
    }
    public String getUsername() {
       return username;
    }
    
    public String getPassword() {
        return password;
    }
    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    }

