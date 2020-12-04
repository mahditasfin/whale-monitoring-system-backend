package ca.uvic.seng330.backend.exceptions;

public class UnexpectedResponse extends Exception{
    public UnexpectedResponse(String expectedResponse, String actualResponse){

        super("Expected: " + expectedResponse + ", but received: " + actualResponse);
    }
}
