public class Dealer extends Player {

    private Deck deck;
    private Hand hand;
    
    public Dealer(String name, Deck deck){
        super(name, Integer.MAX_VALUE);
        this.deck = deck;
        this.hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }
    
    public boolean outOfMoney() {
        return false;
    }
    
    public boolean isBust() {
        if (this.getHand().getScore() > 21) return true;
        else return false;
    }



}