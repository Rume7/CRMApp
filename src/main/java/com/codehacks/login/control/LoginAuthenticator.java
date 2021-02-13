package com.codehacks.login.control;

import com.codehacks.login.model.Login;

/**
 *
 * @author Rhume
 */
public class LoginAuthenticator {
    
    public boolean authenticate(Login login) {
        // Login facade find method to get 
        // Get Login details from database using email as key
        // Confirm if the email is same as that from entered
        // if yes, return true;
        return false;
    }
    
    @Override
    public String toString(){
        return "Logger verify";
    }
    
}
