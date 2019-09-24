import java.util.*;
public class Deck {

    private Queue<Card> cards = new LinkedList<>();
    public Deck() {
        initDeck();
        shuffle();
    }

    public void initDeck() {
        String[] suits = {"H", "S", "C", "D"}; //H, S, C, D for Hearts, Spades, Clubs, and Diamonds
        //String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"};   
        String[] values = {"A", "J"}; 
        for (String s : suits) {
            for (String v : values) {
                cards.add(new Card(v, s));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle((List<?>) cards);
        System.out.println("Deck has been shuffled.");
    }

    public Card dealCard(){
        if (cards.size() == 0) 
            throw new RuntimeException("No more cards");
        Card tmpCard = cards.poll();
        return tmpCard;
    }

    public String toString() {
        String deckString = "";
        for(Card c : cards) {
            deckString += c.toString() + " ";
        }
        return deckString;
    }

}