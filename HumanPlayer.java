import java.util.ArrayList;

public class HumanPlayer extends Player {
    private ArrayList<Hand> hands = new ArrayList<Hand>(4); //at most 4 hands after split

    public HumanPlayer(String name, int bankroll){
        super(name, bankroll);
        this.hands.add(new Hand());
    }

    public ArrayList<Hand> getHands() {
        return hands;
    }

    public void growBalance(int balance) {
    	this.setBalance(this.getBalance()+balance);
    	
    }

}