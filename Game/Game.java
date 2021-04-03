/**
 *
 * @author Parnaek R. Siagian 18219114
 * @author Gian Denggan Bendjamin 18219061
 * @author Muhammad Ichsandro D Noor 18219094
 */

import Cards.*;
import CardDeck.*;
import Exceptions.*;
import java.util.ArrayList;
import java.util.Arrays;


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
 
    public Game(String[] playerIds){
        deck = new Deck();
        deck.buildDeck();
        stockPile = new ArrayList<Card>();
        
        this.playerIds = playerIds;
        currentPlayer = 0;
        GameDirection = false;
        
        playerDeck = new ArrayList<ArrayList<Card>>();
        
        for (int i=0; i < playerIds.length; i++){
            ArrayList<Card> hand = new ArrayList<Card>();
            for(int j=0; j < 7; j++){
               hand.add(deck.draw());
            }
            playerDeck.add(hand);
        }
    }

    public void StartGame(Game game){
        Card kartuAwal = deck.draw();
        angkaKartu = kartuAwal.getNumber();
        warnaKartu = kartuAwal.getColor();
        
        if (kartuAwal.getNumber() == -1){
            StartGame(game);
        }

        stockPile.add(kartuAwal);
    }   

    public Card getTopCard(){
        return (stockPile.get(stockPile.size()-1));
    }

    public String getCurrentPlayer(){
        return this.playerIds[this.currentPlayer];
    }

    public String getNextPlayer(){
        int nextPlayer = 0;

        if (GameDirection == false) {
            nextPlayer = (currentPlayer + 1) % playerIds.length;
        }

        else if (GameDirection == true) {
            nextPlayer = (currentPlayer - 1) % playerIds.length;
            if (nextPlayer == -1) {
                nextPlayer = playerIds.length - 1;
            }
        }
        return this.playerIds[nextPlayer];
    }

    public void getPlayers(){
        for(int i = 0; i < playerIds.length; i++){
            System.out.println("Pemain " + (i+1) + ": " + playerIds[i]);
            System.out.println("Jumlah Kartu: " + getPlayerDeck(playerIds[i]).size());
            if (getCurrentPlayer() == playerIds[i]){
                System.out.println("Sedang giliran");
            } else {
                System.out.println("Tidak sedang giliran");
            }
        }
    }

    public ArrayList<Card> getPlayerDeck(String player){
        int index = Arrays.asList(playerIds).indexOf(player);
        return playerDeck.get(index);
    }

    public boolean isGameOver(){
        for (String player : this.playerIds) {
            if (getPlayerDeck(player).isEmpty()){
                return true;
            }
        }
        return false;
    }

    public boolean validCard(Card card) {
        return (card.getColor() == warnaKartu || card.getNumber() == angkaKartu);
    }

    public void checkPlayerTurn(String playerId) throws InvalidPlayerTurnException {
        if(this.playerIds[this.currentPlayer] != playerId) {
            throw new InvalidPlayerTurnException("It's not"+ playerId + "'s turn", playerId);
        }
    }
    
    public void discard (String playerId, Card card, String declaredColor)
        throws InvalidColorException, InvalidPlayerTurnException, InvalidNumberException {
            checkPlayerTurn(playerId);

            if (!validCard(card)) {
                if(card instanceof Wildcard){
                    warnaKartu = card.getColor();
                    angkaKartu = card.getNumber();
                }

                if (card.getColor() != warnaKartu) {
                    String message = ("Invalid player move, expected color"+ warnaKartu +" but got color " + card.getColor());
                    throw new InvalidColorException(message, card.getColor(), warnaKartu);
                }
                else if (card.getNumber() != angkaKartu){
                    String message2 = ("Invalid player move, expected number"+ angkaKartu +" but got number " + card.getNumber());
                    throw new InvalidNumberException(message2, card.getNumber(), angkaKartu);
                }
            }

            getPlayerDeck(playerId).remove(card);

            if ((this.playerIds[currentPlayer]).isEmpty()){
                String winnerMessage = new String(this.playerIds[currentPlayer]+ "WON");
                System.out.println(winnerMessage);
            }

            warnaKartu = card.getColor();
            angkaKartu = card.getNumber();
            stockPile.add(card);

            if (GameDirection == false) {
                currentPlayer = (currentPlayer + 1) % playerIds.length;
            }

            else if (GameDirection == true) {
                currentPlayer = (currentPlayer - 1) % playerIds.length;
                if (currentPlayer == -1) {
                    currentPlayer = playerIds.length - 1;
                }
            }

            if (card instanceof Wildcard) {
                warnaKartu = declaredColor;
            }

            if (card instanceof DrawTwo) {
                playerId = playerIds[currentPlayer];
                getPlayerDeck(playerId).add(deck.draw());
                getPlayerDeck(playerId).add(deck.draw());
                System.out.println("draw 2 cards!");
            }

            if (card instanceof DrawFour) {
                playerId = playerIds[currentPlayer];
                getPlayerDeck(playerId).add(deck.draw());
                getPlayerDeck(playerId).add(deck.draw());
                getPlayerDeck(playerId).add(deck.draw());
                getPlayerDeck(playerId).add(deck.draw());
                System.out.println("draw 4 cards!");
            }

            if (card instanceof Skip){
                System.out.println(playerIds[currentPlayer] + "was skipped");
                if (GameDirection == false) {
                    currentPlayer = (currentPlayer + 1) % playerIds.length;
                }
    
                else if (GameDirection == true) {
                    currentPlayer = (currentPlayer - 1) % playerIds.length;
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
                    currentPlayer = (currentPlayer - 2) % playerIds.length;
                    if (currentPlayer == -1) {
                        currentPlayer = playerIds.length - 1;
                    }
                    if (currentPlayer == -2) {
                        currentPlayer = playerIds.length - 2;
                    }
                }
            }

    }

    public void declare(){

    }

}
