

public class InvalidPlayerTurnException extends Exception {
    private String playerId;
    private String message;
    
    public InvalidPlayerTurnException(String message, String playerId){
        this.message = message;
        this.playerId = playerId;
    }

    public String getErrorMessage(){
        return (this.message);
    }

    public String getPid(){
        return this.playerId;
    }
}