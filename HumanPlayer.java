public class HumanPlayer extends Player {

    public HumanPlayer(String name, int bankroll){
        super(name, bankroll);
    }
    
    public void growBalance(int balance) {
    	this.setBalance(this.getBalance()+balance);
    	
    }

}