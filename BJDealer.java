import java.util.ArrayList;

public class BJDealer extends BJPlayer implements Dealable {

    private static final int Dealer_Balance = Integer.MAX_VALUE;
    private BJHand oneHand;
    private Deck deck;

    
    public BJDealer(String name){
        super(name, Dealer_Balance);
        deck = new Deck();
        deck.shuffle();
        setOneHand(getHands().get(0));
    }

    public void clearOneHand() {
        this.getOneHand().clear();

    }
    public BJHand getOneHand() {
        return oneHand;
    }

    public void setOneHand(BJHand hand) {
        this.oneHand = hand;
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
        deck = new Deck();
        deck.shuffle();
    }

    @Override
    public void showHands(){
        System.out.println("Dealer " + this.toString() + "'s hand: "+ oneHand.toString());
        System.out.println();
    }

    public void showHandsHidden(){
        System.out.println("Dealer " + this.toString() + "'s hand: "+ oneHand.getFirstCard().toString() + " Hidden Card");
        System.out.println();
    }

    public ArrayList<BJHand> split(BJHand h) {
        Card card1 = h.getFirstCard();
        Card card2 = h.getSecondCard();
        int oldBet=h.getBet();
        BJHand hand1 = new BJHand(oldBet);
        hand1.add(card1);
        hand1.add(this.dealCard());
        BJHand hand2 = new BJHand(oldBet);
        hand2.add(card2);
        hand2.add(this.dealCard());
        ArrayList<BJHand> handsSplitted = new ArrayList<BJHand>();
        handsSplitted.add(hand1);
        handsSplitted.add(hand2);
        return handsSplitted;
    }
}