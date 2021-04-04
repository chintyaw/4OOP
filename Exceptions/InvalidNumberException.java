package Exceptions;

public class InvalidNumberException extends Exception {
    private int expectedNumber;
    private int actualNumber;
    private String message;

    public InvalidNumberException(String message, int actualNumber, int expectedNumber){
        this.actualNumber = actualNumber;
        this.expectedNumber = expectedNumber;
        this.message = message;
    }

    public String getErrorMessage(){
        return (this.message);
    }
}
