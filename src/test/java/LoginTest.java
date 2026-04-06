/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Palesa
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.chatapp.Login;

public class LoginTest {
    
    // Test 1 - Username correctly formatted
    @Test
    public void testUsernameCorrectlyFormatted() {
        Login login = new Login("Lorem", "Ipsum", "kyl_1", "Password2%", "+27987654321");
        assertTrue(login.checkUsername(),
        "Username should be legitimate as it is no longer than  five characters and has an underscore.");
    }
    // Test 2 - Username incorrectly formatted
    @Test
    public void testUsernameIncorrectlyFormatted() {
        Login login = new Login("Lorem", "Ipsum", "kyle!!!!!!!", "Password2%", "+27987654321");
        assertFalse(login.checkUsername(),
        "Username should be illegitimate as it is longer than five characters and does not have an underscore.");
    }
    // Test 3 - Password does not meet complexity requirements
    @Test
    public void testPasswordMeetsComplexity() {
        Login login = new Login("Lorem", "Ipsum", "kyl_1", "Ch&&sec@ke99!", "+27987654321");
        assertTrue(login.checkPasswordComplexity());
    }
    // Test 4 - Password does not meet complexity requirements
    @Test
    public void testPasswordDoesNotMeetComplexity() {
        Login login = new Login("Lorem", "Ipsum", "kyl_1", "password", "+27987654321");
        assertFalse(login.checkPasswordComplexity());
    }
    // Test 5 - Cellphone number correctly formatted
    @Test
    public void testCellPhoneCorrectlyFormatted() {
        Login login = new Login("Lorem", "Ipsum", "kyl_1", "Password2%", "+27838968976");
        assertTrue(login.checkCellPhoneNumber());
    }

    // Test 6 - Cellphone number incorrectly formatted
    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        Login login = new Login("Lorem", "Ipsum", "kyl_1", "Password2%", "08966553");
        assertFalse(login.checkCellPhoneNumber());
    }
    // Test 7 - Login successful returns true
    @Test
    public void testLoginSuccessful() {
        Login login = new Login("Lorem", "Ipsum", "kyl_1", "Password2%", "+27987654321");
        assertTrue(login.loginUser("kyl_1", "Password2%"));
}

    // Test 8 - Login failed returns false
    @Test
    public void testLoginFailed() {
        Login login = new Login("Lorem", "Ipsum", "kyl_1", "Password2%", "+27987654321");
        assertFalse(login.loginUser("wronguser", "wrongpass"));
}
    // Test 9 - Successful login returns welcome message
    @Test
    public void testLoginStatusWelcomeMessage() {
        Login login = new Login("Lorem", "Ipsum", "kyl_1", "Password2%", "+27987654321");
        assertEquals("Welcome Lorem, Ipsum it is great to see you again.", 
        login.returnLoginStatus("kyl_1", "Password2%"));
    }
    // Test 10 - Failed login returns error message
    @Test
    public void testLoginStatusFailed() {
        Login login = new Login("Lorem", "Ipsum", "kyl_1", "Password2%", "+27987654321");
        assertEquals("Username or password incorrect, please try again.", 
        login.returnLoginStatus("wronguser", "wrongpass"));
    }
}
