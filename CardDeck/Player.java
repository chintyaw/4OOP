package CardDeck;
import java.util.ArrayList;
import Cards.Card;
import CardDeck.Deck;

public class Player {
    private String playerName;
    private ArrayList<Card> playerHand;

    public Player(String playerName)
    {
        this.playerName = playerName;
        playerHand = new ArrayList<Card>();
    }

    public String getName()
    {
        return playerName;
    }

    public Card getCard(int i)
    {
        return playerHand.get(i);
    }

    public void addCard(Card c)
    {
        playerHand.add(c);
    }

    public void removeCard(int i)
    {
        playerHand.remove(i);
    }

    public int getJumlah()
    {
        return playerHand.size();
    }

    public void ListCards()
    {
        int i=1;
        for(Card x: playerHand){
            System.out.println(i+". "+x);
            i++;
        }
    }

    public void ShuffleSeven(Deck deck)
    {
        for (int i=0;i<7;i++){
            addCard(deck.draw());
        }
    }
}
