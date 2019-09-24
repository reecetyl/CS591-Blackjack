abstract class Player {
    // static variables
    // nonstatic variables
    private String name;
    private int balance;
    protected Hand hand;
    // constructors
    
    public Player(String name, int balance){
        this.name = name;
        setBalance(balance);
        this.hand = new Hand();
    }   

    public void setBalance(int balance) {
        //balance cannot be below 0
        if(!(balance < 0)){
            this.balance = balance;
        }
    }

    public int getBalance() {
        return balance;
    }
    
    public Hand getHand() {
        return hand;
    }
    
    // prints/compares/etc
    public String toString() {
        return name;
    }

}