package Game;

import CardDeck.*;
import Cards.*;

public class Hiji extends Thread {
    Player playergiliran;
    Deck deck = new Deck();

    public Hiji(Player playergiliran)
    {
        this.playergiliran = playergiliran;
    }

    public void declarehiji()
    {
        try
        {
            Thread.sleep(3000);
            System.out.println("3 detik telah terlewat dan Anda belum declare HIJI.");
            playergiliran.addCard(deck.draw());
            playergiliran.addCard(deck.draw());
            System.out.println("Anda mendapat 2 kartu.");
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
            System.out.println(playergiliran.getName() + " men-declare HIJI.");
            playergiliran.declaredHiji();
        }
    }
}
