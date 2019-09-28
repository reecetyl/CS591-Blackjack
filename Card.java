// class to represent a Card
public class Card {
	public enum Suit {H, S, C ,D}; // H, S, C, D for Hearts, Spades, Clubs, and Diamonds
	public enum Value {C_A, C_2, C_3, C_4, C_5, C_6, C_7, C_8, C_9, C_10, C_J, C_Q, C_K}
    Value value; // A, 2-10, J, Q, K
    Integer score; // Inner points for the card
    Suit suit; 
    
    Card(Value value, Suit suit) {   
        this.value = value;
        this.suit = suit;
        this.score = value.ordinal()+1;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    public boolean isSameValue(Card b) {
    	return this.value.name().equals(b.value.name());
    }
    
    public Value getValue() {
        return value;
    }
    
    public Integer getScore() {
        return score;
    }

    public String toString() {
        return suit.name() + value.name().replace("C_", "") ; // KH for King of Hearts, 9D for 9 of Diamonds
    }
}