import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Queue;

// class to represent a Deck
public class Deck {
    // static variables
    // nonstatic variables
    private Queue<Card> cards = new LinkedList<>();
    // constructors
    public Deck() {
        initDeck();
        shuffle();
    }
    // mutators
    public void initDeck() {
        String[] suits = {"H", "S", "C", "D"}; //H, S, C, D for Hearts, Spades, Clubs, and Diamonds
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"};    
        for (String s : suits) {
            for (String v : values) {
                cards.add(new Card(v, s));
            }
        }
    }

    public void shuffle() {
        // code to shuffle cards
        Collections.shuffle((List<?>) cards);
        System.out.println("Deck has been shuffled.");
    }

    public Card removeCard(){
        if (cards.size() == 0) 
            throw new RuntimeException("No more cards");
        Card tmpCard = cards.poll();
        return tmpCard;
    }
    // accessors
    // prints/compares/etc
    public String toString() {
        String deckString = "";
        for(Card c : cards) {
            deckString += c.toString() + " ";
        }
        return deckString;
    }
    // static methods
}
