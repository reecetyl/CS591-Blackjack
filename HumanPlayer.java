import java.util.Scanner;

// HumanPlayer is a type of player
public class HumanPlayer extends Player {

    // static variables
    // nonstatic variables
    Scanner scan = new Scanner(System.in);
    //private int balance;
    private int bankroll;
    // constructors
    public HumanPlayer(String name, int bankroll){
        super(name, 0);
        setBankroll(bankroll);
    }

    // mutators

    public void setBankroll(int bankroll) {
        this.bankroll = bankroll;
    }

    // accessors

    public int getBankroll() {
        return bankroll;
    }

    // prints/compares/etc

    public void bet(int amount) {
        setBalance(getBalance()-amount);
    }



    @Override
    public boolean action() {
        //printHand() method to be implemented
        myHand.printHand();
        //check for blackjack
        if(myHand.countHand() != 21) {
            System.out.println("Hit(H) or Stay(S)");
            //scan.nextLine();
            return true;
        } else {
            System.out.println("You got a BlackJack! Congrats");
            return false;
        }

    }

    @Override
    public void hit() {

    }

    public void doubleDown(){

    }

    public void Split(){

    }

    public void Stay(){

    }

    /**
     *
     * @param tip
     * toking is to tip the dealer
     * will add toking request when player wins too much. 10x minimum for a hand maybe
     */
    public void toking(int tip) {
        setBalance(getBalance()-tip);
    }


    /**
     *
     * @param cash
     * this method is to exchange cash to chips.
     * it is adding money to your balance on the table
     */
    public void cashToChip(int cash) {
        if(cash > 0 && cash < bankroll){
            setBalance(getBalance() + cash);
        } else {
            throw new IllegalArgumentException("Exchange Request Denied. Please check your bankroll or enter the valid amount");
        }
    }

    /**
     * cashout is to get all chips exchanged into cash and add to the players bankroll
     */
    public void cashout(){

    }


    // static methods
}

