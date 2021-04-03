package Exception;

public class InvalidNumberException extends Exception {
    private int expectedNumber;
    private int actualNumber;

    public InvalidNumberException(String message, int actualNumber, int expectedNumber){
        this.actualNumber = actualNumber;
        this.expectedNumber = expectedNumber;
    }
}
