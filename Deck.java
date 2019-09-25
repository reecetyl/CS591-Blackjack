import java.util.*;
public class Deck {

    private List<Card> cards = new LinkedList<>();
    private int headPoint; // the index of the top card in the deck
    private int leftCards; // the number of cards left in the current deck

    public Deck() {
        initDeck();
    }

    public void initDeck() {
        String[] suits = {"H", "S", "C", "D"}; //H, S, C, D for Hearts, Spades, Clubs, and Diamonds
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};


        for (String s : suits) {
            for (String v : values) {
                cards.add(new Card(v, s));
            }
        }
        setLeftCards(cards.size());
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getLeftCards() {
        return leftCards;
    }

    public void setLeftCards(int leftCards) {
        this.leftCards = leftCards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
        headPoint = 0;
        setLeftCards(cards.size());
    }

    public Card dealCard(){
        if (this.headPoint > cards.size()-1) 
            throw new RuntimeException("No more cards");
        Card tmpCard = cards.get(headPoint);
        headPoint++;
        leftCards--;
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