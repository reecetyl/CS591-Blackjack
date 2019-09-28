public class Dealer extends Player {

    private Deck deck; 
    private BlackjackHand hand;
    public static final int Dealer_Balance=Integer.MAX_VALUE;
    
    public Dealer(String name, Deck deck){
        super(name,Dealer_Balance);
        this.deck = deck;
        this.hand = new BlackjackHand();
    }

    public BlackjackHand getHand() {
        return hand;
    }
    
    public boolean outOfMoney() {
        return false;
    }
    
    public void clearHand() {
    	hand.clear();
    }

}