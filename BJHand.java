public class BJHand extends Hand implements Splittable {
    private Integer bet = 0;
    private Integer bjScore = 0;
    //private boolean isSoftScore = false;
    //private boolean hasAce = false;
    BJHand() {
    	super();
    }
    
    BJHand(Card c, Integer bet){
    	this();
    	setBet(bet);
    	this.add(c);
    }

    @Override
    public void add(Card card) {
    	getCards().add(card);
        /*
    	if(card.getFaceValue().equals(FaceValue.ACE)) {
    	    setHasAce(true);
        }

        */

    	if(card.getFaceValue().ordinal() > FaceValue.TEN.ordinal()){
        	setBjScore(bjScore + 10);
        } else {
        	setBjScore(bjScore + card.getScore());
        }
    }

    public void clear() {
        super.clear();
        setBjScore(0);
        setBet(0);
        //setHasAce(false);
        //setSoftScore(false);
    }
    /*private void setHasAce(boolean hasAce) {
        this.hasAce = hasAce;
    }

     */



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

    public Integer getBjScore() {
        return this.bjScore;
    }

    private void setBjScore(Integer score) {
        this.bjScore = score;
    }

    /*
    public void setSoftScore(boolean softScore) {
        this.isSoftScore = softScore;
    }
    
    public boolean getSoftScore() { return this.isSoftScore;}


    */
    public String toString() {
        StringBuilder cardString = new StringBuilder();
        for(Card c: getCards()) {
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
        if(getCards().size() == 2) {
            return isBlackJack();
        }
        return false;
    }

    public boolean hasAce() {
        for(Card c : getCards()) {
            if (c.getFaceValue().equals(FaceValue.ACE))
                return true;
        }
        return false;
    }

    public boolean calculateOutputScore() {
        //return whether the score is soft or not

        if(getBjScore() < 12 && this.hasAce()) {
            setBjScore(this.bjScore + 10);
            return true;
        }
        setBjScore(this.bjScore);
        return false;

    }

}