package mainPackage;

public class Main {
  
  public static void main(String[] args) {
    PasswordChecker check = new PasswordChecker();
    
    System.out.println(check.passwordCriteriaCheck("Test123!longer"));
  }
  
}
