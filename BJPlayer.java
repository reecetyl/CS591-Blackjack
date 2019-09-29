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

    public void showHands(){
        for (BJHand bjHand : hands) {
            System.out.println("Your hand " + (hands.indexOf(bjHand)+1) + ": "+ bjHand.toString());
        }
        System.out.println();
    }

    public void showHand(int index) {
        for (BJHand bjHand : hands) {
            if (index == 0) {
                System.out.println("Your hand " + (hands.indexOf(bjHand) + 1) + ": " + bjHand.toString());
                break;
            }
            index--;
        }
        System.out.println();
    }

    public void putDownBet(int bets) {
        getHands().get(0).setBet(bets);
        growBalance((-1)* getHands().get(0).getBet());
    }

}