package CardDeck;

import java.util.ArrayList;
import java.util.Random;

import Cards.Card;
import Cards.DrawFour;
import Cards.DrawTwo;
import Cards.Number;
import Cards.Reverse;
import Cards.Skip;
import Cards.Wildcard;

public class Deck {
    private ArrayList<Card> deck;

    public Deck()
    {
        deck = new ArrayList<Card>();
        buildDeck();
    }

    public void buildDeck(){
        /* HIJI Deck terdiri dari 108 Card
        4 Wildcard
        4 Draw 4
        76 Each color Number: 1 Zero, 2 One-Nine
        8 Skip (2 each color)
        8 Reverse (2 each color)
        8 DrawTwo (2 each color)
        */

        //4 Wildcard
        deck.add(new Wildcard());
        deck.add(new Wildcard());
        deck.add(new Wildcard());
        deck.add(new Wildcard());

        //4 Draw 4
        deck.add(new DrawFour());
        deck.add(new DrawFour());
        deck.add(new DrawFour());
        deck.add(new DrawFour());

        //1 Zero Each Color
        deck.add(new Number(0,"Merah"));
        deck.add(new Number(0,"Kuning"));
        deck.add(new Number(0,"Hijau"));
        deck.add(new Number(0,"Biru"));

        //2 One to Nine Each Color
        for (int i=1;i<=9;i++){
            deck.add(new Number(i,"Merah"));
            deck.add(new Number(i,"Kuning"));
            deck.add(new Number(i,"Hijau"));
            deck.add(new Number(i,"Biru"));
        }
        for (int i=1;i<=9;i++){
            deck.add(new Number(i,"Merah"));
            deck.add(new Number(i,"Kuning"));
            deck.add(new Number(i,"Hijau"));
            deck.add(new Number(i,"Biru"));
        }

        //2 Skip Each Color
        deck.add(new Skip("Merah"));
        deck.add(new Skip("Merah"));
        deck.add(new Skip("Kuning"));
        deck.add(new Skip("Kuning"));
        deck.add(new Skip("Hijau"));
        deck.add(new Skip("Hijau"));
        deck.add(new Skip("Biru"));
        deck.add(new Skip("Biru"));

        //2 Reverse Each Color
        deck.add(new Reverse("Merah"));
        deck.add(new Reverse("Merah"));
        deck.add(new Reverse("Kuning"));
        deck.add(new Reverse("Kuning"));
        deck.add(new Reverse("Hijau"));
        deck.add(new Reverse("Hijau"));
        deck.add(new Reverse("Biru"));
        deck.add(new Reverse("Biru"));

        //2 DrawTwo Each Color
        deck.add(new DrawTwo("Merah"));
        deck.add(new DrawTwo("Merah"));
        deck.add(new DrawTwo("Kuning"));
        deck.add(new DrawTwo("Kuning"));
        deck.add(new DrawTwo("Hijau"));
        deck.add(new DrawTwo("Hijau"));
        deck.add(new DrawTwo("Biru"));
        deck.add(new DrawTwo("Biru"));
    }

    public Card draw()
    {
        //Apabila deck kosong akan dilakukan pengisian deck kembali
        if (deck.size() < 1) {
            buildDeck();
        }
        Random number = new Random();
        //Ambil integer dengan limit jumlah kartu di deck (mengembalikan int range 0 hingga deck.size()-1)
        int rand = number.nextInt(deck.size());

        //Kartu yang didraw akan disimpan ke temporary
        Card temp = deck.get(rand);

        //Menghapus isi deck pada indeks ke rand
        deck.remove(rand);
        return temp;
    }

}
