package Exceptions;

public class InvalidColorException extends Exception {
    private String expectedColor;
    private String actualColor;
    private String message;

    public InvalidColorException(String message, String actualColor, String expectedColor){
        this.actualColor = actualColor;
        this.expectedColor = expectedColor;
        this.message = message;
    }

    public String getErrorMessage(){
        return (this.message);
    }
}