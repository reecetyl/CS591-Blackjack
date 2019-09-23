public class Blackjack {	

	public static void main(String[] args) {
		Blackjack blackjack = new Blackjack();
		blackjack.play();
	}

	Deck deck = new Deck();
	Player dealer = new Dealer();
	Player player;
	

	Blackjack() {
		Scanner userInp = new Scanner(System.in);
		System.out.println("Welcome to Tyler, Sean, and Gary's CS591 Blackjack Game!")
		System.out.println("Please enter your name to begin: ");
		String name = userInp.nextLine();
		player = new Player(name);
	}

	public void play() {
		Card hiddenDealerCard = deckOfCards.dealOne();
			
	}

	public void giveCard(Player p, Card c) {

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
