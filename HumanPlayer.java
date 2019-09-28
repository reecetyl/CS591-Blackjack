import java.util.ArrayList;


public class HumanPlayer extends Player {
    private ArrayList<BlackjackHand> hands = new ArrayList<BlackjackHand>(); //in blackjack, player can have multiple hands
    
    public HumanPlayer(String name, int balance){
        super(name,balance);
        this.addNewHand();
    }
    
    public void addNewHand() {
    	this.hands.add(new BlackjackHand());
    }
    
    public void addNewHand(Card c, Integer b) {
    	this.hands.add(new BlackjackHand(c,b));
    }
    
    public ArrayList<BlackjackHand> getHands() {
        return hands;
    }

    public void setHands(ArrayList<BlackjackHand> hands) {
        this.hands.clear();
        this.hands.addAll(hands);
    }
    
    public void clearHands() {
    	for(BlackjackHand h : hands)
    		h.clear();
    	hands.clear();
    }

    public void growBalance(int balance) {
        this.setBalance(this.getBalance()+balance);
        System.out.println("Bank notification: Your current balance is "+this.getBalance()+".\n");
    }
    
    public boolean canPay(int b) { 
    	 return (this.getBalance()>=b && b>0) ? true : false;
    }
    
    public boolean outOfMoney() {
        return this.getBalance() <= 0;
    }

}