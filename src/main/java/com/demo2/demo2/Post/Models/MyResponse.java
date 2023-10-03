package com.demo2.demo2.Post.Models;

public class MyResponse {
    private boolean success;
    private String message;

    // Getters and setters for the fields

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
