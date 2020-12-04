package ca.uvic.seng330.backend.entity;

import com.fasterxml.jackson.annotation.JsonSetter;

public class StatusMessage {


    private int statusCode;

    private String message;

    @JsonSetter("cod")
    public void setStatusCode(String statusCode) {
        this.statusCode = Integer.parseInt(statusCode);
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
