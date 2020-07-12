package finalProject.Client;

import finalProject.Board;
import finalProject.Game;
import finalProject.Move;
import finalProject.Player;
import finalProject.newServer.Server;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;



public class ClientReceiver implements Runnable {
	Server server;
	Socket sock;
	public BufferedReader in;
	public BufferedWriter out;
	public BufferedWriter out1;
	Player player;
	Game game;
	Board board;
	Move move;

	/**
	 * sockets, BufferedReader and BufferedWriter have been defined for the server
	 * @param sock socket
	 * @param server server
	 * @throws IOException
	 */
	public ClientReceiver(Socket sock, Server server) throws IOException {
		this.sock = sock;
		 in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		 out = new BufferedWriter(new OutputStreamWriter(System.out));
		 this.server= server;
	}
	@Override
	/**
	 * after the game created, this run method creates the new board acoording to the number of players tht have been specified
	 * while the game was creating.
	 */
	public void run() {
		while (true) {
			
			try {
				String msg = in.readLine();
				if (!msg.equals(null)) {
					out.write(msg);
					out.newLine();
					out.flush();
				}
				
			} 
			catch (Exception e) {			
			}
		}
	}

}
