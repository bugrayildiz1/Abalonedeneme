package finalProject;

import java.util.Scanner;

import finalProject.Mark.Color;
import finalProject.Exceptions.NotValidMoveException;
import finalProject.Exceptions.NotValidPlayerException;

public class AbaloneTUI {

	public static void main(String[] args) throws NotValidMoveException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean b = true;
		Game game = null;
		while (b) {			
			System.out.println("Welcome to the game Abalone..\nHow many players will play?");
			int answer = sc.nextInt();
			if (answer == 2) {
				String gamename = null;
				System.out.println("What is the game name?");
				gamename = sc.next();
				String firstname = null;
				System.out.println("What is the first player`s name?");
				firstname = sc.next();
				Player player1 = new HumanPlayer(firstname, Color.W);
				System.out.println("What is the second player`s name?");
				String secondname = null;	
					secondname = sc.next();
					Player player2 = null;
				if (secondname.equals("bot")){
					player2 = new ComputerPlayer(secondname, Color.B);
				}
				else {
					player2 = new HumanPlayer(secondname, Color.B);
				}			
				game = new Game(player1, player2, gamename);
				b= false;		
            }	
			else if (answer == 3) {
				String gamename = null;
				System.out.println("What is the game name?");
				gamename = sc.next();
				String firstname = null;
				System.out.println("What is the first player`s name?");
				firstname = sc.next();
				Player player1 = new HumanPlayer(firstname, Color.W);
				System.out.println("What is the second player`s name?");
				String secondname = null;
				secondname = sc.next();
				System.out.println("What is the third player`s name?");
				String thirdname = null;
				thirdname = sc.next();
				Player player3;
				Player player2 = null;
				if (secondname.equals("bot")){
					player2 = new ComputerPlayer(secondname, Color.B);
				}
				else {
					player2 = new HumanPlayer(secondname, Color.B);
				}
				if (thirdname.equals("bot")) {
					player3= new ComputerPlayer(thirdname, Color.R);
				}
				else {
					player3 = new HumanPlayer(thirdname, Color.R);
				}										
					game = new Game(player1, player2, player3, gamename);
					b= false;
			}
			else if (answer == 4) {
				String gamename = null;
				System.out.println("What is the game name?");
				gamename = sc.next();
				String firstname = null;
				System.out.println("What is the first player`s name?");
				firstname = sc.next();
				Player player1 = new HumanPlayer(firstname, Color.W);
				System.out.println("What is the second player`s name?");
				String secondname = null;
				secondname = sc.next();
				System.out.println("What is the third player`s name?");
				String thirdname = null;
				thirdname = sc.next();
				Player player3 = null;
				Player player2 = null;
				System.out.println("What is the forth player`s name?");
				String	forthname = null;
				forthname = sc.next();
				Player player4 = null;
				if (secondname.equals("bot")){
					player2 = new ComputerPlayer(secondname, Color.Y);
				}
				else {
					player2 = new HumanPlayer(secondname, Color.Y);
				}
				if (thirdname.equals("bot")) {
					player3= new ComputerPlayer(thirdname, Color.B);
				}
				else {
					player3 = new ComputerPlayer(thirdname, Color.B);
				}
				if (forthname.equals("bot")) {
					player4 = new ComputerPlayer(forthname, Color.R);
					}
				else {
					player4 = new HumanPlayer(forthname, Color.R);
				}					
					game = new Game(player1, player2, player3, player4, gamename);
					b= false;
			}
			else {
				System.err.println("invalid number of player");
			}
			if (game != null) {
				try {
					game.start();
				} catch (NotValidPlayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		}
	}
}
