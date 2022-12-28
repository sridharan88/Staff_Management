package com.staffmanagement.management.Exception;

public class PeriodCountMismatchException extends Exception {

    @Override
    public String getMessage() {
       
        return "Period count is not matched with given input";
    }
    
    
}
