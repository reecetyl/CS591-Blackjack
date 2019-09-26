import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Blackjack game = new Blackjack();
		game.welcome();
		game.initPlayer();
		Scanner userInput = new Scanner(System.in);
		while(true){
			game.gameRound();			
			if(game.getPlayer().outOfMoney()) {
				game.handleOutOfMoney();
				break;
			}
			//check how many cards are left in the deck and shuffle the deck when needed.
			if(game.getDeck().getLeftCards() < 20) game.getDeck().shuffle();
			System.out.println("Do you wanna play another round? If so, enter Y/y.");
	        String doplay = userInput.nextLine();
	        char m=doplay.charAt(0);
		    if(m!='Y'&&m!='y'){
		    	System.out.println("Thank you for playing BlackJack! Your final balance is " + game.player.getBalance());
		        break;
		    }
		}
	}
}