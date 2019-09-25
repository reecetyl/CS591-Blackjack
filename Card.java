// class to represent a Card
public class Card {
    String value; // A, 2-10, J, Q, K
    Integer score; // Number it counts for in Blackjack
    String suit; // H, S, C, D for Hearts, Spades, Clubs, and Diamonds
    
    Card(String value, String suit) {	
        this.value = value;
        this.suit = suit;
	try {
		Integer score = Integer.parseInt(value);
		this.score = score;
	} catch (NumberFormatException | NullPointerException nfe) {
		if(value.equals("A")) this.score = 1;
		else {
			this.score = 10;			
		}
	} 
	this.score = score;
    }
    
    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }
	
    public Integer getScore() {
	    return score;
    }

    public boolean isSameValue(Card other) {
	return this.score == other.score;
    }

    public String toString() {
        return value + suit; // KH for King of Hearts, 9D for 9 of Diamonds
    }
}