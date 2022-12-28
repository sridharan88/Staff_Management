package com.staffmanagement.management.Exception;

public class DaysNotFoundException extends Exception {

    @Override
    public String getMessage() {
        
        return "Given Day is Invalid";
    }
    
}
