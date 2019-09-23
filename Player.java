abstract class Player {
    // static variables
    // nonstatic variables
    private String name;
    private int balance;
    protected Hand myHand;
    // constructors
    public Player(String name, int balance){
        setName(name);
        setBalance(balance);
    }
    //no-arg constructor
    public Player(){
        setName("John Doe");
        setBalance(0);
        myHand = new Hand();
    }

    // mutators

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        //balance cannot be below 0
        if(!(balance < 0)){
            this.balance = balance;
        }
    }

    // accessors
    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }
    // prints/compares/etc
    public String toString() {
        return name;
    }

    public abstract void hit();
    // static methods


    public abstract boolean action();

}

