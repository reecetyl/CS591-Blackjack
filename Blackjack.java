import java.util.*;
public class Blackjack {
    
    Deck deck;
    HumanPlayer player;
    Dealer dealer;
    
    Blackjack() {
        deck = new Deck();
        dealer = new Dealer("Dealer", deck);    
    }
    
    public void welcome() {
        System.out.println("Welcome to Tyler, Sean, and Gary's CS591 Blackjack game!");
    }
    
    public void initPlayer() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter your player's name: ");
        String playerName = userInput.nextLine();
        System.out.println("Please enter your amount of starting money: ");
        Integer startingMoney = userInput.nextInt();
        player = new HumanPlayer(playerName, startingMoney);
    }
    
    public void turn() {
        System.out.println("Starting turn...");
        this.initDeal();
        this.showHandsHidden();
        while(!isBust(player)) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("What would you like to do? (h = hit, s = stand, sp = split, d = double up)");
            String choice = userInput.nextLine();
            if(choice.equalsIgnoreCase("h")) {
                hit(player);
            }
            else if(choice.equalsIgnoreCase("s")) {
                break;
            }
            else if(choice.equalsIgnoreCase("sp")) {
                // split logic
                break;
            }
            else { // double up
                break;
            }
            this.showHandsHidden();
        }
        while(dealer.getHand().score <= 17) {
            hit(dealer);
            this.showHands();
        }
        // determine winner
        System.out.println("game over");
        showHands();
        if(isBust(player)) System.out.println("Dealer wins!");
        if(isBust(dealer)) System.out.println("Player wins!");
        else {
            if(player.getHand().getScore() > dealer.getHand().getScore()) System.out.println("Player wins!");
            else System.out.println("Dealer wins!");
        } // if dealer & player bust what happens?
        
        // pay out money 
    }
    
    public void initDeal() {
        player.getHand().add(deck.dealCard());
        player.getHand().add(deck.dealCard());
        dealer.getHand().add(deck.dealCard());
        dealer.getHand().add(deck.dealCard());
    }
    
    public void showHandsHidden() {
        System.out.println(dealer + "'s hand: ");
        System.out.println("XX " + dealer.getHand().getFirstCard());
        System.out.println(player + "'s hand:");
        System.out.println(player.getHand());
    }
    
    public void showHands() {
        System.out.println(dealer + "'s hand: ");
        System.out.println(dealer.getHand());
        System.out.println(player + "'s hand:");
        System.out.println(player.getHand());
    }
    
    public boolean isBust(Player p) {
        if(p.getHand().getScore() > 21) return true;
        else return false;
    }
    
    public void hit(Player p) {
        p.getHand().add(deck.dealCard());
    }
    
}
