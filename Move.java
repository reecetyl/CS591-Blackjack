public class Move {
	private Player player;
	private Card card;
	
	public Move(Player p, Card c) {
		this.player = p;
		this.card = c;
	}

	public Player getPlayer() {
		return this.player;
	}
	
	public Card getCard() {
		return this.card;
	}
    /*
	public String toString() {
		return "Move: " + player.getName() + " " + " takes Card " + card.toString() + " for " + String(card.getScore()) + " points";
	}
	*/
}
