package Exceptions;

public class InvalidNumberException extends Exception {
    private String message;

    public InvalidNumberException(String message){
        this.message = message;
    }

    public String getErrorMessage(){
        return (this.message);
    }
}
