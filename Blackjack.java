import java.util.*;
public class Blackjack {
	Scanner userInput;
    Deck deck;
    HumanPlayer player;
    Dealer dealer;
    int bets;
    
    Blackjack() {
        dealer = new Dealer("Dealer", deck);  
        userInput = new Scanner(System.in);  
        deck = new Deck();
    }
    
    public void welcome() {
    	System.out.println("————————————————————————————————————————————————————————");
        System.out.println("Welcome to Tyler, Sean, and Gary's CS591 Blackjack game!");
        System.out.println("————————————————————————————————————————————————————————\n");
    }
    
    public void initPlayer() {
        System.out.println("Please enter player's name: ");
        String playerName = userInput.nextLine();
        System.out.println("Please enter the amount of your starting money: ");
        Integer startingMoney = userInput.nextInt();
        player = new HumanPlayer(playerName, startingMoney);
    }
    
    public void turn() {
        System.out.println("------Starting new turn------");
        deck.shuffle();
        System.out.println("Please enter your bets: ");
        do {
        	bets = userInput.nextInt();
            boolean flag=checkBets(bets);
            if(flag) break;
            System.out.println("You don't have that much money. You have "+player.getBalance());
        }while(true);

        userInput.nextLine();
        player.growBalance((-1)*bets);
        initDeal();
        showHandsHidden();
        playerTurn();
        dealerTurn();
        // determine winner
        gameResult();
        clearHand();
        // pay out money 
    }
    
    public void playerTurn() {
    	while(!isBust(player)) {




    	    //check for split-able

            if(player.getHands().get(0).canSplit()) {
                Card aCard = player.getHands().get(0).getFirstCard();
                System.out.println("you got a pair of " +
                        aCard.toString() + " ! Do you want to split them?");
                String input = userInput.nextLine();
                if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("s")) {
                    //split here
                    //player.getHands().get(0).add(aCard);
                    System.out.println("splitting... lol not implemented yet");
                }
            }


            //



            System.out.println("What would you like to do? (h = hit, s = stand, d = double up)");
            String choice = userInput.nextLine();
            if(choice.equalsIgnoreCase("h")) {
                hit(player);
            }
            else if(choice.equalsIgnoreCase("s")) {
                break;
            }

            /*
            else if(choice.equalsIgnoreCase("sp")) {
                // split logic
                break;
            }

             */
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
    }
    	
    public void dealerTurn() {
    	while(dealer.getHand().score < 17 && !isBust(player)) {
            hit(dealer);
            this.showHands();
        }
    }
    
    public void gameResult() {
    	System.out.println("game over");
        showHands();

        //player bust
        if(isBust(player)) System.out.println("Dealer wins!");
        //player natural BlackJack
        else if(player.getHands().get(0).isNaturalBlackJack()) {
            System.out.println("Black Jack! Player wins! BlackJack is payed 2:1");
            player.growBalance(bets*3);
            //specify in doc that natural BJ is payed 2:1
        }
        //player not bust
        //dealer bust
        else if(isBust(dealer)) {
        	System.out.println("Dealer Busted! Player wins!");
        	player.growBalance(bets*2);
        }
        //dealer blackjack insurance not implemented here
        //no body bust
        else {
            //dealer is natural blackjack or dealer's hand is larger
            if(player.getHands().get(0).getScore() < dealer.getHand().getScore() || dealer.getHand().isNaturalBlackJack()) {
            	System.out.println("Dealer wins!");

            }
            //tie
            else if(player.getHands().get(0).getScore() == dealer.getHand().getScore()) {
                System.out.println("It's a tie!");
                player.growBalance(bets);
            }
            //player's hand is larger
            else {
                System.out.println("Congrats, Player wins!");
                player.growBalance(bets*2);
            }
        }
        System.out.println("Player balance "+ player.getBalance());
    }
    
    public void initDeal() {
        player.getHands().get(0).add(deck.dealCard());
        player.getHands().get(0).add(deck.dealCard());
        dealer.getHand().add(deck.dealCard());
        dealer.getHand().add(deck.dealCard());
    }
    
    public void showHandsHidden() {
        System.out.println(dealer + "'s hand: ");
        System.out.println("XX " + dealer.getHand().getFirstCard());
        System.out.println(player + "'s hand:");
        System.out.println(player.getHands().get(0).toString() + "\n");
    }
    
    public void showHands() {
        System.out.println(dealer + "'s hand: ");
        System.out.println(dealer.getHand());
        System.out.println(player + "'s hand:");
        System.out.println(player.getHands().get(0)+"\n");
    }
    
    public boolean checkBets(int b) {
    	return player.getBalance()>=b?true:false;
    }
  
    public boolean isBust(HumanPlayer p) {
        if (p.getHands().get(0).getScore() > 21) return true;
        else return false;
    }

    public boolean isBust(Dealer d) {
        if (d.getHand().getScore() > 21) return true;
        else return false;
    }

    public void clearHand() {
    	bets = 0;
    	player.getHands().get(0).clear();
    	dealer.getHand().clear();
    }

    public void hit(HumanPlayer p) {
        p.getHands().get(0).add(deck.dealCard());
    }

    public void hit(Dealer d) {
        d.getHand().add(deck.dealCard());
    }
}
