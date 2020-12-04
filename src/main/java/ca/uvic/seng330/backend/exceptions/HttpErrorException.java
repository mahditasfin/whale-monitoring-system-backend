package ca.uvic.seng330.backend.exceptions;

import ca.uvic.seng330.backend.entity.StatusMessage;
import com.fasterxml.jackson.core.JsonProcessingException;

public class HttpErrorException extends Exception{
    private final String httpMessage;
    private final int statusCode;


    public HttpErrorException(StatusMessage apiMessage) throws JsonProcessingException {
        this(apiMessage.getStatusCode(), apiMessage.getMessage());

    }

    public HttpErrorException(int statusCode, String message){
        super("Http Error: " +statusCode + ": " + message);
        this.httpMessage = message;
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getHttpMessage() {
        return httpMessage;
    }
}
