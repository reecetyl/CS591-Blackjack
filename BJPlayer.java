import java.util.ArrayList;


public class BJPlayer extends Player {
    private ArrayList<BJHand> hands;  //in blackjack, player can have multiple hands
    
    public BJPlayer(String name, int balance){
        super(name,balance);
        hands = new ArrayList<BJHand>();
        this.addNewHand();
    }
    
    public void addNewHand() {
    	this.hands.add(new BJHand());
    }
    
    public void addNewHand(Card c, Integer b) {
    	this.hands.add(new BJHand(c,b));
    }
    
    public ArrayList<BJHand> getHands() {
        return hands;
    }

    public void setHands(ArrayList<BJHand> hands) {
        this.hands.clear();
        this.hands.addAll(hands);
    }
    
    public void clearHands() {
    	for(BJHand h : hands)
    		h.clear();
    	hands.clear();
    }

}