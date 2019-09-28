import java.util.*;

public class Deck {

    private List<Card> cards = new ArrayList<>();
    private int headPoint; // the index of the top card in the deck

    public Deck() {
        initDeck();
        shuffle();
    }

    public void initDeck() {
    	for (Card.Suit s: Card.Suit.values()) {
			for (Card.Value v: Card.Value.values()) {
				cards.add(new Card(v, s));
			}
		}
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getDeckSize() {
        return cards.size();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        if (getDeckSize()==0)
            throw new RuntimeException("No more cards");
        Card tmpCard = cards.remove(getDeckSize()-1);
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