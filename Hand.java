import java.util.*;

public class Hand {
    List<Card> cards = new ArrayList<>();
    List<Card> cards2 = new ArrayList<>(); //if the case of splitting
    
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

    public Integer getScore() {
	Integer handScore = 0;
	for(Card c : cards) {
		handScore += c.getScore();
	}
	return handScore;
    }
    
    public String toString() {
        String cardString = "";
        for(Card c: cards) {
            cardString += c.toString() + " ";
        }
	return cardString;
    }
}
