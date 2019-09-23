import java.util.*;

public class Hand {
    List<Card> cards = new ArrayList<>();
    List<Card> splitCards = new ArrayList<>(); //if the case of splitting
    
    Hand() {
        this.cards = new ArrayList<Card>(10);
        this.splitCards = new ArrayList<>(10);
        this.cards.clear();
        this.splitCards.clear();
    }

    public void add(Card card) {
	    cards.add(card);
    }

    public void add(List<Card> cards) {
	    this.cards.addAll(cards);
    }

    public void clear() {
	    cards.clear();
    }
 
    public boolean isSplitable() {
        return false;
    }

    public List<Card> getCards() {
	return cards;
    }

    public Integer getNumCards() {
	return cards.size() + splitCards.size();
    }

    public Integer getScore() {
	Integer handScore = 0;
	for(Card c : cards) {
		handScore += c.getScore();
	}
	return handScore;
    }
    
    public String toString() {
        String cardString = "HAND: ";
        for(Card c: cards) {
            cardString += c.toString() + " ";
        }
	return cardString;
    }
}
