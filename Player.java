import java.util.ArrayList;

abstract class Player {
    // static variables
    // nonstatic variables
    private String name;
    private int balance;
    
    // constructors
    public Player(String name, int money){
        setName(name);
        setBalance(money);
    }   
    
    public int getBalance() {
        return balance;
    }
    
    public void setBalance(int balance) {
    	this.balance = balance;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public abstract boolean outOfMoney();

    // prints/compares/etc
    public String toString() {
        return name;
    }

}