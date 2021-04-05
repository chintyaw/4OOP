package Exceptions;

public class InvalidColorException extends Exception {
    private String message;

    public InvalidColorException(String message){
        this.message = message;
    }

    public String getErrorMessage(){
        return (this.message);
    }
}