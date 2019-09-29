// class to represent a Card
public class Card {
    private FaceValue faceValue;
    private Integer score; // Inner points for the card
    private Suit suit;
    
    Card(FaceValue faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;
        this.score = faceValue.ordinal()+1;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    public boolean isSameValue(Card b) {
    	return this.faceValue.equals(b.faceValue);
    }
    
    public FaceValue getFaceValue() {
        return faceValue;
    }
    
    public Integer getScore() {
        return score;
    }

    public String toString() {
        return faceValue.toString() + " of " + suit.toString() + "  "; // KH for King of Hearts, 9D for 9 of Diamonds
    }
}