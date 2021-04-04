package Game;

import java.util.Scanner;
import java.util.ArrayList;
import CardDeck.Deck;
import CardDeck.Player;
import Exceptions.*;
import Cards.*;

import java.util.ArrayList;

public class Game {
    public String nama;
    ArrayList<Player> players = new ArrayList<Player>();
    
    int CountCardDiscard = 0;
    
    int jumlahTwo = 0;
    int jumlahFour = 0;
    int jumlahSkip = 0;
    int jumlahReverse = 0;

    Scanner input = new Scanner(System.in);

    String warnaKartu;
    int angkaKartu;

    public Deck deck;
    public int  numplayers;
    public int giliran;
    public boolean clockwise = true;

    public Card currentcard;

    public Game()
    {
        System.out.print("Insert number of players: ");
        numplayers = input.nextInt();

        deck = new Deck();
        currentcard = deck.draw();

        while (currentcard.getNumber() == -1)
        {
            currentcard = deck.draw();
        }

        warnaKartu = currentcard.getColor();
        angkaKartu = currentcard.getNumber();

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

    public void ViewPlayerTurn()
    {
        Player playergiliran = players.get(giliran);
        System.out.println("Pemain giliran: " + playergiliran.getName());

        if (clockwise == true)
        {
            Player playernext = players.get((giliran+1)%numplayers);
            System.out.println("Pemain selanjutnya: " + playernext.getName());
        }
        else
        {
            Player playernext = players.get((giliran-1)%numplayers);
            System.out.println("Pemain selanjutnya: " + playernext.getName());
        }
    }

    public Player getNextPlayer()
    {
        if (clockwise == true)
        {
            Player playernext = players.get((giliran+1)%numplayers);
            return (playernext);
        }
        else
        {
            Player playernext = players.get((giliran-1)%numplayers);
            return (playernext);
        }
    }

    public void PlayerDraw()
    {
        Player playergiliran = players.get(giliran);
        playergiliran.addCard(deck.draw());
    }

    public boolean validCard(Card card) {
        return (card.getColor() == warnaKartu || card.getNumber() == angkaKartu);
    }

    public void nextPlayer()
    {
        if (clockwise == true)
        {
            giliran = (giliran+1)%numplayers;
        }
        else
        {
            giliran = (giliran-1)%numplayers;
        }
    }

    public void discard ()
            throws InvalidColorException, InvalidNumberException {
        // cek kartu top
        boolean stop_discard = false ;
        Player playergiliran = players.get(giliran);

        while (!stop_discard){
            System.out.print("Masukkan kartu yang ingin di-discard: ");
            int pilihkartu = input.nextInt();
            while (pilihkartu < 0 || pilihkartu > playergiliran.getJumlah()){
                System.out.println("Masukan tidak valid. Masukkan angka sesuai dengan list kartu.");
                // pilihkartu apabila bernilai nol maka sudah 
                pilihkartu = input.nextInt();
            }
            
            if (pilihkartu == 0){
                if (CountCardDiscard == 0){
                    playergiliran.addCard(deck.draw());
                    CountCardDraw += 1;
                    if(CountCardDraw == 1){
                        nextPlayer();
                    }
                }
                else {
                    CountCardDiscard = 0;
                    if (currentcard instanceof DrawTwo) {
                        nextPlayer();
                        System.out.println("NEXT TURN! Silahkan Player " + playergiliran.getName() + " bermain.");
                        boolean found = false;
                        for (Card c: playergiliran.playerHand){
                            if (c instanceof DrawTwo)
                            {
                                found = true;
                            }
                        }

                        if (!found)
                        {
                            for (int i=0;i<jumlahTwo;i++)
                            {
                                playergiliran.addCard(deck.draw());
                                playergiliran.addCard(deck.draw());
                            }
                            System.out.println("Draw " + 2*jumlahTwo + " cards!");

                            nextPlayer();
                            System.out.println("NEXT TURN! Silahkan Player " + playergiliran.getName() + " bermain.");
                            jumlahTwo = 0;
                        }
                        else
                        {
                            System.out.print("Pilih 1 untuk memasukkan kartu +2 Anda");
                            System.out.print("Pilih 2 untuk langsung mengambil kartu");
                            int pilihan = input.nextInt();
                            if (pilihan == 1){
                                System.out.print("Masukkan kartu yang ingin di-discard: ");
                                int pilihkartu = input.nextInt();
                                while (pilihkartu < 1 || pilihkartu > playergiliran.getJumlah())
                                {
                                    System.out.println("Masukan tidak valid. Masukkan angka sesuai dengan list kartu.");
                                    pilihkartu = input.nextInt();
                                }

                                Card card = playergiliran.getCard(pilihkartu-1);

                                if (card instanceof DrawTwo)
                                {
                                    playergiliran.removeCard(pilihkartu-1);
                                    jumlahTwo += 1;
                                }   
                            }

                            else if (pilihan == 2)
                            {
                                for (int i=0;i<jumlahTwo;i++)
                                {
                                    playergiliran.addCard(deck.draw());
                                    playergiliran.addCard(deck.draw());
                                }

                                System.out.println("Draw " + 2*jumlahTwo + " cards!");

                                nextPlayer();
                                System.out.println("NEXT TURN! Silahkan Player " + playergiliran.getName() + " bermain.");
                                jumlahTwo = 0;
                            }
                        }
                    }   

                    else if (currentcard instanceof DrawFour)
                    {
                        nextPlayer();
                        System.out.println("NEXT TURN! Silahkan Player " + playergiliran.getName() + " bermain.");
                        for (int i=0; i<jumlahFour; i++){
                            playergiliran.addCard(deck.draw());
                            playergiliran.addCard(deck.draw());
                            playergiliran.addCard(deck.draw());
                            playergiliran.addCard(deck.draw());

                            System.out.println("Draw " + 4*jumlahFour + " cards!");

                            jumlahFour = 0;
                        }
                    }

                    else if (currentcard instanceof Skip)
                    {
                        nextPlayer();
                        for (int i=0; i<jumlahSkip; i++){
                            nextPlayer();
                        }
                        System.out.println("NEXT TURN! Silahkan Player " + playergiliran.getName() + " bermain.");
                    }
                    
                    else if (currentcard instanceof Reverse)
                    {
                        if(jumlahReverse%2==1){
                            clockwise = !clockwise;
                        }
                        nextPlayer();
                        System.out.println("NEXT TURN! Silahkan Player " + playergiliran.getName() + " bermain.");
                    }
                }
            }
            
            else {
                Card card = playergiliran.getCard(pilihkartu-1);

                if (!validCard(card)) {
                    if(card instanceof Wildcard){
                        /* warnaKartu = card.getColor();
                        angkaKartu = card.getNumber(); */
                    }

                    else if (card instanceof DrawFour)
                    {

                    }

                    else if (card.getColor() != warnaKartu) {
                        String message = ("Invalid player move, expected color"+ warnaKartu +" but got color " + card.getColor());
                        throw new InvalidColorException(message, card.getColor(), warnaKartu);
                    }
                    else if (card.getNumber() != angkaKartu){
                        String message2 = ("Invalid player move, expected number"+ angkaKartu +" but got number " + card.getNumber());
                        throw new InvalidNumberException(message2, card.getNumber(), angkaKartu);
                    }
                }

                playergiliran.removeCard(pilihkartu-1);
                CountCardDiscard += 1;

                if (playergiliran.getJumlah() == 0){
                    String winnerMessage = new String(playergiliran.getName() + " WON!");
                    System.out.println(winnerMessage);
                    stop_discard = true;
                }

                warnaKartu = card.getColor();
                angkaKartu = card.getNumber();
                currentcard = card;

                if (currentcard instanceof Wildcard) {
                    System.out.print("Masukkan warna pilihan: ");
                    String declaredColor = input.next();
                    warnaKartu = declaredColor;
                }

                if (currentcard instanceof DrawTwo) {
                    jumlahTwo += 1;
                }

                if (currentcard instanceof DrawFour) {
                    jumlahFour += 1;
                }

                if (currentcard instanceof Skip){
                    jumlahSkip += 1;
                }

                if (currentcard instanceof Reverse){
                    jumlahReverse += 1;
                }
            }
        }
    }
}
