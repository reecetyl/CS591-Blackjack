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
        //balance cannot be below 0
        if(!(balance < 0)){
            this.balance = balance;
        }
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