import java.lang.reflect.Array;
import java.util.*;
public class Hand implements Splittable {
    private List<Card> cards = new ArrayList<>();
    private Integer bet = 0;
    private Integer score = 0;
    private boolean hasAce;
    private boolean softScore = false;

    Hand() {
        setHasAce(false);
        setScore(0);
    }
    
    Hand(Card c, Integer bet){
        //cards.clear();
    	this();
    	this.cards.add(c);
    	setBet(bet);
    	if(c.getValue().equals("A")) {
    	    setHasAce(true);
    	    setScore(c.getScore() +10);
            setHasAce(true);
            setSoftScore(true);
        }else {
            setHasAce(false);
            setScore(c.getScore());
            setHasAce(false);
        }

    }
    
    public void add(Card card) {
        cards.add(card);
        /*
        if(card.getValue().equals("A")) {
            int tmpScore=this.getScore()<=10?11:1;
            score += tmpScore;
        }else

         */
        score += card.getScore();
        if(card.getValue().equals("A")) {
            setHasAce(true);
            setSoftScore(true);
        }


    }

    private void setHasAce(boolean hasAce) {
        this.hasAce = hasAce;
    }

    /*public boolean getHasAce(){
        return hasAce;
    }
*/
    public void add(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public void clear() {
        cards.clear();
        setScore(0);
    }
    
    public void setBet(Integer b) {
    	this.bet=b;
    }
    
    public Integer getBet() {
    	return bet;
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
        if(this.score < 12) {
            setSoftScore(hasAce);
            return hasAce? (this.score + 10) : this.score;
        }
        setSoftScore(false);
        return this.score;
    }

    private void setScore(Integer score) {
        this.score = score;
    }

    public void setSoftScore(boolean softScore) {
        this.softScore = softScore;
    }
    public boolean getSoftScore() { return this.softScore;}
    public String toString() {
        StringBuilder cardString = new StringBuilder();
        for(Card c: cards) {
            cardString.append(c.toString()).append(" ");
        }
        if(softScore) {
            cardString.append("(soft ").append(this.getScore()).append(")");
        } else {
            cardString.append("(").append(this.getScore()).append(")");
        }
        return cardString.toString();
    }
    
    public void removeCard() {
    	this.getCards().remove(0);
    }
    
    @Override
    public boolean canSplit() {
        return this.getCards().size() == 2 && getFirstCard().isSameValue(getSecondCard());
    }
    
    public boolean isBust() {
        return this.getScore() > 21;
    }

    public boolean isBlackJack() {
        return getScore() == 21;
    }

    public boolean isNaturalBlackJack() {
        if(this.cards.size() == 2) {
            return isBlackJack();
        }
        return false;
    }

    public ArrayList<Hand> split() {
        ArrayList<Hand> hands = new ArrayList<Hand>();
        Card tmp1 = getFirstCard();
        Card tmp2 = getSecondCard();
        hands.add(new Hand(tmp1, getBet()));
        hands.add(new Hand(tmp2, getBet()));
        return hands;
    }




}