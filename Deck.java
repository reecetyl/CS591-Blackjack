import java.util.*;

public class Deck {

    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        initDeck();
        //initDeck2();
        //shuffle();
    }

    public void initDeck() {
    	for (Suit s: Suit.values()) {
			for (FaceValue v: FaceValue.values()) {
				cards.add(new Card(v, s));
			}
		}
    }

    public void initDeck2() {
        for (Suit s: Suit.values()) {
            FaceValue v = FaceValue.ACE;
            cards.add(new Card(v, s));
            cards.add(new Card(v, s));
            FaceValue f = FaceValue.FIVE;
            cards.add(new Card(f, s));
            cards.add(new Card(f, s));
            FaceValue q = FaceValue.NINE;
            cards.add(new Card(q, s));
            cards.add(new Card(q, s));

        }
    }


    public int getDeckSize() {
        return cards.size();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        if (getDeckSize()==0) {
            //shuffle();
            throw new RuntimeException("No more cards");
        }
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