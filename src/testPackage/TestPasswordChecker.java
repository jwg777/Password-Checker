package testPackage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import mainPackage.PasswordChecker;

class TestPasswordChecker {
  
  private PasswordChecker checkPassword;
  
  @BeforeEach
  public void setUp() {
    checkPassword = new PasswordChecker();
  }
  
  @Test
  public void testStrongPassword() {
    String result = checkPassword.passwordCriteriaCheck("Password123!");
    assertEquals(result, "Password is strong!");

  }
  
  @Test
  public void testEmptyPassword() {
    String result = checkPassword.passwordCriteriaCheck("");
    assertEquals(result, "The length must be at least 8.\n" + 
        "It must contain at least one digit.\n" + 
        "It must contain at least one lowercase English character.\n" + 
        "It must contain at least one uppercase English character.\n" + 
        "It must contain at least one special character. The special characters are: !@#$%^&*()-+");
  }
  
  @Test
  public void testNoDigit() {
    String result = checkPassword.passwordCriteriaCheck("Passworddddd!");
    assertEquals(result, "\n" + 
        "It must contain at least one digit.");

  }
  
  @Test
  public void testNoLowerCase() {
    String result = checkPassword.passwordCriteriaCheck("PASSWORD123!");
    assertEquals(result, "\n" + 
        "It must contain at least one lowercase English character.");

  }
  
  @Test
  public void testNoUpperCase() {
    String result = checkPassword.passwordCriteriaCheck("password123!");
    assertEquals(result, "\n" + 
        "It must contain at least one uppercase English character.");

  }
  
  @Test
  public void testTooShort() {
    String result = checkPassword.passwordCriteriaCheck("Pass1!");
    assertEquals(result, "The length must be at least 8.");

  }
  
  @Test
  public void testNoSymbol() {
    String result = checkPassword.passwordCriteriaCheck("Password123");
    assertEquals(result, "\n" + 
        "It must contain at least one special character. The special characters are: !@#$%^&*()-+");

  }
}

//Basic edge cases are covered.
//Test coverage is at least 90%
//Firther testing could be done to test evry combination but this is okay for now.
