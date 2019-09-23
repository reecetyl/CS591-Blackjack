// class to represent a Hand of Cards
public class Hand {
    // static variables
    // nonstatic variables
    Card[] cards;
    // constructors
    // mutators
    // accessors
    // prints/compares/etc
    String toString() {
        String cardString = "";
        for(Card c: cards) {
            cardString += c.toString() + " ";
        }
    }
    // static methods
}
