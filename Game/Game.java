/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Parnaek R. Siagian 18219114
 * @author Gian Denggan Bendjamin 18219061
 * @author Muhammad Ichsandro D Noor 18219094
 */
public class Game {
    private int currentPlayer;
    private String[] playerIds;
    
    private Deck deck;
    private ArrayList<ArrayList<Card>> playerDeck;
    private ArrayList<Card> stockPile;
    
    private int angkaKartu;
    private String warnaKartu;
    private int totalPlayer = 0;
    
    boolean GameDirection;
 
    public Game(String[] pids){
        deck = new Deck();
        deck.buildDeck();
        stockPile = new ArrayList<Card>;
        
        playerIds = pids;
        currentPlayer = 0;
        GameDirection = false;
        
        playerDeck = new ArrayList<ArrayList<Card>>();
        
        for (int i=0, pids.length(), i++){
            ArrayList<Card> hand = new ArrayList<Card>();
            for(int j=0, j=7, j++){
               hand.add(Deck.draw());
            }
            playerDeck.add(hand);
        }
    }

    public StartGame(Game game){
        Card kartuAwal = deck.draw();
        angkaKartu = card.getNumber();
        warnaKartu = card.getColor();
        
        if (card.getNumber == -1){
            StartGame(game);
        }

        stockPile.add(kartuAwal);
    }   
    
    public void isGameOver(){
        for (String player : this.playerIds) {
            if (getPlayerDeck(player).isEmpty()){
                return true;
            }
        }
        return false
    }

    public boolean validCardPlay(Card card) {
        return (card.getcolor() == warnaKartu || card.getColor() == angkaKartu);
    }

    public void checkPlayerTurn(String pid) throws InvalidPlayerTurnException {
        if(this.playerIds[this.currentPlayer] != pid) {
            throw new InvalidPlayerTurnException("It's not"+ pid + "'s turn", pid);
        }
    }
    
    public void discard (String pid, Card card, String declaredColor)
        throws InvalidColorSubmissionException, InvalidPlayerTurnException, InvalidValueSubmissionException {
            checkPlayerTurn(pid);

            ArrayList<Card> pDeck = getPlayerDeck(pid);

            if (!validCardPlay(card)) {
                if(card instanceof Wild){
                    warnaKartu = card.getColor();
                    angkaKartu = card.getNumber();
                }

                if (card.getColor() != warnaKartu) {
                    String message = ("Invalid player move, expected color"+ warnaKartu +" but got color " + card.getColor());
                    throw new InvalidColorSubmissionException(message, card.getColor(), warnaKartu);
                }
                else if (card.getValue() != angkaKartu){
                    String message2 = ("Invalid player move, expected value"+ validValue +" but got value " + card.getValue());
                    throw new InvalidColorSubmissionException(message2, card.getNumber(), angkaKartu);
                }
            }

            pDeck.remove(card);

            if ((this.playerIds[currentPlayer]).isEmpty()){
                String message = new String(this.playerIds[currentPlayer]+ "WON");
                //END ??
            }

            warnaKartu = card.getColor();
            angkaKartu = card.getValue();
            stockPile.add(card);

            if (GameDirection == false) {
                currentPlayer = (currentPlayer + 1) % playerIds.length;
            }

            else if (GameDirection == true) {
                currentPlayer = (checkPlayerTurn - 1) % playerIds.length;
                if (currentPlayer == -1) {
                    currentPlayer = playerIds.length - 1;
                }
            }

            if (card instanceof Wild) {
                warnaKartu = declaredColor;
            }

            if (card instanceof DrawTwo) {
                pid = playerIds[currentPlayer];
                getPlayerDeck(pid).add(deck.drawCard());
                getPlayerDeck(pid).add(deck.drawCard());
                System.out.println("draw 2 cards!");
            }

            if (card instanceof DrawFour) {
                pid = playerIds[currentPlayer];
                getPlayerDeck(pid).add(deck.drawCard());
                getPlayerDeck(pid).add(deck.drawCard());
                getPlayerDeck(pid).add(deck.drawCard());
                getPlayerDeck(pid).add(deck.drawCard());
                System.out.println("draw 2 cards!");
            }

            if (card instanceof Skip){
                System.out.println(playerIds[currentPlayer] + "was skipped");
                if (GameDirection == false) {
                    currentPlayer = (currentPlayer + 1) % playerIds.length;
                }
    
                else if (GameDirection == true) {
                    currentPlayer = (checkPlayerTurn - 1) % playerIds.length;
                    if (currentPlayer == -1) {
                        currentPlayer = playerIds.length - 1;
                    }
                }
            }

            if (card instanceof Reverse){
                System.out.println(playerIds[currentPlayer] + "change the game direction");
                GameDirection ^= true;
                
                if (GameDirection == false) {
                    currentPlayer = (currentPlayer + 2) % playerIds.length;
                }
    
                else if (GameDirection == true) {
                    currentPlayer = (checkPlayerTurn - 2) % playerIds.length;
                    if (currentPlayer == -1) {
                        currentPlayer = playerIds.length - 1;
                    }
                    if (currentPlayer == -2) {
                        currentPlayer = playerIds.length - 2;
                    }
                }
            }

    }
}
