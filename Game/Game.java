package Game;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import CardDeck.Deck;
import CardDeck.Player;
import Exceptions.*;
import Cards.*;


public class Game{
    public String nama;
    ArrayList<Player> players = new ArrayList<Player>();

    private static int jumlahTwo = 0;
    private static int skipcount;

    Scanner input = new Scanner(System.in);

    private String warnaKartu;
    private int angkaKartu;

    public Deck deck;
    public int  numplayers;
    public int giliran;
    public boolean clockwise = true;

    public Card currentcard;

    public Game()
    {
        System.out.println();
        System.out.println("MEMULAI PERMAINAN");
        System.out.print("Insert number of players: ");
        numplayers = input.nextInt();
        while (numplayers <= 1){
            System.out.println("insufficient number of players");
            System.out.print("Insert number of players: ");
            numplayers = input.nextInt();
        }

        deck = new Deck();
        currentcard = deck.draw();

        while (currentcard.getNumber() == -1)
        {
            currentcard = deck.draw();
        }

        warnaKartu = currentcard.getColor();
        angkaKartu = currentcard.getNumber();

        Random number = new Random();
        giliran = number.nextInt(numplayers);

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
        Player playergiliran = players.get(giliran);
        System.out.println(playergiliran.getName()+" mendapat giliran pertama!");
        System.out.println();
    }

    public void PlayerList()
    {
        System.out.println();
        System.out.println("LIST PEMAIN");
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
            System.out.println();
        }
    }

    public void ViewPlayerTurn()
    {
        System.out.println();
        System.out.println("MELIHAT GILIRAN");
        Player playergiliran = players.get(giliran);
        System.out.println("Pemain giliran: " + playergiliran.getName());

        if (clockwise == true)
        {
            Player playernext = players.get((giliran+skipcount+1)%numplayers);
            System.out.println("Pemain selanjutnya: " + playernext.getName());
        }
        else
        {

            int giliranNext = ((giliran-skipcount-1)%numplayers);
            if (giliranNext == -1) {
                giliranNext = numplayers - 1;
            } else if (giliranNext == -skipcount) {
                giliranNext = numplayers - skipcount;
            } else if (giliranNext == -skipcount-1) {
                giliranNext = numplayers - skipcount-1;
            }
            Player playernext = players.get(giliranNext);
            System.out.println("Pemain selanjutnya: " + playernext.getName());
        }
        System.out.println();
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
            int giliranNext = ((giliran-1)%numplayers);
            if (giliranNext == -1) {
                giliranNext = numplayers - 1;
            }
            Player playernext = players.get(giliranNext);
            return (playernext);
        }
    }

    public void PlayerDraw()
    {
        System.out.println();
        System.out.println("DRAW A CARD");
        Player playergiliran = players.get(giliran);
        playergiliran.hiji = false;
        playergiliran.addCard(deck.draw());
        Card card = playergiliran.getCard(playergiliran.getJumlah()-1);
        System.out.println(playergiliran.getName()+" mengambil "+ card);
        if (!validCard(card)) {
            if(card instanceof Wildcard){
                System.out.println();
            }

            else if (card instanceof DrawFour)
            {
                System.out.println();
            }
            else{
                nextPlayer();
            }
        }
        else {
            if (currentcard instanceof Wildcard || currentcard instanceof DrawFour)
            {
                if (card instanceof Wildcard || card instanceof DrawFour)
                {
                    System.out.println();
                } 
                else
                {
                    nextPlayer();
                }
            }
            if (currentcard instanceof Skip)
            {
                if (card instanceof Skip || card instanceof Wildcard || card instanceof DrawFour || card.getColor() == warnaKartu){
                    System.out.println();
                }
                else
                {
                    nextPlayer();
                }
            }

            if (currentcard instanceof Reverse)
            {
                if (card instanceof Reverse || card instanceof Wildcard || card instanceof DrawFour || card.getColor() == warnaKartu){
                    System.out.println();
                }
                else
                {
                    nextPlayer();
                }
            }

            if (currentcard instanceof DrawTwo)
                {
                if (card instanceof DrawTwo || card.getColor() == warnaKartu){
                    System.out.println();
                }
                else
                {
                    nextPlayer();
                }
            }
        }
    }

    public boolean validCard(Card card) {
        return (card.getColor().equals(warnaKartu) || card.getNumber() == angkaKartu);
    }

    public void nextPlayer()
    {
        System.out.println();
        if (clockwise == true)
        {
            giliran = (giliran+skipcount+1)%numplayers;
            skipcount = 0;
        }
        else
        {
            giliran = (giliran-skipcount-1)%numplayers;
            if (giliran == -1) {
                giliran = numplayers - 1;
            }
            skipcount = 0;
        }
        System.out.println("Sekarang giliran "+ players.get(giliran).getName());
        System.out.println();
    }

    public void stop()
    {
        System.out.println("Permainan selesai.");
        System.exit(0);
    }

    public synchronized void discard()
            throws InvalidColorException, InvalidNumberException {
        // cek kartu top
        System.out.println();
        System.out.println("MELAKUKAN DISCARD");
        Player playergiliran = players.get(giliran);
        if (currentcard instanceof Wildcard || currentcard instanceof DrawFour)
        {
            System.out.println("Kartu saat ini: "+ currentcard +" "+ warnaKartu);
        }
        else
        {
            System.out.println("Kartu saat ini: "+ currentcard);
        }
        System.out.println("Kartu yang anda miliki: ");
        playergiliran.ListCards();

        if (jumlahTwo > 0)
        {
            boolean found = false;
            int index = 0;
            for (Card c: playergiliran.playerHand)
            {
                if (c instanceof DrawTwo)
                {
                    found = true;
                    index += 1;
                }
            }

            if (found) {
                System.out.print("Masukkan kartu Draw 2 yang ingin di-discard: ");
                int pilihkartu = input.nextInt();
                while (pilihkartu < 1 || pilihkartu > playergiliran.getJumlah())
                {
                    System.out.println("Masukan tidak valid. Masukkan angka sesuai dengan list kartu.");
                    pilihkartu = input.nextInt();
                }

                Card card = playergiliran.getCard(pilihkartu-1);

                while (!(card instanceof DrawTwo)){
                    System.out.print("Masukkan kartu Draw 2 yang ingin di-discard: ");
                    pilihkartu = input.nextInt();
                    while (pilihkartu < 1 || pilihkartu > playergiliran.getJumlah())
                    {
                        System.out.println("Masukan tidak valid. Masukkan angka sesuai dengan list kartu.");
                        pilihkartu = input.nextInt();
                    }

                    card = playergiliran.getCard(pilihkartu-1);
                }

                if (card instanceof DrawTwo)
                {
                    int countDrawTwo = 0;
                    for (Card c: playergiliran.playerHand)
                    {
                        if (c instanceof DrawTwo && c.getColor().equals(card.getColor()))
                        {
                            countDrawTwo += 1;
                        }
                    }
                    System.out.println("Anda memiliki "+ countDrawTwo +" Draw 2 "+ card.getColor());
                    System.out.print("Berapa Draw Two yang ingin di-discard: ");
                    int pilih = input.nextInt();
                    while (pilih > countDrawTwo){
                        System.out.println("Anda hanya punya "+ countDrawTwo +" Draw 2 "+ card.getColor());
                        System.out.print("Berapa Draw Two yang ingin di-discard: ");
                        pilih = input.nextInt();
                    }
                    jumlahTwo += pilih;
                    index = 0;
                    while (pilih > 0){
                        for (Card c: playergiliran.playerHand)
                        {
                            if (c instanceof DrawTwo && c.getColor().equals(warnaKartu))
                            {
                                playergiliran.removeCard(index);
                                index = 0;
                                pilih -= 1;
                                break;
                            }
                            index += 1;
                        }
                    }
                    Player playernext = getNextPlayer();
                    found = false;

                    for (Card c: playernext.playerHand)
                    {
                        if (c instanceof DrawTwo)
                        {
                            found = true;
                        }
                    }

                    if (!found)
                    {
                        for (int i=0;i<jumlahTwo;i++)
                        {
                            playernext.addCard(deck.draw());
                            playernext.addCard(deck.draw());
                        }
                        System.out.println(playernext.getName()+ " draw " + 2*jumlahTwo + " cards!");
                        System.out.println(playernext.getName()+ " kehilangan giliran!");
                        skipcount += 1;
                        jumlahTwo = 0;
                    }
                    System.out.println("Anda telah melakukan discard");
                    if (playergiliran.getJumlah() == 0){
                        String winnerMessage = new String(playergiliran.getName() + " WON!");
                        System.out.println(winnerMessage);
                        stop();
                    }
                    else if (playergiliran.getHiji() == false && playergiliran.getJumlah() == 1)
                    {
                        //balik ke menu dan mulai thread
                    } 
                    else
                    {
                        nextPlayer();
                    }
                }
            }
        }
        else
        {
            System.out.print("Masukkan kartu yang ingin di-discard: ");
            int pilihkartu = input.nextInt();
            while (pilihkartu < 1 || pilihkartu > playergiliran.getJumlah())
            {
                System.out.println("Masukan tidak valid. Masukkan angka sesuai dengan list kartu.");
                System.out.print("Masukkan kartu yang ingin di-discard: ");
                pilihkartu = input.nextInt();
            }
            Card card = playergiliran.getCard(pilihkartu-1);

            if (!validCard(card)) {
                if(card instanceof Wildcard){
                    //warnaKartu = card.getColor();
                    //angkaKartu = card.getNumber();
                }

                else if (card instanceof DrawFour)
                {

                }

                else if (!(card.getColor().equals(warnaKartu))) {
                    String message = ("Invalid player move, expected color "+ warnaKartu +" but got color " + card.getColor());
                    throw new InvalidColorException(message);
                }
                else if (card.getNumber() != angkaKartu){
                    String message2 = ("Invalid player move, expected number "+ angkaKartu +" but got number " + card.getNumber());
                    throw new InvalidNumberException(message2);
                }
            }
            // kartu valid (color sama or angka sama)
            else {
                if (currentcard instanceof Wildcard || currentcard instanceof DrawFour){
                    if (card instanceof Wildcard || card instanceof DrawFour){

                    } else {
                        if (!card.getColor().equals(warnaKartu)) {
                            String message = ("Invalid player move, expected color "+ warnaKartu +" but got color " + card.getColor());
                            throw new InvalidColorException(message);
                        }
                    }
                }

                if (currentcard instanceof Skip)
                {
                    if (card instanceof Skip || card instanceof Wildcard || card instanceof DrawFour || card.getColor() == warnaKartu){}
                    else
                    {
                        if (!card.getColor().equals(warnaKartu)) {
                            String message = ("Invalid player move, expected color "+ warnaKartu +" but got color " + card.getColor());
                            throw new InvalidColorException(message);
                        }
                        else
                        {
                            String message = ("Invalid player move, expected card Skip");
                            throw new InvalidColorException(message);
                        }
                    }
                }

                if (currentcard instanceof Reverse)
                {
                    if (card instanceof Reverse || card instanceof Wildcard || card instanceof DrawFour || card.getColor() == warnaKartu){}
                    else
                    {
                        if (!card.getColor().equals(warnaKartu)) {
                            String message = ("Invalid player move, expected color "+ warnaKartu +" but got color " + card.getColor());
                            throw new InvalidColorException(message);
                        }
                        else
                        {
                            String message = ("Invalid player move, expected card Reverse");
                            throw new InvalidColorException(message);
                        }
                    }
                }

                if (currentcard instanceof DrawTwo)
                {
                    if (card instanceof DrawTwo || card.getColor() == warnaKartu){}
                    else
                    {
                        if (!card.getColor().equals(warnaKartu)) {
                            String message = ("Invalid player move, expected color "+ warnaKartu +" but got color " + card.getColor());
                            throw new InvalidColorException(message);
                        }
                        else
                        {
                            String message = ("Invalid player move, expected card DrawTwo");
                            throw new InvalidColorException(message);
                        }
                    }
                }
            }

            //playergiliran.removeCard(pilihkartu-1);

            warnaKartu = card.getColor();
            angkaKartu = card.getNumber();
            currentcard = card;

            if (currentcard instanceof Wildcard) {
                int countWild = 0;
                for (Card c: playergiliran.playerHand)
                {
                    if (c instanceof Wildcard)
                    {
                        countWild += 1;
                    }
                }
                System.out.println("Anda memiliki "+ countWild +" WildCard");
                System.out.print("Berapa WildCard yang ingin di-discard: ");
                int pilih = input.nextInt();
                while (pilih > countWild){
                    System.out.println("Anda hanya punya "+ countWild +" WildCard!");
                    System.out.print("Berapa WildCard yang ingin di-discard: ");
                    pilih = input.nextInt();
                }
                int index = 0;
                while (pilih > 0){
                    for (Card c: playergiliran.playerHand)
                    {
                        if (c instanceof Wildcard)
                        {
                            playergiliran.removeCard(index);
                            index = 0;
                            pilih -= 1;
                            break;
                        }
                        index += 1;
                    }
                }
                System.out.print("Masukkan warna pilihan: ");
                String declaredColor = input.next();
                while (!(declaredColor.equals("Merah") || declaredColor.equals("Kuning") || declaredColor.equals("Hijau") || declaredColor.equals("Biru"))){
                    System.out.println("Masukkan warna tidak sesuai!");
                    System.out.print("Masukkan warna pilihan: ");
                    declaredColor = input.next();
                }
                warnaKartu = declaredColor;
                System.out.println("Anda telah melakukan discard");
                if (playergiliran.getJumlah() == 0){
                    String winnerMessage = new String(playergiliran.getName() + " WON!");
                    System.out.println(winnerMessage);
                    stop();
                }
                else if (playergiliran.getHiji() == false && playergiliran.getJumlah() == 1)
                {
                    //balik ke menu dan mulai thread
                } 
                else
                {
                    nextPlayer();
                }
            }
            else if (currentcard instanceof DrawTwo) {
                int countDrawTwo = 0;
                for (Card c: playergiliran.playerHand)
                {
                    if (c instanceof DrawTwo && c.getColor().equals(warnaKartu))
                    {
                        countDrawTwo += 1;
                    }
                }
                System.out.println("Anda memiliki "+ countDrawTwo +" Draw 2 "+ warnaKartu);
                System.out.print("Berapa Draw Two yang ingin di-discard: ");
                int pilih = input.nextInt();
                while (pilih > countDrawTwo){
                    System.out.println("Anda hanya punya "+ countDrawTwo +" Draw 2 "+ warnaKartu);
                    System.out.print("Berapa Draw Two yang ingin di-discard: ");
                    pilih = input.nextInt();
                }
                jumlahTwo += pilih;
                int index = 0;
                while (pilih > 0){
                    for (Card c: playergiliran.playerHand)
                    {
                        if (c instanceof DrawTwo && c.getColor().equals(warnaKartu))
                        {
                            playergiliran.removeCard(index);
                            index = 0;
                            pilih -= 1;
                            break;
                        }
                        index += 1;
                    }
                }
                Player playernext = getNextPlayer();
                boolean found = false;

                for (Card c: playernext.playerHand)
                {
                    if (c instanceof DrawTwo)
                    {
                        found = true;
                    }
                }

                if (!found)
                {
                    for (int i=0;i<jumlahTwo;i++)
                    {
                        playernext.addCard(deck.draw());
                        playernext.addCard(deck.draw());
                    }
                    System.out.println(playernext.getName()+ " draw " + 2*jumlahTwo + " cards!");
                    System.out.println(playernext.getName()+ " kehilangan giliran!");
                    skipcount += 1;
                    jumlahTwo = 0;
                }
                System.out.println("Anda telah melakukan discard");
                if (playergiliran.getJumlah() == 0){
                    String winnerMessage = new String(playergiliran.getName() + " WON!");
                    System.out.println(winnerMessage);
                    stop();
                }
                else if (playergiliran.getHiji() == false && playergiliran.getJumlah() == 1)
                {
                    //balik ke menu dan mulai thread
                } 
                else
                {
                    nextPlayer();
                }
            }

            else if (currentcard instanceof DrawFour) {
                int countDrawFour = 0;
                for (Card c: playergiliran.playerHand)
                {
                    if (c instanceof DrawFour)
                    {
                        countDrawFour += 1;
                    }
                }
                System.out.println("Anda memiliki "+ countDrawFour +" Draw 4");
                System.out.print("Berapa Draw Four yang ingin di-discard: ");
                int pilih = input.nextInt();
                while (pilih > countDrawFour){
                    System.out.println("Anda memiliki "+ countDrawFour +" Draw 4");
                    System.out.print("Berapa Draw Four yang ingin di-discard: ");
                    pilih = input.nextInt();
                }
                int index = 0;
                while (pilih > 0){
                    for (Card c: playergiliran.playerHand)
                    {
                        if (c instanceof DrawFour)
                        {
                            playergiliran.removeCard(index);
                            index = 0;
                            pilih -= 1;
                            break;
                        }
                        index += 1;
                    }
                }
                Player playernext = getNextPlayer();
                playernext.addCard(deck.draw());
                playernext.addCard(deck.draw());
                playernext.addCard(deck.draw());
                playernext.addCard(deck.draw());
                System.out.println(playernext.getName()+ " draw 4 cards!");
                System.out.print("Masukkan warna pilihan: ");
                String declaredColor = input.next();
                while (!(declaredColor.equals("Merah") || declaredColor.equals("Kuning") || declaredColor.equals("Hijau") || declaredColor.equals("Biru"))){
                    System.out.println("Masukkan warna tidak sesuai!");
                    System.out.print("Masukkan warna pilihan: ");
                    declaredColor = input.next();
                }
                warnaKartu = declaredColor;
                System.out.println("Anda telah melakukan discard");
                if (playergiliran.getJumlah() == 0){
                    String winnerMessage = new String(playergiliran.getName() + " WON!");
                    System.out.println(winnerMessage);
                    stop();
                }
                else if (playergiliran.getHiji() == false && playergiliran.getJumlah() == 1)
                {
                    //balik ke menu dan mulai thread
                } 
                else
                {
                    nextPlayer();
                }
            }

            else if (currentcard instanceof Skip){
                int countSkip = 0;
                for (Card c: playergiliran.playerHand)
                {
                    if (c instanceof Skip && c.getColor().equals(warnaKartu))
                    {
                        countSkip += 1;
                    }
                }
                System.out.println("Anda memiliki "+ countSkip +" Skip "+ warnaKartu);
                System.out.print("Berapa Skip yang ingin di-discard: ");
                int pilih = input.nextInt();
                while (pilih > countSkip){
                    System.out.println("Anda memiliki "+ countSkip +" Skip "+ warnaKartu);
                    System.out.print("Berapa Skip yang ingin di-discard: ");
                    pilih = input.nextInt();
                }
                skipcount += pilih;
                int index = 0;
                while (pilih > 0){
                    for (Card c: playergiliran.playerHand)
                    {
                        if (c instanceof Skip && c.getColor().equals(warnaKartu))
                        {
                            playergiliran.removeCard(index);
                            index = 0;
                            pilih -= 1;
                            break;
                        }
                        index += 1;
                    }
                }
                System.out.println("Anda telah melakukan discard");
                if (playergiliran.getJumlah() == 0){
                    String winnerMessage = new String(playergiliran.getName() + " WON!");
                    System.out.println(winnerMessage);
                    stop();
                }
                else if (playergiliran.getHiji() == false && playergiliran.getJumlah() == 1)
                {
                    //balik ke menu dan mulai thread
                } 
                else
                {
                    nextPlayer();
                }
            }

            else if (currentcard instanceof Reverse){
                int countReverse = 0;
                for (Card c: playergiliran.playerHand)
                {
                    if (c instanceof Reverse && c.getColor().equals(warnaKartu))
                    {
                        countReverse += 1;
                    }
                }
                System.out.println("Anda memiliki "+ countReverse +" Reverse "+ warnaKartu);
                System.out.print("Berapa Reverse yang ingin di-discard: ");
                int pilih = input.nextInt();
                while (pilih > countReverse){
                    System.out.println("Anda memiliki "+ countReverse +" Reverse "+ warnaKartu);
                    System.out.print("Berapa Reverse yang ingin di-discard: ");
                    pilih = input.nextInt();
                }
                for (int i = 0; i < pilih; i++){
                    if (clockwise == false) {
                        clockwise = true;
                    }

                    else if (clockwise == true) {
                        clockwise = false;
                    }
                }
                int index = 0;
                while (pilih > 0){
                    for (Card c: playergiliran.playerHand)
                    {
                        if (c instanceof Reverse && c.getColor().equals(warnaKartu))
                        {
                            playergiliran.removeCard(index);
                            index = 0;
                            pilih -= 1;
                            break;
                        }
                        index += 1;
                    }
                }
                System.out.println(playergiliran.getName() + " change the game direction");
                System.out.println("Anda telah melakukan discard");
                if (playergiliran.getJumlah() == 0){
                    String winnerMessage = new String(playergiliran.getName() + " WON!");
                    System.out.println(winnerMessage);
                    stop();
                }
                else if (playergiliran.getHiji() == false && playergiliran.getJumlah() == 1)
                {
                    //balik ke menu dan mulai thread
                } 
                else
                {
                    nextPlayer();
                }
            }
            else {//Kartu Number
                int countNumberCard = 0;
                for (Card c: playergiliran.playerHand)
                {
                    if (c.getNumber() == angkaKartu && c.getColor().equals(warnaKartu))
                    {
                        countNumberCard += 1;
                    }
                }
                System.out.println("Anda memiliki "+ countNumberCard +" Kartu "+currentcard.getNumber()+" "+ warnaKartu);
                System.out.print("Berapa "+ currentcard.getNumber()+" "+ warnaKartu+" yang ingin di-discard: ");
                int pilih = input.nextInt();
                while (pilih > countNumberCard){
                    System.out.println("Anda hanya punya "+ countNumberCard +" Kartu "+currentcard.getNumber()+" "+ warnaKartu);
                    System.out.print("Berapa "+ currentcard.getNumber()+" "+ warnaKartu+" yang ingin di-discard: ");
                    pilih = input.nextInt();
                }
                int index = 0;
                while (pilih > 0){
                    for (Card c: playergiliran.playerHand)
                    {
                        if (c.getNumber() == angkaKartu && c.getColor().equals(warnaKartu))
                        {
                            playergiliran.removeCard(index);
                            index = 0;
                            pilih -= 1;
                            break;
                        }
                        index += 1;
                    }
                }
                System.out.println("Anda telah melakukan discard");
                if (playergiliran.getJumlah() == 0){
                    String winnerMessage = new String(playergiliran.getName() + " WON!");
                    System.out.println(winnerMessage);
                    stop();
                }
                else if (playergiliran.getHiji() == false && playergiliran.getJumlah() == 1)
                {
                    //balik ke menu dan mulai thread
                } 
                else
                {
                    nextPlayer();
                }
            }
        }
    }
}

