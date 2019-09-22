
// Dealer has some of the same methods/fields as Player
public class Dealer extends Player {

    // static variables
    // nonstatic variables
    // constructors
    public Dealer(String name){
        super(name, Integer.MAX_VALUE);
        
    }
    // mutators
    // accessors
    // prints/compares/etc
    //
    @Override
    public void hit() {

    }

    @Override
    public int countHand() {
        return 0;
    }
    // static methods
}
