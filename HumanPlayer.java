import java.util.ArrayList;


public class HumanPlayer extends Player {
    private ArrayList<Hand> hands = new ArrayList<Hand>(); //at most 4 hands after split
    private int balance;
    
    public HumanPlayer(String name, int balance){
        super(name,balance);
        this.hands.add(new Hand());
    }
    
    public void playNewHand() {
    	this.hands.add(new Hand());
    }
    
    public ArrayList<Hand> getHands() {
        return hands;
    }

    public void setHands(ArrayList<Hand> hands) {
        this.hands.clear();
        this.hands.addAll(hands);
    }

    /*
    public void splitHand(Integer bet) {
    	Card tmp1 = this.getHands().get(0).getFirstCard();
    	Card tmp2 = this.getHands().get(0).getSecondCard();
    	this.getHands().clear();
    	this.getHands().add(new Hand(tmp1, bet));
    	this.getHands().add(new Hand(tmp2, bet));
    }
    */

    public void growBalance(int balance) {
        this.setBalance(this.getBalance()+balance);
        System.out.println("Bank notification: Your current balance is "+this.getBalance()+".\n");
    }
    
    public boolean checkBalance(int b) {
    	 return (this.getBalance()>=b && b>0) ? true : false;
    }
    
    public boolean outOfMoney() {
        return this.getBalance() == 0;
    }

}