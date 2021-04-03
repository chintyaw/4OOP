package Game;

import java.util.Scanner;
import java.util.ArrayList;
import CardDeck.Deck;
import CardDeck.Player;
import Cards.*;

import java.util.ArrayList;

public class Game {
    public String nama;
    ArrayList<Player> players = new ArrayList<Player>();
    Scanner input = new Scanner(System.in);

    public Deck deck;
    public int  numplayers;
    public int giliran;
    public boolean clockwise = true;


    public Game()
    {
        System.out.print("Insert number of players: ");
        numplayers = input.nextInt();

        deck = new Deck();
        giliran = 0;

        for (int i=0;i<numplayers;i++)
        {
            System.out.print("Player " + (i+1) + " name: ");
            nama = input.next();
            players.add(new Player(nama));
        }

        for (Player p: players)
        {
            p.ShuffleSeven(deck);
        }
    }

    public void PlayerList()
    {
        int i=1;
        for (Player p: players)
        {
            System.out.println("Pemain " + (i) + ": " + p.getName());
            System.out.println("Jumlah Kartu: "+p.getJumlah());
            if (i-1 == giliran)
            {
                System.out.println("Sedang giliran");
            }
            else
            {
                System.out.println("Tidak sedang giliran");
            }
            i++;
        }
    }
}
