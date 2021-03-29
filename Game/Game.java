/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Parnaek R. Siagian 18219114
 * @author Gian Denggan Bendjamin Simbolon 18219061
 * @author Muhammad Ichsandro D Noor 18219094
 */
public class Game {
    private int currentPlayer;
    private String[] playerIds;
    
    private Deck deck;
    private ArrayList<ArrayList<Card>> playerDeck;
    private ArrayList<Card> stockPile;
    
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
}
