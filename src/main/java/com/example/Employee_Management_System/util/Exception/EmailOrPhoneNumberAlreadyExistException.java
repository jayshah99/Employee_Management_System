package com.example.Employee_Management_System.util.Exception;

public class EmailOrPhoneNumberAlreadyExistException extends RuntimeException{

    public EmailOrPhoneNumberAlreadyExistException(String message) {
        super(message);
    }

    public EmailOrPhoneNumberAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
