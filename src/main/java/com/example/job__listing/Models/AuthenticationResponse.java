package com.example.job__listing.Models;

public class AuthenticationResponse {
    private String response;

    public AuthenticationResponse(String response) {
        this.response=response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
