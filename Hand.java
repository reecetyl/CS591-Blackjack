import java.util.*;
public class Hand implements Splittable {
    List<Card> cards = new ArrayList<>();
    Integer score = 0;
    
    Hand() {
        cards.clear();
    }

    public void add(Card card) {
        cards.add(card);
        if(card.getValue().equals("A")) {
            int tmpScore=this.getScore()<=10?11:1;
            score += tmpScore;
        }else
            score += card.getScore();
    }

    public void add(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public void clear() {
        cards.clear();
        score = 0;
    }

    public List<Card> getCards() {
        return cards;
    }
    
    public Card getFirstCard() {
        return cards.get(0);
    }

    public Card getSecondCard() {
        return cards.get(1);
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

    @Override
    public boolean canSplit() {
        if(this.getCards().size() == 2 && getFirstCard().isSameValue(getSecondCard())) {
            return true;
        }
        return false;
    }

    public boolean isNaturalBlackJack() {
        if(this.cards.size() == 2 && getScore().intValue() == 21) {
            return true;
        }
        return false;
    }
}