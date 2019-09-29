import java.util.Scanner;

public class BlackJackTable {
    private Scanner scanner = new Scanner(System.in);
    private Deck deck;
    private BJPlayer bjPlayer;
    private BJDealer bjDealer;



    public BlackJackTable(BJPlayer bjPlayer, BJDealer bjDealer) {

        this.bjPlayer = bjPlayer;
        this.bjDealer = bjDealer;
        this.deck = bjDealer.getDeck();

        //gamePlay();
    }


    public void gamePlay() {
        System.out.println("\n------Welcome to the Table------");
        System.out.println("I am your dealer " + bjDealer.toString() + ". Good luck");
        while(!bjPlayer.outOfMoney()) {
            initDeal();
            putDownBet();
            showHandsHidden();
            boolean ended = playerTurn(bjPlayer.getHands().get(0), false);
            if (!ended) {
                dealerTurn(bjDealer);
            }
            // determine winner
            System.out.println("\n------ You have finished this round! ------");
            for (int i = 0; i < bjPlayer.getHands().size(); i++) {
                System.out.println("For player's hand " + (i + 1) + " :");
                this.showHands();
                gameResult(bjPlayer.getHands().get(i), bjDealer.getOneHand());
            }
            clearHands();
            bjPlayer.addNewHand();
            System.out.println("One more game? (y for yes)");
            String doplay = scanner.nextLine();
            char m=doplay.charAt(0);
            if(m!='Y'&&m!='y') {
                System.out.println("\nIt's my pleasure to deal for you! See you next time!");
                System.out.println("*************Leaving table***************");
                System.out.println("Your current balance is " + bjPlayer.getBalance());
                break;
            }
        }
        handleOutOfMoney();
        // pay out money
    }

    public void initDeal() {
        //deal cards in alternating sequence
        bjPlayer.getHands().get(0).add(deck.dealCard());
        bjDealer.getOneHand().add(deck.dealCard());
        bjPlayer.getHands().get(0).add(deck.dealCard());
        bjDealer.getOneHand().add(deck.dealCard());
    }

    public void putDownBet() {
        System.out.println("Your balance is: "+ bjPlayer.getBalance()+ " ! Please put down your bet: ");
        int bets;
        do {
            bets = scanner.nextInt();
            if(bjPlayer.canAfford(bets))
                break;
            System.out.println("Please bet more than 0 dollars and less than your balance "+ bjPlayer.getBalance());
        }while(true);
        bjPlayer.getHands().get(0).setBet(bets);
        bjPlayer.growBalance((-1)* bjPlayer.getHands().get(0).getBet());
        scanner.nextLine();
    }

    public void showHandsHidden() {
        System.out.println(bjDealer + "'s hand: "+ bjDealer.getOneHand().getFirstCard()+" HiddenCard" );
        for(int i = 0; i< bjPlayer.getHands().size(); i++)
            System.out.println("Player "+ bjPlayer + "'s hand "+(i+1)+": "+ bjPlayer.getHands().get(i).toString());
        System.out.println();
    }

    public void showHands() {
        System.out.println(bjDealer + "'s hand: " + bjDealer.getOneHand().toString());
        for(int i = 0; i< bjPlayer.getHands().size(); i++)
            System.out.println("Player "+ bjPlayer + "'s hand "+(i+1)+": "+ bjPlayer.getHands().get(i).toString());
        System.out.println();
    }

    public boolean playerTurn(BJHand h, boolean isSplitted) {
        while(!h.isBust() && !h.isBlackJack()) {
            //check for split-able
            if(h.canSplit()&& bjPlayer.canAfford(h.getBet())&&!isSplitted) { //only allow to split when have two identical cards            	isSplitted =true;							    // and enough money, and only allow to split once
                Card aCard = h.getFirstCard();					// and enough money, and only allow to split once
                System.out.println("You got a pair of " +
                        aCard.getFaceValue().toString() + "'s! It costs "+h.getBet()+"$ for splitting. Do you want to split"
                        + " them? (y/n)");

                String move = scanner.nextLine();
                if(move.equalsIgnoreCase("y") || move.equalsIgnoreCase("s")) {
                    //split here
                    bjPlayer.growBalance((-1)*h.getBet());//put down bet for splitting
                    //player.getHands().get(0).add(aCard);
                    //player.splitHand(h.getBet());
                    //ArrayList<Hand> tmp = h.split();
                    isSplitted = true;
                    split(h);
                    System.out.println("Splitting... ");
                    for(BJHand sh : bjPlayer.getHands()) {
                        sh.add(deck.dealCard());
                    }
                    showHandsHidden();
                    for(BJHand hand: bjPlayer.getHands()) {
                        playerTurn(hand,isSplitted);
                    }
                    break;
                }
            }
            //double up is available only in the first round and not splitted
            if(h.getNumCards() == 2 && bjPlayer.canAfford(h.getBet()) && !isSplitted) {
                System.out.println("Do you want to double down? (y/n)");
                String move = scanner.nextLine();
                if(move.equalsIgnoreCase("y") || move.equalsIgnoreCase("d")) {
                    hit(h);
                    bjPlayer.growBalance((-1) * h.getBet());
                    h.setBet(h.getBet()*2);
                    break;
                }
            }
            System.out.println("What would you like to do with hand "+(bjPlayer.getHands().indexOf(h)+1)+"? (h = hit, s = stand)");
            String move = scanner.nextLine();
            if(move.equalsIgnoreCase("h")) {
                hit(h);
            }
            else if(move.equalsIgnoreCase("s")) {
                System.out.println(bjPlayer +" has decided to stand. Hand "+(bjPlayer.getHands().indexOf(h)+1)+" is done.");
                break;
            }
            this.showHandsHidden();
        }
        if(h.isNaturalBlackJack() || h.isBust()) {
            return true;
        }
        return false;
    }

    public void dealerTurn(BJDealer d) {
        //Dealer hit on soft 17
        while(d.getOneHand().getBjScore() < 17 || (d.getOneHand().calculateOutputScore() && d.getOneHand().getBjScore() == 17)) {
            System.out.println("Dealer got " + d.getOneHand().getBjScore() + ". Dealer Must Hit");
            hit(d.getOneHand());
            this.showHands();
        }
        if(d.getOneHand().isBust())
            System.out.println("Dealer got " + d.getOneHand().getBjScore() + ". Dealer bust!");
        else
            System.out.println("Dealer got " + d.getOneHand().getBjScore() + ". Dealer stands");
    }

    public void gameResult(BJHand ph, BJHand dh) {
        //player bust
        if(ph.isBust()) {
            System.out.println("Player Busted! Dealer wins!");
            bjPlayer.growBalance(0);
        }
        //player natural BlackJack
        else if(ph.isNaturalBlackJack()) {
            System.out.println("Black Jack! Player wins! BlackJack is paid 2:1");
            bjPlayer.growBalance(ph.getBet()*3);
            //specify in doc that natural BJ is paid 2:1
        }
        //player not bust, Dealer bust
        else if(dh.isBust()) {
            System.out.println("Dealer Busted! Player wins!");
            bjPlayer.growBalance(ph.getBet()*2);
        }
        //Dealer blackjack insurance not implemented here
        //no body bust
        else {
            //Dealer is natural blackjack or Dealer's hand is larger
            if(ph.getBjScore() < dh.getBjScore() || dh.isNaturalBlackJack()) {
                System.out.println("Dealer wins!");
                bjPlayer.growBalance(0);
            }
            //tie
            else if(ph.getBjScore().equals(dh.getBjScore())) {
                System.out.println("It's a tie!");
                bjPlayer.growBalance(ph.getBet());
            }
            //player's hand is larger
            else {
                System.out.println("Congrats, Player wins!");
                bjPlayer.growBalance(ph.getBet()*2);
            }
        }
    }

    public void hit(BJHand ph) {
        ph.add(deck.dealCard());
    }

    public void split(BJHand h) {
        Card tmp1 = h.getFirstCard();
        Card tmp2 = h.getSecondCard();
        int oldBet=h.getBet();
        bjPlayer.clearHands();
        bjPlayer.addNewHand(tmp1, oldBet);
        bjPlayer.addNewHand(tmp2, oldBet);
    }

    public void clearHands() {
        bjPlayer.clearHands();
        bjDealer.clearHand();
    }

    public void handleOutOfMoney() {
        System.out.println("Thank you for playing and losing all your money! See you next time!");
    }
}
