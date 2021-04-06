package Game;

import CardDeck.*;
import Cards.*;

public class Hiji implements Runnable {
    Player playergiliran;
    Game game;
    Deck deck = new Deck();

    public Hiji(Player playergiliran, Game game)
    {
        this.playergiliran = playergiliran;
        this.game = game;
    }

    public void run()
    {
        try
        {
            Thread.sleep(3000);
            System.out.println("3 detik telah terlewat dan Anda belum declare HIJI.");
            playergiliran.addCard(deck.draw());
            playergiliran.addCard(deck.draw());
            System.out.println("Anda mendapat 2 kartu.");
            game.nextPlayer();
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
            System.out.println(playergiliran.getName() + " men-declare HIJI.");
            playergiliran.declaredHiji();
            game.nextPlayer();
        }
    }
}
