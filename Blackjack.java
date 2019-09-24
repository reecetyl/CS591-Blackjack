import java.util.*;
public class Blackjack {
    
    Deck deck;
    HumanPlayer player;
    Dealer dealer;
    
    Blackjack() {
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
        deck = new Deck();
        System.out.println("Starting turn...");
        System.out.println("Please enter your bets: ");
        int bets;
        do {
        	Scanner usrinp = new Scanner(System.in);
        	bets = usrinp.nextInt();
            boolean flag=checkBets(bets);
            if(flag) break;
            System.out.println("You dont have that much money. You have "+player.getBalance());
        }while(true);
        player.growBalance((-1)*bets);
        Scanner userInput = new Scanner(System.in);
        this.initDeal();
        this.showHandsHidden();
        while(!isBust(player)) {
            Scanner usrinp = new Scanner(System.in);
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
            	if(checkBets(bets)) {
            		hit(player);
                	player.growBalance((-1)*bets);
                	bets*=2;
                    break;
            	}else {
            		System.out.println("You dont have that much money to do double down");
            		continue;
            	}
            	
            }
            this.showHandsHidden();
        }
        while(dealer.getHand().score < 17 && !isBust(player)) {
            hit(dealer);
            this.showHands();
        }
        // determine winner
        System.out.println("game over");
        showHands();
        if(isBust(player)) System.out.println("Dealer wins!");
        else if(isBust(dealer)) {
        	System.out.println("Player wins!");
        	player.growBalance(bets*2);
        }
        else {
            if(player.getHand().getScore() > dealer.getHand().getScore()) {
            	System.out.println("Player wins!");
            	player.growBalance(bets*2);
            }
            else System.out.println("Dealer wins!");
        } // if dealer & player bust what happens?
        System.out.println("Player balance "+ player.getBalance());
        clearHand();
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
    
    public boolean checkBets(int b) {
    	return player.getBalance()>=b?true:false;
    }
  
    public boolean isBust(Player p) {
        if (p.getHand().getScore() > 21) return true;
        else return false;
    }
    public void clearHand() {
    	player.getHand().clear();
    	dealer.getHand().clear();
    }
    public void hit(Player p) {
        p.getHand().add(deck.dealCard());
    }
    
}
