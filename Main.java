import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Blackjack game = new Blackjack();
		game.welcome();
		game.initPlayer();
		Scanner userInput = new Scanner(System.in);
		while(true){
			game.turn();
			System.out.println("Do you wanna play another round? If so, enter Y/y.");
	        String doplay = userInput.nextLine();
	        char m=doplay.charAt(0);
		    if(m!='Y'&&m!='y')
		        break;
		}
	}
}