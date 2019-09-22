// Blackjack.java

public class Blackjack {
    public static void main(String args[]) {
        // main code for blackjack game
    }

}


/* Player class moved to a new file
// abstract class for Player
abstract class Player {
    // static variables
    // nonstatic variables
    String name;
    // constructors
    // mutators
    // accessors
    // prints/compares/etc
    String toString() {
        return name;
    }
    // static methods
}

// HumanPlayer is a type of player
public class HumanPlayer extends Player {
    // static variables
    // nonstatic variables
    // constructors
    // mutators
    // accessors
    // prints/compares/etc
    // static methods
}

// Dealer has some of the same methods/fields as Player
public class Dealer extends Player {
    // static variables
    // nonstatic variables
    // constructors
    // mutators
    // accessors
    // prints/compares/etc
    // static methods
}
*/


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

// class to represent a Hand of Cards
public class Hand {
    // static variables
    // nonstatic variables
    Card[] cards;
    // constructors
    // mutators
    // accessors
    // prints/compares/etc
    @Override
    public String toString() {
        String cardString = "";
        for(Card c: cards) {
            cardString += c.toString() + " ";
        }
    }
    // static methods
}

// class to represent a Card
public class Card {
    // static variables
    // nonstatic variables
    String value; // A, 1-9, J, Q, K
    String suit; // H, S, C, D for Hearts, Spades, Clubs, and Diamonds
    // constructors
    Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }
    // mutators
    // accessors
    String getSuit() {
        return suit;
    }

    String getValue() {
        return value;
    }
    // prints/compares/etc
    @Override
    public String toString() {
        return value + suit; // KH for King of Hearts, 9D for 9 of Diamonds
    }
    // static methods
}