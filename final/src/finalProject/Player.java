/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import finalProject.Exceptions.NotValidMoveException;
import finalProject.Exceptions.NotValidPlayerException;
import finalProject.Mark.Color;
import finalProject.Move;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Btbdn
 */



public abstract class Player {

	/**
	 * representing default team colors
	 */
    public enum Team {
        RY, //red-yellow
        BW, //black-white
        OO //PLAYERS WITHOUT TEAM WHICH 3 player game and 2 player
    }
 
    
    
    /*
     * sets the player properties
     * @param name is the name of the player
     * @param color is the color of the player's marble*/
    public Player(String name, Color color) {
       setName(name);
       setColor(color);
       setPoint(0);
       setTeam(Team.OO);
    }
    
    private String name;
    private Color color;
    int playerno;
    int points;
    int Teamscore = 0;
    Team team;

	/**
	 * @param b the board of the game
	 * @throws NotValidPlayerException is thrown if there is a unappropriate player in the game 
	 * @return the color of the enemy marbles
	 */
	public List<Color> enemyColors(Board b) throws NotValidPlayerException{
    	List<Color> result = new ArrayList<>();
    	Color p = this.getColor();
		int gamecolor = b.howManyColorsInGame();
    	if (gamecolor == 2) {
    		if (p == Color.B) {
    			result.add(Color.W);
    		}
    		else {
    			result.add(Color.B);
    		}
    	}
    	else if (gamecolor == 3) {
    		if (p == Color.R) {
    			result.add(Color.W);
    			result.add(Color.B);
    		}
    		else if (p == Color.W){
    			result.add(Color.R);
    			result.add(Color.B);
    		}
    		else if (p == Color.B) {
    			result.add(Color.W);
    			result.add(Color.R);
    		}
    	}
    	else if (gamecolor == 4) {
    		if (p == Color.W || p == Color.B) {
        		result.add(Color.R);
        		result.add(Color.Y);
    		}
        	else {
        		result.add(Color.B);
        		result.add(Color.W);
        	}
    	}
    	else {
    		throw new NotValidPlayerException("Wrong number of players");
    	}
    	return result;
    }
	/**
	 *
	 * @param p is player
	 * @return the other player's color in the game
	 */
	public Color getOtherMemberColor(Player p) {
    	Color result = Color.O;
    	if (p.getColor() == Color.B) {
    		result = Color.W;
    	}
    	else if (p.getColor() == Color.W) {
    		result = Color.B;
    	}
    	else if (p.getColor() == Color.R) {
    		result = Color.Y;
    	}
    	else if (p.getColor() == Color.Y) {
    		result = Color.R;
    	}
    		
    	return result;
    }
    public void setTeamScore(int newScore) {
    	this.Teamscore = newScore;
    }
    public int getTeamScore() {
    	return Teamscore;
    }
    public Team getTeam() {
    	return this.team;
    }

	/**
	 *  sets the team
	 * @param t
	 */
	public void setTeam(Team t) {
    	this.team = t;
    }
    public int getPoint() {
        return points;
    }

    public void setPoint(int Point) {
        this.points = Point;
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
   
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	/**
	 * when the client write the move command's direction, this method changes the string into the actual direction from the class "Direction".
	 * @param s
	 * @return
	 */
    public Direction findDirection(String s) {
    	Direction result = null;
    	if (s.equals("SW")) {
    		result = Direction.SW;
    	}
    	else if (s.equals("EE")) {
    		result = Direction.EE;
    	}
    	else if (s.equals("WW")) {
    		result = Direction.WW;
    	}
    	else if (s.equals("SE")) {
    		result = Direction.SE;
    	}
    	else if (s.equals("NW")) {
    		result = Direction.NW;
    	}
    	else if (s.equals("NE")) {
    		result = Direction.NE;
    	}
    	return result;
    }
    @Override
    public String toString() {
        return getName() + " - " + getColor() + " - " + getPoint();
    }
    public String toTeamString() {
    	 return getName() + " - " + getTeam() + " - " + getTeamScore();
    }
    public abstract String determineMove(Board board);
	/**
	 * this method checks the client's moves if they are valid moves or invalid moves. If they are not valid moves, it prints the error message from its Exception class
	 * @param board of the game
	 * @throws NotValidMoveException if the player make unappropriate move in the game
	 */
	protected  void makeMove(Board board) throws NotValidMoveException {
		try {
			Move m = new Move();
			String answer = determineMove(board);
			String[] cmds = answer.split(";");
			String location1 = cmds[1];
			int x1 = Character.getNumericValue(location1.charAt(0));
			int y1 = Character.getNumericValue(location1.charAt(1));
			String location2 = cmds[2];
			int x2 = Character.getNumericValue(location2.charAt(0));
			int y2 = Character.getNumericValue(location2.charAt(1));
			String direction = cmds[3];
			m.Sumito2(x1, y1, x2, y2, findDirection(direction), board, this);
			}
			catch (Exception e) {
//				throw new NotValidMoveException("");
			}
	}    
}
