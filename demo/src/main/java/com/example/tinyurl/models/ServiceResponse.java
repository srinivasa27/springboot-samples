package com.example.tinyurl.models;

import java.util.List;

public class ServiceResponse {

    private int responseCode;
    private String responseException;
    private List<TinyUrl> response;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseException() {
        return responseException;
    }

    public void setResponseException(String responseException) {
        this.responseException = responseException;
    }

    public List<TinyUrl> getResponse() {
        return response;
    }

    public void setResponse(List<TinyUrl> response) {
        this.response = response;
    }


}
