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

    public boolean outOfMoney() {
        return this.getBalance() <= 0;
    }

    // prints/compares/etc
    public String toString() {
        return name;
    }

    public void growBalance(int balance) {
        this.setBalance(this.getBalance()+balance);
        System.out.println("Bank notification: Your current balance is "+this.getBalance()+".\n");
    }

    public boolean canAfford(int bet) {
        return (this.getBalance()>=bet && bet>0) ? true : false;
    }

}