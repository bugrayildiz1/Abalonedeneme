package finalProject;

import finalProject.Mark.Color;
import java.util.Scanner;

public class HumanPlayer extends Player {

	public HumanPlayer(String name, Color color) {
		super(name, color);
	}
	/**
	 * this method asks for the player's next move and with the scanner, it checks his move and print it on the board.
	 * @param board the board of the game
	 * @return the human player's move.
	 */
	public String determineMove(Board board) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("MOVE;yx;yx;DD \n " +" enter your move :");
		String answer = sc.nextLine();
		
		return answer;
	}
	

}
