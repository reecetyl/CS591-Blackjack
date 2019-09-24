import java.util.*;
public class Hand {
    List<Card> cards = new ArrayList<>();
    Integer score = 0;
    
    Hand() {
        cards.clear();
    }

    public void add(Card card) {
	    cards.add(card);
	    score += card.getScore();
    }

    public void add(List<Card> cards) {
	    this.cards.addAll(cards);
    }

    public void clear() {
	    cards.clear();
    }

    public List<Card> getCards() {
	    return cards;
    }
    
    public Card getFirstCard() {
        return cards.get(0);
    }

    public Integer getNumCards() {
	    return cards.size();
    }

    public Integer getScore() {
	    return this.score;
    }
    
    public String toString() {
        String cardString = "HAND: ";
        for(Card c: cards) {
            cardString += c.toString() + " ";
        }
        cardString += "(" + this.getScore() + ")";
	    return cardString;
    }
}