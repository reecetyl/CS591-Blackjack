import java.util.*;
public class Blackjack {
    private Scanner userInput = new Scanner(System.in);
    private BlackJackTable blackJackTable;
    private BJPlayer bjPlayer;
    
    Blackjack() {
        welcome();
        initPlayer();
        while(true){
            initTable();
            blackJackTable.gamePlay();
            System.out.println("Do you wanna switch table and play more? If so, enter Y/y.");
            String doplay = userInput.nextLine();
            char m=doplay.charAt(0);
            if(m!='Y'&&m!='y'){
                System.out.println("Thank you for playing BlackJack! Your final balance is " + bjPlayer.getBalance());
                break;
            }
        }
    }

    public void welcome() {
        System.out.println("————————————————————————————————————————————————————————");
        System.out.println("Welcome to Tyler, Zhelin, and Gary's CS591 Blackjack game!");
        System.out.println("————————————————————————————————————————————————————————\n");
    }

    public void initPlayer() {
        System.out.println("Please enter player's name: ");
        String playerName = userInput.nextLine();
        System.out.println("Please enter the amount of your starting money: ");
        Integer startingMoney;
        do {
        	startingMoney = userInput.nextInt();
            if(startingMoney>0)
            	break;
            System.out.println("Starting money invalid. Your starting money has to be more than 0 dollar.");
        }while(true);
        userInput.nextLine();
        bjPlayer = new BJPlayer(playerName, startingMoney);
    }

    private void initTable() {
        System.out.println("Please enter your desired dealer's name: ");
        String dealerName = userInput.nextLine();
        BJDealer bjDealer = new BJDealer(dealerName);
        blackJackTable = new BlackJackTable(bjPlayer, bjDealer);
    }




}
