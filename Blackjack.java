import java.util.*;
public class Blackjack {
    Scanner userInput;
    Deck deck;
    HumanPlayer player;
    Dealer dealer;
    
    Blackjack() {
        deck = new Deck();
        dealer = new Dealer("Dealer", deck);
        userInput = new Scanner(System.in);
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Player getPlayer() {
        return player;
    }



    public void welcome() {
        System.out.println("————————————————————————————————————————————————————————");
        System.out.println("Welcome to Tyler, Sean, and Gary's CS591 Blackjack game!");
        System.out.println("————————————————————————————————————————————————————————\n");
    }

    public void handleOutOfMoney() {
        System.out.println("Thank you for playing and losing all your money! See you next time!");
    }

    public void initPlayer() {
        System.out.println("Please enter player's name: ");
        String playerName = userInput.nextLine();
        System.out.println("Please enter the amount of your starting money: ");
        Integer startingMoney = userInput.nextInt();
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //checking for invalid input. say starting money = 0 or negative
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        player = new HumanPlayer(playerName, startingMoney);
    }


    public void gameRound() {
        System.out.println("\n------Starting new turn------");
        deck.shuffle();
        initDeal();
        putDownBet();
        showHandsHidden();
        boolean ended = playerTurn(player.getHands().get(0),false);
        if(ended == false) {
            dealerTurn(dealer.getHand());
        }

        // determine winner
        System.out.println("****** You have finished this round! ******");
        for(int i=0;i<player.getHands().size();i++) {
        	System.out.println("For player's hand "+(i+1)+ " :");
        	this.showHands();
        	gameResult(player.getHands().get(i), dealer.getHand());
        }
        clearHands();
        player.playNewHand();
        // pay out money
    }

    public void putDownBet() {
    	System.out.println("Please put down your bet: ");
    	int bets;
        do {
            bets = userInput.nextInt();
            if(player.checkBalance(bets))
            	break;
            System.out.println("Please bet more than 0 dollars and less than your balance "+player.getBalance());
        }while(true);
        player.getHands().get(0).setBet(bets);
        player.growBalance((-1)*player.getHands().get(0).getBet());
        userInput.nextLine();
    }

    public boolean playerTurn(Hand h, boolean isSplitted) {
        while(!h.isBust() && !h.isNaturalBlackJack()) {
            //check for split-able
            if(h.canSplit()&&player.checkBalance(h.getBet())&&!isSplitted) { //only allow to split when have two identical cards            	isSplitted =true;							    // and enough money, and only allow to split once
            	Card aCard = h.getFirstCard();					// and enough money, and only allow to split once
                System.out.println("You got a pair of " +
                        aCard.getValue() + "'s! It costs "+h.getBet()+"$ for splitting. Do you want to split"
                        		+ " them? (y/n)");
                String move = userInput.nextLine();
                if(move.equalsIgnoreCase("y") || move.equalsIgnoreCase("s")) {
                    //split here
                	player.growBalance((-1)*h.getBet());//put down bet for splitting
                    //player.getHands().get(0).add(aCard);
                	player.splitHand(h.getBet());
                    System.out.println("Splitting... ");
                    for(Hand sh : player.getHands()) {
                    	 sh.add(deck.dealCard());
                    }
                    showHandsHidden();
                    for(Hand hand: player.getHands()) {
                    	playerTurn(hand,true);
                    }
                    break;
                }
            }
            //double up is available only in the first round and not splitted
            if(h.getCards().size() == 2&&player.checkBalance(h.getBet())&&!isSplitted) {
                System.out.println("Do you want to double down? (y/n)");
                String move = userInput.nextLine();
                if(move.equalsIgnoreCase("y") || move.equalsIgnoreCase("d")) {
                    hit(h);
                    player.growBalance((-1) * h.getBet());
                    h.setBet(h.getBet()*2);
                    break;
                }
            }
            System.out.println("What would you like to do with hand "+(player.getHands().indexOf(h)+1)+"? (h = hit, s = stand)");
            String move = userInput.nextLine();
            if(move.equalsIgnoreCase("h")) {
                hit(h);
            }
            else if(move.equalsIgnoreCase("s")) {
            	System.out.println(player+" has decided to stand. Hand "+(player.getHands().indexOf(h)+1)+" is done.");
                break;
            }
            this.showHandsHidden();
        }

        if(h.isNaturalBlackJack() || h.isBust()) {
            return true;
        }
        this.showHands();
        return false;

    }

    public void dealerTurn(Hand h) {
        while(h.getScore() < 17) {
            System.out.println("Dealer got " + h.getScore() + ". Dealer Must hit");
            hit(h);
            this.showHands();
        }
        if(h.isBust()) System.out.println("Dealer got " + h.getScore() + ". Dealer bust!");
        else
            System.out.println("Dealer got " + h.getScore() + ". Dealer stands");
    }
    
    public void gameResult(Hand ph, Hand dh) {
        //player bust
        if(ph.isBust()) System.out.println("Dealer wins!");
        //player natural BlackJack
        else if(ph.isNaturalBlackJack()) {
            System.out.println("Black Jack! Player wins! BlackJack is paid 2:1");
            player.growBalance(ph.getBet()*3);
            //specify in doc that natural BJ is paid 2:1
        }
        //player not bust
        //dealer bust
        else if(dh.isBust()) {
            System.out.println("Dealer Busted! Player wins!");
            player.growBalance(ph.getBet()*2);
        }
        //dealer blackjack insurance not implemented here
        //no body bust
        else {
            //dealer is natural blackjack or dealer's hand is larger
            if(ph.getScore() < dh.getScore() || dh.isNaturalBlackJack()) {
                System.out.println("Dealer wins!");
                player.growBalance(0);
            }
            //tie
            else if(ph.getScore() == dh.getScore()) {
                System.out.println("It's a tie!");
                player.growBalance(ph.getBet());
            }
            //player's hand is larger
            else {
                System.out.println("Congrats, Player wins!");
                player.growBalance(ph.getBet()*2);
            }
        }
    }
    
    public void initDeal() {

        //deal cards in alternating sequence
        player.getHands().get(0).add(deck.dealCard());

        dealer.getHand().add(deck.dealCard());

        player.getHands().get(0).add(deck.dealCard());

        dealer.getHand().add(deck.dealCard());
    }
    
    public void showHandsHidden() {
        System.out.println(dealer + "'s hand: "+ dealer.getHand().getFirstCard()+" XX" );
        for(int i=0;i<player.getHands().size();i++)
        	System.out.println(player + "'s hand "+(i+1)+": "+player.getHands().get(i).toString());
        System.out.println();
    }
    
    public void showHands() {
        System.out.println(dealer.toString() + "'s hand: "+dealer.getHand());
        for(int i=0;i<player.getHands().size();i++)
        	System.out.println(player + "'s hand "+(i+1)+": "+player.getHands().get(i).toString());
        System.out.println();
    }


    public void clearHands() {
        player.getHands().clear();
        dealer.getHand().clear();
    }

    public void hit(Hand ph) {
        ph.add(deck.dealCard());
    }


}
