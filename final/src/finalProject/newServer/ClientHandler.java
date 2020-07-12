package finalProject.newServer;

import finalProject.Exceptions.NotValidMoveException;
import finalProject.Exceptions.NotValidPlayerException;
import finalProject.Board;
import finalProject.Move;
import finalProject.Player;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class ClientHandler implements Runnable {
    public final String EXIT = "exit";
    protected String name;
    protected Socket sock;
    public BufferedReader in;
    public BufferedWriter out;
    protected boolean closed = false;
    Player currentplayer;
    Server server;
   
    boolean start = true;
    /**
     * This method specifies the parameters that the class has
     * @param socket for creating connection between clients
     * @param server server is our server that already exist in the server class
     * @throws IOException from inputStream
     */
    public ClientHandler(Socket socket,Server server) throws IOException {
        this.sock = socket;
        this.in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        this.out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
        this.server = server;
			
    }
    public Socket getSocket() {
        return this.sock;
    }
	public void SetName (String name) {
	    this.name = name;
	}
	@Override
	public synchronized void run() {
	    while (true) {
	        if (server.game != null) {
	            currentplayer = server.game.players.get(server.game.rounds);
	            try {
	                server.WriteforAllClients(currentplayer.getName() +"`s turn\n" + 
                            currentplayer.getColor() + " is the mark you need to play");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
	   		String msg = null;
	   		
	   		try {
				msg = in.readLine();
				
        		
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {			
				try {
					handleCommand(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}

			} catch (NotValidMoveException e) {				
				shutDown();
			} catch (NotValidPlayerException e) {
				
				e.printStackTrace();
			}
			}
	}

	/**
	 * close the connection
	 */
    public void shutDown() {
    	try {
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	/**
	 * create a switch statement that will check all the inputs that client made and it will do the protocols according to that;
	 * @param line is for move commands in the game.
	 * @throws NotValidMoveException is thrown if the user make unappropriate move in the game
	 * @throws NotValidPlayerException is thrown if there is not unappropriate player in the game
	 * @throws IOException 
	 */
    public void handleCommand(String line) throws NotValidMoveException, NotValidPlayerException, IOException {
   	 
   	 // create a switch statement that will check all the inputs that client made and it will do the protocols according to that;
            try {
                String[] cmds = line.split(";");
                switch (cmds[0]) {
                	case "MOVE":
                		
                			if (cmds.length < 4) {
                    			out.write("TOOFEWARGUMENTS..");
                    			out.newLine();
                    			out.flush();
                    			break;
                    		}
                			else {
                			    currentplayer = server.game.players.get(server.game.rounds);
                				server.game.prevboard = new Board();
                				server.game.whosturn++;
                				server.game.prevboard.cloneBoard(server.game.getBoard());
                        		Move m = new Move();
                        		
                        		String location1 = cmds[1];
                        		int x1 = Character.getNumericValue(location1.charAt(0));
                        		int y1 = Character.getNumericValue(location1.charAt(1));
                        		String location2 = cmds[2];
                        		int x2 = Character.getNumericValue(location2.charAt(0));
                        		int y2 = Character.getNumericValue(location2.charAt(1));
                        		String direction = cmds[3];
                        		
                        		
                        		try {
                        		
                        			m.Sumito2(x1, y1, x2, y2, currentplayer.findDirection(direction), server.game.board, currentplayer);
                            		
                        		}
                        		catch (NotValidMoveException e) {
                        			
                        		}
                        		if (server.game.getBoard().isEqual(server.game.prevboard) ) {
                                    server.WriteforAllClients("WRONG MOVE "+ currentplayer.getName() +", PLEASE TRY AGAIN...");
//                                    if (server.game.rounds == 0) {
//                                        server.game.rounds = server.game.rounds + server.game.players.size()-1;
//                                        server.game.numberofrounds--;
//                                    }
//                                    else {
                                        server.game.rounds--;
                                        server.game.numberofrounds--;
//                                    }
                                    
                                }
                        		server.game.numberofrounds++;
                        		server.game.rounds++;
                        		
                        		if ((server.game.rounds == 4 && server.game.players.size() == 4)||
                                        (server.game.rounds == 3 && server.game.players.size() == 3)||
                                        (server.game.rounds == 2 && server.game.players.size() == 2)){
                        		    server.game.rounds = 0;
                                }
                        		server.CreateBoardforAllClients();
                        		server.WriteforAllClients(server.people.toString());
                        		break;
                			}
                    		
                		
                		
                	case "LEAVEGAME":
                		shutDown();
                		break;
                	case "CREATEGAME":
                		out.write("Game Created..");
                		out.newLine();
                		out.flush();
                		int noplayer = Character.getNumericValue(cmds[1].charAt(0));
                		String gamename = cmds[2];
                		String username = cmds[3];
                   		server.CreateGame(noplayer ,gamename, username);
                   		break;
                		
                		
                	case "JOINGAME":
                		String gamename1 = cmds[1];
                		String username1 = cmds[2];
                		server.joinGame1(gamename1, username1);
                		break;
                	case "SENDMESSAGE":
                		break;
                	case "FINDGAMES":
                		server.findGames();
                		break;
                
                }
            }
             catch (IOException e) {
                e.printStackTrace();
            }
    	
            
	}
}