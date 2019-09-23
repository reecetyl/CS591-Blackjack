// class to represent a Deck
public class Deck {
    // static variables
    // nonstatic variables
    Card[] cards;
    // constructors
    // mutators
    void shuffle() {
        // code to shuffle cards
    }
    // accessors
    // prints/compares/etc
    String toString() {
        String deckString = "";
        for(Card c : cards) {
            deckString += c.toString() + " ";
        }
        return deckString;
    }
    // static methods
}
