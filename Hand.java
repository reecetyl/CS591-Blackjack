import java.util.*;
public class Hand {
    private List<Card> cards;
    private Integer score = 0;

    Hand() {
    	cards = new ArrayList<>();
    }
    
    Hand(Card c) {
    	this();
    	add(c);
    }
    
    public void add(Card card) {
        cards.add(card);
        setScore(card.getScore()+score);
    }

    public void add(List<Card> cards) {
        this.cards.addAll(cards);
        for(Card c: cards) {
        	setScore(c.getScore()+score);
        }
    }

    public void clear() {
        cards.clear();
        setScore(0);
    }

    public List<Card> getCards() {
        return cards;
    }
    
    public Integer getNumCards() {
        return cards.size();
    }

    public Integer getScore() {
        return this.score;
    }

    private void setScore(Integer score) {
        this.score = score;
    }

    public String toString() {
        StringBuilder cardString = new StringBuilder();
        for(Card c: cards) {
            cardString.append(c.toString()).append(" ");
        }
        return cardString.toString();
    }
    
    public void removeCard() {
    	if (getNumCards()==0)
            throw new RuntimeException("Hand is empty.");
    	this.getCards().remove(getNumCards()-1);
    }

}