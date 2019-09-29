public class Dealer extends Player implements Dealable{

    private static final int Dealer_Balance = Integer.MAX_VALUE;
    private Deck deck;
    public Dealer(String name, int money) {
        super(name, Dealer_Balance);
    }

    public Deck getDeck() {
        return deck;
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
