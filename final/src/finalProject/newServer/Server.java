package finalProject.newServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;
import finalProject.Board;
import finalProject.Game;
import finalProject.HumanPlayer;
import finalProject.Mark.Color;
import finalProject.Move;
import finalProject.Player;
import finalProject.Client.Client;
import finalProject.Exceptions.NotValidMoveException;
import finalProject.Exceptions.NotValidPlayerException;



public class Server {
	Map<String, Integer> games = new HashMap<String,Integer>(); 
	Move move;
	public BufferedReader in;
	BufferedWriter out;
	List<Player> people = new ArrayList<Player>();
	private Board board;
	Map <String,Client> clients = new HashMap<>();
	Map <Integer, Board> BoardHistory = new HashMap<>();
	Game game; 
	Map<Game, List<Player>> games1 = new HashMap<>();
	Socket sock;
	ClientHandler server1;
	public static Vector<ClientHandler> ar = new Vector<>();
	int rounds;
	/**
	 * Constructor of the class which called in main method in order to run the server.
	 * @throws IOException
	 * @throws InterruptedException is thrown if there is interrupted connection while playing the game
	 */
	public Server() throws IOException, InterruptedException {
		int port = 8189;
		System.out.println("Server starting...");
		try (ServerSocket s = new ServerSocket(port)) {
			while(true) {
				try {
						
					Socket incoming = s.accept();
						
				    this.out = new BufferedWriter(new OutputStreamWriter(incoming.getOutputStream()));
				    Client c = new Client( incoming.getInetAddress().toString(), incoming, this);
				    clients.put(incoming.getInetAddress().toString(), c);
				    out.write("Client connected..");
				    out.newLine();
				    out.flush();
				    server1 = new ClientHandler(incoming, this);
					Thread streamInputHandler = new Thread(server1);
					streamInputHandler.start();
					ar.add(server1);
				}
				catch (SocketException e) {
					e.printStackTrace();
				}
            }
        }	
	}

	/**
	 * gets board
	 * @return board that has defined
	 */
	public Board getBoard() {
		return this.board;
	}

	/**
	 * this method finds the games that has created in the server
	 */
	public void findGames() {
		try {
			out.write(games.toString()+" has "+ people.size() + " players.");
			out.newLine();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * players are able to create a new game with filling the game name, 
	 * username and the number of players specifications the game does not start because the 
	 * game should be full to start game.
	 * @param numberofPlayer player number in the game
	 * @param gameName name of the game
	 * @param name username of the player
	 * @throws IOException
	 */
	
	public void CreateGame(int numberofPlayer, String gameName, String name) throws IOException {
		
		board = new Board();
		people.add(new HumanPlayer(name, Color.W));
		games.put(gameName, numberofPlayer);
		out.write("Waiting...");
		out.newLine();
		out.flush();
	}
	/**
	 * Creates the current board to all avaiable clients
	 */
	public void CreateBoardforAllClients () throws IOException {
		for (ClientHandler arr: Server.ar) {
			arr.out.write(game.getBoard().createBoardtoString());
			arr.out.newLine();
			arr.out.flush();
			
			}
	}
	/**
	 * sends a String to all available clients
	 * @param write is the message for all client
	 * @throws IOException
	 */
	public void WriteforAllClients (String write) throws IOException {
		for (ClientHandler arr: Server.ar) {
			arr.out.write(write);
			arr.out.newLine();
			arr.out.flush();	
			}
	}
	/**
	 * Checks the turn by counting.
	 * @return the player's turn when he/she needs to make move
	 */
	public Player WhosTurn() {
		if ((game.whosturn == 4 && people.size() == 4)||
				(game.whosturn == 3 && people.size() == 3)||
				(game.whosturn == 2 && people.size() == 2)){
			game.whosturn = 0;
		}
		return people.get(game.whosturn);
	}
	/**
	 * This method checks if the created room is avaiable to join and checks its capacity and if the capaticity is full t will start the game.
	 * @param gamename is the name of the game which is specified by thre host of the game
	 * @param playername name of the players
	 * @throws IOException
	 */
	public void JoinGame (String gamename , String playername) throws IOException, NotValidPlayerException {
		
		for (Entry<String, Integer> e: games.entrySet()) {
			if (e.getKey().contains(gamename)) {
				
				if (e.getValue() == people.size()) {
					out.write("The game currently is full sorry");
					out.newLine();
					out.flush();
				}
				else if (e.getValue() < people.size()-1) {
					if (people.size() == 1) {
						people.add(new HumanPlayer(playername, Color.B));
						out.write("Waiting...");
						out.newLine();
						out.flush();
					}
					else if (people.size() == 2) {
						people.add(new HumanPlayer(playername, Color.R));
						out.write("Waiting...");
						out.newLine();
						out.flush();
					}
					
				}
				else if (e.getValue() == people.size()+1) {
					if (e.getValue() == 2) {
						people.add(new HumanPlayer(playername, Color.B));
						game = new Game (people.get(0), people.get(1), e.getKey());
						System.out.println(people.toString());
						game.getBoard().setup(ar.size());
						board.createBoard();
						for (ClientHandler arr: Server.ar) {
							arr.out.write("STARTING");
							arr.out.newLine();
							arr.out.write(game.getBoard().createBoardtoString());
							arr.out.newLine();
							arr.out.flush();
							
							}
					}
					
					else if (e.getValue() == 3) {
						people.add(new HumanPlayer(playername, Color.R));
						game = new Game (people.get(0), people.get(1),people.get(2), e.getKey());
						out.write("Starting... \n");
						out.newLine();
						out.flush();
					
					}
					else if(e.getValue() == 4) {
						people.add(new HumanPlayer(playername, Color.Y));
						game = new Game (people.get(0), people.get(1),people.get(2),people.get(3) ,e.getKey());
						out.write("Starting...");
						out.newLine();
						out.flush();
						
					}
					
				}
				else {
					out.write("there is a problem:(");
					out.newLine();
					out.flush();
				}
				
			}
			else {
				out.write("Not a valid gameName");
				out.newLine();
				out.flush();
			}
		}
		
	}
	
	/**
	 * @param gamename the name of the game
	 * @param username the user name of the player
	 * @throws IOException
	 * @throws NotValidPlayerException is thrown if there is unappropriate player 
	 * */
	public void joinGame1(String gamename, String username) throws IOException, NotValidPlayerException {
	    for (Entry<String, Integer> e: games.entrySet()) {
	        int gamesize = e.getValue();
	        if (e.getKey().equals(gamename)) {
	            if (e.getValue() == people.size()) {
                    out.write("The game currently is full sorry");
                    out.newLine();
                    out.flush();
                }
	            //now the game will start
	            else if (gamesize == people.size() + 1) {
	                if (gamesize == 2) {
	                    people.add(new HumanPlayer(username, Color.B));
                        game = new Game (people.get(0), people.get(1), gamename);
                        for (ClientHandler arr: Server.ar) {
                            arr.out.write("STARTING");
                            arr.out.newLine();
                            arr.out.write(game.getBoard().createBoardtoString());
                            arr.out.newLine();
                            arr.out.flush();
                            
                            }
	                }
	                else if (gamesize == 3) {
	                    people.add(new HumanPlayer(username, Color.R));
                        game = new Game (people.get(0), people.get(1),people.get(2), gamename);
                        for (ClientHandler arr: Server.ar) {
                            arr.out.write("STARTING");
                            arr.out.newLine();
                            arr.out.write(game.getBoard().createBoardtoString());
                            arr.out.newLine();
                            arr.out.flush();
                            
                            }
                    }
	                else if (gamesize == 4) {
	                    people.add(new HumanPlayer(username, Color.R));
                        game = new Game (people.get(0), people.get(1), people.get(2), people.get(3), gamename);
                        for (ClientHandler arr: Server.ar) {
                            arr.out.write("STARTING");
                            arr.out.newLine();
                            arr.out.write(game.getBoard().createBoardtoString());
                            arr.out.newLine();
                            arr.out.flush();
                        }
                    }
	            }
	            else if (gamesize == people.size() + 2) {
                    if (gamesize == 3) {
                        people.add(new HumanPlayer(username, Color.B));
                        for (ClientHandler arr: Server.ar) {
                            arr.out.write("Welcome " + username + "\n Waiting...");
                            arr.out.newLine();
                            arr.out.flush();
                        }
                    }
                    else if (gamesize == 4) {
                        people.add(new HumanPlayer(username, Color.B));
                        for (ClientHandler arr: Server.ar) {
                            arr.out.write("Welcome " + username + "\n Waiting...");
                            arr.out.newLine();
                            arr.out.flush();
                        }
                    }
	            }
	            else if (gamesize == people.size() + 3) {
	                if (gamesize == 4) {
	                    people.add(new HumanPlayer(username, Color.Y));
	                    for (ClientHandler arr: Server.ar) {
                            arr.out.write("Welcome " + username + "\n Waiting...");
                            arr.out.newLine();
                            arr.out.flush();
                        }
	                }
	            }
	        }
	        else {
	            out.write("There is a problem");
	        }
	    }
	}
	
	/** 
	 * It is main function for running the server
	 * @throws IOException
	 * @throws NotValidMoveException if there is unappropriate move which have done by the player
	 * @throws NotValidPlayerException if there is unappropriate player in the game
	 * @throws InterruptedException */
	public static void main(String[] args) throws IOException, NotValidMoveException, NotValidPlayerException, InterruptedException {
		new Server();
	}
		
		
		
	
} // end of class Server