package com.staffmanagement.management.Exception;

public class HolydayException extends Exception {

    @Override
    public String getMessage() {
        
        return "This day is Holyday..Does not Add into Table ";
    }
    
}
