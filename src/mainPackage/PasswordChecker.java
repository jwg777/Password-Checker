package mainPackage;

import java.util.HashMap;
import java.util.Map;

public class PasswordChecker {
    
  public PasswordChecker() {}
  
  public String passwordCriteriaCheck(String password) {
    
    String special = "!@#$%^&*()-+";
    Map<String, Boolean> criteria = new HashMap<>();
    String passwordStrength = "";
    
    //Add criteria to map, so that it can be accessed easily
    criteria.put("length at least 8", false);
    criteria.put("digit", false);
    criteria.put("lowercase character", false);
    criteria.put("uppercase character", false);
    criteria.put("special character", false);
    
    //Check the length is good
    if (password.length() >= 8) {
      criteria.put("length at least 8", true);
    }
    
    
    //loop through each character and check that it fulfills the criteria.
    //If it finds a a criteria fulfilled, it will set that to true in the mapping.
    for (int i = 0; i < password.length(); i++) {
      if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {        
        criteria.put("digit", true);

      }
      else if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {        
        criteria.put("lowercase character", true);

      }
      else if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {        
        criteria.put("uppercase character", true);

      }
      else if (special.contains(password.charAt(i) + "")) {        
        criteria.put("special character", true);

      }
    }
    
    //Any value in the mapping that is still false will be added to the final string
    if (!criteria.get("length at least 8")) {
      passwordStrength = passwordStrength + "The length must be at least 8.";
    }
    if (!criteria.get("digit")) {
      passwordStrength = passwordStrength + "\nIt must contain at least one digit.";

    }
    if (!criteria.get("lowercase character")) {
      passwordStrength = passwordStrength + "\nIt must contain at least one lowercase English character.";

    }
    if (!criteria.get("uppercase character")) {
      passwordStrength = passwordStrength + "\nIt must contain at least one uppercase English character.";

    }
    if (!criteria.get("special character")) {
      passwordStrength = passwordStrength + "\nIt must contain at least one special character. The special characters are: !@#$%^&*()-+";

    }
    //if nothing has been added to the string then the password is strong.
    if (passwordStrength.equals("")) {
      passwordStrength = "Password is strong!"; 
    }
    
    
    return passwordStrength;
  }
  
  
  
}
