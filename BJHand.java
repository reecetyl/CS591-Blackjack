public class BJHand extends Hand implements Splittable {
    private Integer bet = 0;
    private Integer bjScore = 0;
    private Integer bjHardScore = 0;
    //private boolean isSoftScore = false;
    //private boolean hasAce = false;
    BJHand() {
    	super();
    }

    BJHand(Integer bet) {
        this();
        setBet(bet);
    }

    BJHand(Card c, Integer bet){
    	this();
    	cards.add(c);
    	setBet(bet);
    }

    @Override
    public void add(Card card) {
    	cards.add(card);
    	if(card.getFaceValue().ordinal() > FaceValue.TEN.ordinal()){
        	setBjHardScore(bjHardScore + 10);
        } else {
        	setBjHardScore(bjHardScore + card.getScore());
        }
        setBjScore(bjHardScore);
    }

    public void clear() {
        super.clear();
        setBjScore(0);
        setBjHardScore(0);
        setBet(0);
        //setHasAce(false);
        //setSoftScore(false);
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
        return cards.get(0);
    }

    public Card getSecondCard() {
    	if (getNumCards()<2)
            throw new RuntimeException("No enough cards in hand.");
        return cards.get(1);
    }

    public Integer getBjScore() {
        return this.bjScore;
    }

    private void setBjScore(Integer score) {
        this.bjScore = score;
    }

    public Integer getBjHardScore() {
        return bjHardScore;
    }

    public void setBjHardScore(Integer bjHardScore) {
        this.bjHardScore = bjHardScore;
    }

    public String toString() {
        StringBuilder cardString = new StringBuilder();
        for(Card c: cards) {
            cardString.append(c.toString()).append(" ");
        }
        //Integer outputScore = calculateOutputScore();
        boolean isSoftScore = calculateOutputScore();
        if(isSoftScore) {
            cardString.append("(soft ").append(getBjScore()).append(" or ").append(getBjScore()-10).append(")");
        } else {
            cardString.append("(").append(getBjScore()).append(")");
        }
        return cardString.toString();
    }

    @Override
    public boolean canSplit() {
        return getNumCards() == 2 && getFirstCard().isSameValue(getSecondCard());
    }
    
    public boolean isBust() {
        return this.getBjScore() > 21;
    }

    public boolean isBlackJack() {
        return getBjScore() == 21;
    }

    public boolean isNaturalBlackJack() {
        if(cards.size() == 2) {
            return isBlackJack();
        }
        return false;
    }

    public boolean hasAce() {
        for(Card c : cards) {
            if (c.getFaceValue().equals(FaceValue.ACE))
                return true;
        }
        return false;
    }

    public boolean calculateOutputScore() {
        //return whether the score is soft or not

        if(getBjHardScore() < 12 && this.hasAce()) {
            setBjScore(this.bjHardScore + 10);
            return true;
        }
        setBjScore(this.bjHardScore);
        return false;

    }

}