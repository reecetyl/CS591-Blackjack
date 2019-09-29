public class BJDealer extends BJPlayer implements Dealable {

    private static final int Dealer_Balance = Integer.MAX_VALUE;
    private BJHand oneHand;
    private Deck deck;

    
    public BJDealer(String name){
        super(name, Dealer_Balance);
        deck = new Deck();
        setOneHand(getHands().get(0));
    }

    public BJHand getOneHand() {
        return oneHand;
    }

    public void setOneHand(BJHand hand) {
        this.oneHand = hand;
    }

    public void clearHand() {
    	oneHand.clear();
    }

    public Deck getDeck() {
        return this.deck;
    }

    @Override
    public Card dealCard() {
        return getDeck().dealCard();
    }

    @Override
    public void shuffleDeck() {
        getDeck().shuffle();
    }
}