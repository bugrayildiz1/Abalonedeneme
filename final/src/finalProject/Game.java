package finalProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import finalProject.Player.Team;
import finalProject.Exceptions.NotValidMoveException;
import finalProject.Exceptions.NotValidPlayerException;


public class Game {
	public Board board;
	public Board prevboard;
	public List<Player> players = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	String name;
	final int win = 6;
	public int rounds;
	public int whosturn = 0;
	public int numberofrounds;	
	
	public Map<Integer, Board> game = new HashMap<>();
	//creating a game for 4 players
	
	/**
	 * @param p1 is the player who joined first in the game 
	 * @param p2 is the player who joined second in the game
	 * @param p3 is the player who joined third in the game
	 * @param p4 is the player who joined fourth in the game
	 * @param name the name of the game
	 * @throws NotValidPlayerException is thrown if there is unapporpriate player in the game
	 * */
	public Game(Player p1, Player p2, Player p3, Player p4, String name) throws NotValidPlayerException {
		board = new Board();
		board.setup(4);
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		p1.setTeam(Team.BW);
		p2.setTeam(Team.BW);
		p3.setTeam(Team.RY);
		p4.setTeam(Team.RY);
		numberofrounds = 0;
		this.name = name;
	}
	/*
	 * creates a game for 3 players if user wants to play the game with 3 people
	 * @param p1 the first player in the game
	 * @param p2 the second player in the game
	 * @param p3 the third player in the game
	 * @param name the name of the game
	 * @throws NotValidPlayerException is thrown if there is unapporpriate player in the game
	 * 
	 **/
	public Game(Player p1, Player p2, Player p3, String name) throws NotValidPlayerException {
		board = new Board();
		board.setup(3);
		players.add(p1);
		players.add(p2);
		players.add(p3);
		numberofrounds = 0;
		this.name = name;
	}
	//create a game for 2 players
	/**
	 * creates a game for 3 players if user wants to play the game with 3 people
	 * @param p1 the first player in the game
	 * @param p2 the second player in the game
	 * @param name the name of the game
	 * @throws NotValidPlayerException is thrown if there is unapporpriate player in the game
	 **/
	public Game(Player p1, Player p2, String name) throws NotValidPlayerException {
		board = new Board();
		board.setup(2);
		players.add(p1);
		players.add(p2);
		numberofrounds = 0;
		this.name = name;
	}
	/**
	 * if the game did not end, it asks for another round
	 * @throws NotValidMoveException is thrown if there is not valid move
	 * @throws NotValidPlayerException is thrown if there is not valid player */
	public void start() throws NotValidMoveException, NotValidPlayerException {
		 boolean continueGame = true;
		 while (continueGame) {
			 play();
			 System.out.println("\n> Play another time? (true/false)?");
	            continueGame = sc.hasNextBoolean();
		 }
	}
	/*
	 * current players make move and can see the hint move
	 * @ensures !isWinner() || numberofrounds == 40
	 * @throws NotValidMoveException is thrown if there is not valid move
	 * @throws NotValidPlayerException is thrown if there is not valid player
	 *  */
	public void play() throws NotValidMoveException, NotValidPlayerException {
		board.setup(players.size());
		prevboard = new Board();
		prevboard.setup(players.size());
		board.createBoard();
		int rounds = 0;
		while((!isWinner() || numberofrounds == 40)) {
			
			
			Player currentPlayer = players.get(rounds);
			System.out.println(currentPlayer.getName() +"`s turn\n" + currentPlayer.getColor() + " is the mark you need to play");
			Player hint = new ComputerPlayer("hint", currentPlayer.getColor());
			System.out.println("HINT: " +hint.determineMove(getBoard()));
			game.put(numberofrounds, getBoard());
			try {
				if (numberofrounds != 0) {
					prevboard.cloneBoard(board);
				}
				currentPlayer.makeMove(board);
			}catch (NotValidMoveException e) {
				System.out.println("Invalid move please try again..");
				rounds = rounds-1;
				numberofrounds = numberofrounds - 1;
				
			}
			
			board.createBoard();
	
			if (board.howManyColorsInGame() != 4) {
				System.out.println(players.toString());
			}
			else {
				System.out.println("[BW=>"+(players.get(0).getTeamScore()+players.get(2).getTeamScore())+ " RY=>"+(players.get(1).getTeamScore()+players.get(3).getTeamScore())+"]");

			}
			if (board.isEqual(prevboard)) {
				System.out.println("WRONG MOVE, PLEASE TRY AGAIN...");
				if (rounds == 0) {
					rounds = rounds + players.size()-1;
					numberofrounds--;
				}
				else {
					rounds--;
					numberofrounds--;
				}
				
			}
			numberofrounds++;
			rounds++;
		
			if ((rounds == 4 && players.size() == 4)||
					(rounds == 3 && players.size() == 3)||
					(rounds == 2 && players.size() == 2)){
				rounds = 0;
			}
		}
	}
	/**
	 * gives the board of the game.
	 * @return board the specified according to the specified number of players
	 */
	 public Board getBoard() {
		 return this.board;
	 }
	 /**
		 * detects if there is a winner in the game
		 * @requires win == players.get(i).getPoint()
		 * @return true if there is a winner in the game
		 */
	 public boolean isWinner() {
		 for (int i = 0; i < players.size()-1; i++) {
			 if(win ==  players.get(i).getPoint()) {
				 return true;
			 }
			 else if (win == players.get(i).getTeamScore()) {
				 return true;
			 }
		 }
		 if (players.size() == 4){
			 if (players.get(0).getTeamScore()+players.get(2).getTeamScore()==6) {
				 return true;
			 }
			 else if (players.get(1).getTeamScore()+players.get(3).getTeamScore()==6) {
				 return true;
			 }
		 }		 
		return false;
	 }
}

