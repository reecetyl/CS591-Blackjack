public class BlackjackHand extends Hand implements Splittable {	
    private Integer bet = 0;
    private boolean hasAce = false;
    private Integer BJScore = 0;
    private boolean softScore = false;

    BlackjackHand() {
    	super();
    }
    
    BlackjackHand(Card c, Integer bet){
    	this();
    	setBet(bet);
    	this.add(c);
    }
    
    public void add(Card card) {
    	super.add(card);
    	if(card.getValue().name().equals(Card.Value.C_A.name())) { //decide what's the point for A
    	    setHasAce(true);
    	    if(getBJScore() < 12) {
    	    	setBJScore(BJScore + card.getScore() + 10);
    	    	setSoftScore(true);
    	    }else {
    	    	setBJScore(BJScore + card.getScore());
    	    }
        }else {
        	setBJScore(BJScore + card.getScore());
        }
    }

    private void setHasAce(boolean hasAce) {
        this.hasAce = hasAce;
    }
    
    public void setBet(Integer b) {
    	this.bet=b;
    }
    
    public Integer getBet() {
    	return bet;
    }

    
    public Card getFirstCard() {
    	if (getNumCards()<1)
            throw new RuntimeException("No enough cards in hand.");
        return getCards().get(0);
    }

    public Card getSecondCard() {
    	if (getNumCards()<2)
            throw new RuntimeException("No enough cards in hand.");
        return getCards().get(1);
    }

    public Integer getBJScore() {
        return this.BJScore;
    }

    private void setBJScore(Integer score) {
        this.BJScore = score;
    }

    public void setSoftScore(boolean softScore) {
        this.softScore = softScore;
    }
    
    public boolean getSoftScore() { return this.softScore;}
    
    public String toString() {
        StringBuilder cardString = new StringBuilder();
        for(Card c: getCards()) {
            cardString.append(c.toString()).append(" ");
        }
        if(getSoftScore()) {
            cardString.append("(soft ").append(this.getBJScore()).append(")");
        } else {
            cardString.append("(").append(this.getBJScore()).append(")");
        }
        return cardString.toString();
    }

    public boolean canSplit() {
        return getNumCards() == 2 && getFirstCard().isSameValue(getSecondCard());
    }
    
    public boolean isBust() {
        return this.getBJScore() > 21;
    }

    public boolean isBlackJack() {
        return getBJScore() == 21;
    }

    public boolean isNaturalBlackJack() {
        if(getCards().size() == 2) {
            return isBlackJack();
        }
        return false;
    }
    
    public void clear() {
        super.clear();
        setBJScore(0);
        setBet(0);
        setHasAce(false);
        setSoftScore(false);
    }
}