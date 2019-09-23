
// Dealer has some of the same methods/fields as Player
public class Dealer extends Player {

    // static variables
    // nonstatic variables
    private int tips;

    // constructors
    public Dealer(String name){
        super(name, Integer.MAX_VALUE);
        setTips(0);
    }
    // mutators

    public void setTips(int tips) {
        this.tips = tips;
    }

    // accessors

    public int getTips() {
        return tips;
    }

    // prints/compares/etc
    //
    @Override
    public void hit() {

    }



    @Override
    public boolean action() {

        return false;
    }

    public void greetings() {
        System.out.println("Nice to meet you today!");
    }

    public void dealCards() {

    }

    public void shuffleDeck() {

    }

    public void declareWinner() {

    }

    // static methods
}
