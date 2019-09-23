public class Blackjack {	

	public static void main(String[] args) {
		Blackjack blackjack = new Blackjack();
		blackjack.newGame();
	}

	Deck deck = new Deck();
	Player dealer = new Dealer();
	Player player;
	Scanner userInp = new Scanner(System.in);
	

	Blackjack() {
		// Initialize game.
		System.out.println("Welcome to Tyler, Sean, and Gary's CS591 Blackjack Game!")
		System.out.println("Please enter your name to begin: ");
		String name = userInp.nextLine();
		player = new Player(name);
		// set the starting balance for player
		System.out.println("Please enter your starting money: ");
		int money = input.nextInt();
	}

	public void newGame() {
		System.out.println("------- Starting new round! -------");
		setBets();
		getFirstHands();
		showHands();
		//if it is able to split

		while(!gameOver()) {
			//player decides to play which move (split, double, hit, stand )

			/*
			if(player stand) break;
			*/
		}
		// Dealer's turn
		
	}

	public void setBets() {
		System.out.println("Please enter your bet: ");
		int bet = input.nextInt();
		//check if bet <= player.balence
	}

	public void getFirstHands() {
		// distribute cards
		giveCard(player, deck.removeCard());
		giveCard(dealer, deck.removeCard());
		giveCard(player, deck.removeCard());
		// hide the dealer's second card
		Card hiddenDealerCard = deck.removeCard();
	}

	public void split(Hand h){

	}

	public void doubleDown(Hand h){

	}

	public void hit(Hand h){

	}

	public void giveCard(Player p, Card c) {

	}

	//format outline the current state after every move
	public void showHands() {
		//show hands and current scores
	}

	public boolean gameOver() {
		if (player.totalPoints() >= 21 || dealer.totalPoints() >= 21) return true;
		else return false;
	}

	public void showWinner() {
		if(player.totalPoints() >= 21) System.out.println(player.getName() + " has lost");
		else if (dealer.totalPoints() >= 21) System.out.println(dealer.getName() + " has lost");
		else {
			Player winner = (player.totalPoints() > dealer.totalPoints()) ? player : dealer;
			System.out.println(winner.getName() + " wins");
		}
	}
}
