package com.lazareva.phonebook.exception;

public class PhoneDataErrorResponse {
    String message;

    public PhoneDataErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
