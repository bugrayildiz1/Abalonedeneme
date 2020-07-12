package finalProject;

import java.util.ArrayList;
import java.util.List;

import finalProject.Exceptions.NotValidPlayerException;
import finalProject.Mark.Color;

/**
 * This class is for creating the board.
 */
public class Board {

	ArrayList<ArrayList<Field>> alist = new ArrayList<ArrayList<Field>>(9);
    Player p1;
    Player p2;
    Player p3;
    Player p4;
	int Team1TotalPoints  = 6;
	int Team2TotalPoints  = 6;
    ArrayList<Field> fields1;
    ArrayList<Field> fields2;
    ArrayList<Field> fields3;
    ArrayList<Field> fields4;
    ArrayList<Field> fields5;
    ArrayList<Field> fields6;
    ArrayList<Field> fields7;
    ArrayList<Field> fields8;
    ArrayList<Field> fields9;
    List<Player> players = new ArrayList<Player>();

	/**
	 * The constructor of the board class which creates an empty board with fields and 
	 * all these fields in this method represents the rows of the board 
	 * and these rows of lists are added in to another list which is called "alist"
	 */
    public Board() {

        fields9 = new ArrayList<Field>();
        for (int y = 0; y < 5; y ++) {
    		fields9.add(new Field(this, 0, y));
    	}
        fields8 = new ArrayList<Field>();
        for (int x = 0; x < 6; x ++) {
    		fields8.add(new Field(this, 1, x));
    	}
        fields7= new ArrayList<Field>();
        for (int x = 0; x < 7; x ++) {
    		fields7.add(new Field(this, 2, x));
    	}
        fields6 = new ArrayList<Field>();
        for (int x = 0; x < 8; x ++) {
    		fields6.add(new Field(this, 3, x));
    	}
        fields5 = new ArrayList<Field>();
        for (int x = 0; x < 9; x ++) {
    		fields5.add(new Field(this, 4, x));
    	}
        fields4 = new ArrayList<Field>();
        for (int x = 0; x < 8; x ++) {
    		fields4.add(new Field(this, 5, x));
    	}
        fields3 = new ArrayList<Field>();
        for (int x = 0; x < 7; x ++) {
    		fields3.add(new Field(this, 6, x));
    	}
        fields2 = new ArrayList<Field>();
        for (int x = 0; x < 6; x ++) {
    		fields2.add(new Field(this, 7, x));
    	}
        fields1 = new ArrayList<Field>();
        for (int x = 0; x < 5; x ++) {
    		fields1.add(new Field(this, 8, x));
    	}
        alist.add(fields9);
        alist.add(fields8);
        alist.add(fields7);
        alist.add(fields6);
        alist.add(fields5);
        alist.add(fields4);
        alist.add(fields3);
        alist.add(fields2);
        alist.add(fields1);
    }
   
    /**
     * Calculates the colors in the game in order to find the game capacity
     * @return result.size()-1
     */
    public int howManyColorsInGame() {
    	
    	List<Color> result = new ArrayList<Color>();
     	for (int i = 0; i < this.alist.size(); i++) {
    		for (int ii = 0; ii < this.alist.get(i).size(); ii++) {
    			if (!result.contains(this.alist.get(i).get(ii).getMark().getColor())) {
    				result.add(this.alist.get(i).get(ii).getMark().getColor());
    			}
    			
    		}
    	}
     	
    	return result.size()-1;
    }
	/**
	 * all of these print lines print the empty board with the initialised rows. Besides that,
	 *  there is also a board which shows the coordinates of the cells. Players can check the board and make their moves with checking the coordination of the cells
	 */
    public void createBoard(){        
    	System.out.print("      0 ");
    	System.out.print(alist.get(0).toString());
		System.out.println("                                                              0 [(0,0), (0,1), (0,2), (0,3, (0,4)]");
    	System.out.print("     1 ");
    	System.out.print(alist.get(1).toString());
    	System.out.println("                                                          1 [(1,0), (1,1), (1,2), (1,3), (1,4), (1,5)]");
    	System.out.print("    2 ");
    	System.out.print(alist.get(2).toString());
    	System.out.println("                                                      2 [(2,0), (2,1), (2,2), (2,3), (2,4), (2,5), (2,6)]");
    	System.out.print("   3 ");
    	System.out.print(alist.get(3).toString());
    	System.out.println("                                                  3 [(3,0), (3,1), (3,2), (3,3), (3,4), (3,5), (3,6), (3,7)]");
    	System.out.print("  4 ");
    	System.out.print(alist.get(4).toString());
    	System.out.println("                                   X   |       4 [(4,0), (4,1), (4,2), (4,3), (4,4), (4,5), (4,6), (4,7), (4,8)]");
    	System.out.print("   5 ");
    	System.out.print(alist.get(5).toString());
    	System.out.println("                                                  5 [(5,0), (5,1), (5,2), (5,3), (5,4), (5,5), (5,6), (5,7)]");
    	System.out.print("    6 ");
    	System.out.print(alist.get(6).toString());
    	System.out.println("                                                      6 [(6,0), (6,1), (6,2), (6,3), (6,4), (6,5), (6,6)]");
    	System.out.print("     7 ");
    	System.out.print(alist.get(7).toString());
    	System.out.println("                                                          7 [(7,0), (7,1), (7,2), (7,3), (7,4), (7,5)]");
    	System.out.print("      8 ");
    	System.out.print(alist.get(8).toString());
    	System.out.println("                                                              8 [(8,0), (8,1), (8,2), (8,3), (8,4)]");
    	System.out.println("                                                                                                       ---    ");
    	System.out.println("                                                                                                        Y ");
    }
    /**
	 * Creates the board as a string, This will used in the server to sent the board to the clients..
	 * @return string version of the board
	 */
    public String createBoardtoString() {
    	return ("      0 "+alist.get(0).toString()+"                                                              0 [(0,0), (0,1), (0,2), (0,3, (0,4)]\n"
    			+"     1 "+alist.get(1).toString()+"                                                          1 [(1,0), (1,1), (1,2), (1,3), (1,4), (1,5)]\n"
    			+"    2 "+alist.get(2).toString()+"                                                      2 [(2,0), (2,1), (2,2), (2,3), (2,4), (2,5), (2,6)]\n"
    			+"   3 "+alist.get(3).toString()+"                                                  3 [(3,0), (3,1), (3,2), (3,3), (3,4), (3,5), (3,6), (3,7)]\n"
    			+"  4 "+alist.get(4).toString()+"                                   X   |       4 [(4,0), (4,1), (4,2), (4,3), (4,4), (4,5), (4,6), (4,7), (4,8)]\n"
    			+"   5 "+alist.get(5).toString()+"                                                  5 [(5,0), (5,1), (5,2), (5,3), (5,4), (5,5), (5,6), (5,7)]\n"
    			+"    6 "+alist.get(6).toString()+"                                                      6 [(6,0), (6,1), (6,2), (6,3), (6,4), (6,5), (6,6)]\n"
    			+"     7 "+alist.get(7).toString()+"                                                          7 [(7,0), (7,1), (7,2), (7,3), (7,4), (7,5)]\n"
    			+"      8 "+alist.get(8).toString()+"                                                              8 [(8,0), (8,1), (8,2), (8,3), (8,4)]\n"
    			+"                                                                                                       ---    \n"
    			+"                                                                                                        Y ");
    }
	/**
	 * this method prints the initial board with all the marbles settled according to the number of players in the game
	 * @param numberofplayer is number of players in the game.
	 * @throws NotValidPlayerException is thrown if the number of players is not meet with the number of players
	 */
    public void setup(int numberofplayer) throws NotValidPlayerException {
    	if (numberofplayer == 2) {
    		for (int i = 0; i< alist.get(8).size(); i++) {
    			alist.get(8).get(i).setMark(Mark.Color.W);
    		}	
    		for (int i = 0; i< alist.get(7).size(); i++) {
    			alist.get(7).get(i).setMark(Mark.Color.W);
    		}
    		for (int i = 2; i< alist.get(6).size()-2; i++) {
    			alist.get(6).get(i).setMark(Mark.Color.W);
    		}
    		for (int i = 0; i< alist.get(0).size(); i++) {
    			alist.get(0).get(i).setMark(Mark.Color.B);
    		}	
    		for (int i = 0; i< alist.get(1).size(); i++) {
    			alist.get(1).get(i).setMark(Mark.Color.B);
    		}
    		for (int i = 2; i< alist.get(2).size()-2; i++) {
    			alist.get(2).get(i).setMark(Mark.Color.B);
    		}
    	}
    	else if(numberofplayer == 3) {
    		alist.get(0).get(0).setMark(Color.W);
		    alist.get(0).get(1).setMark(Color.W);
		    alist.get(1).get(0).setMark(Color.W);
		    alist.get(1).get(1).setMark(Color.W);
		    alist.get(2).get(0).setMark(Color.W);
		    alist.get(2).get(1).setMark(Color.W);
		    alist.get(3).get(0).setMark(Color.W);
		    alist.get(3).get(1).setMark(Color.W);
		    alist.get(4).get(0).setMark(Color.W);
		    alist.get(4).get(1).setMark(Color.W);
		    alist.get(5).get(0).setMark(Color.W);

		    alist.get(0).get(3).setMark(Color.B);
		    alist.get(0).get(4).setMark(Color.B);
		    alist.get(1).get(4).setMark(Color.B);
		    alist.get(1).get(5).setMark(Color.B);
		    alist.get(2).get(5).setMark(Color.B);
		    alist.get(2).get(6).setMark(Color.B);
		    alist.get(3).get(6).setMark(Color.B);
		    alist.get(3).get(7).setMark(Color.B);
		    alist.get(4).get(7).setMark(Color.B);
		    alist.get(4).get(8).setMark(Color.B);
		    alist.get(5).get(7).setMark(Color.B);
		    

		    for (int i = 0; i< alist.get(8).size(); i++) {
			    alist.get(8).get(i).setMark(Mark.Color.R);
		    }
		    for (int i = 0; i< alist.get(7).size(); i++) {
			    alist.get(7).get(i).setMark(Mark.Color.R);
		    }
    	}
    	else if (numberofplayer == 4) {
    		alist.get(4).get(0).setMark(Color.W);
 		    alist.get(4).get(1).setMark(Color.W);
 		    alist.get(4).get(2).setMark(Color.W);
 		    alist.get(5).get(0).setMark(Color.W);
 		    alist.get(5).get(1).setMark(Color.W);
 		    alist.get(5).get(2).setMark(Color.W);
 		    alist.get(6).get(0).setMark(Color.W);
 		    alist.get(6).get(1).setMark(Color.W);
 		    alist.get(7).get(0).setMark(Color.W);

 		    alist.get(1).get(5).setMark(Color.B);
 		    alist.get(2).get(5).setMark(Color.B);
 		    alist.get(2).get(6).setMark(Color.B);
 		    alist.get(3).get(5).setMark(Color.B);
 		    alist.get(3).get(6).setMark(Color.B);
 		    alist.get(3).get(7).setMark(Color.B);
 		    alist.get(4).get(6).setMark(Color.B);
 		    alist.get(4).get(7).setMark(Color.B);
 		    alist.get(4).get(8).setMark(Color.B);

 		    alist.get(8).get(4).setMark(Color.R);
 		    alist.get(8).get(3).setMark(Color.R);
 		    alist.get(8).get(2).setMark(Color.R);
 		    alist.get(8).get(1).setMark(Color.R);
 		    alist.get(7).get(2).setMark(Color.R);
 		    alist.get(7).get(3).setMark(Color.R);
 		    alist.get(7).get(4).setMark(Color.R);
 		    alist.get(6).get(3).setMark(Color.R);
 		    alist.get(6).get(4).setMark(Color.R);

 		    alist.get(0).get(0).setMark(Color.Y);
 		    alist.get(0).get(1).setMark(Color.Y);
 		    alist.get(0).get(2).setMark(Color.Y);
 		    alist.get(0).get(3).setMark(Color.Y);
 		    alist.get(1).get(1).setMark(Color.Y);
 		    alist.get(1).get(2).setMark(Color.Y);
 		    alist.get(1).get(3).setMark(Color.Y);
 		    alist.get(2).get(2).setMark(Color.Y);
 		    alist.get(2).get(3).setMark(Color.Y);
    	}
    	else {
    		throw new NotValidPlayerException(numberofplayer +" not a valid number for playing");
    	}
    }
	/**
	 * this method finds the mark of the cell.
	 * @param a the x coordinate of the marble
	 * @param b the y coordinate of the marble
	 * @return the Mark of the cell that specified via x and y coordinates.
	 */
    public Color colorFinder(int a, int b) {
    	return alist.get(a).get(b).getMark().getColor();
    }
    /**
     * @param b the type of the board
     * @requires z == 61 which z is 0 at the beginning and it shows the number of cells in the board
     * @return true if the cell is within the board
     */
    public boolean isEqual(Board b) {
    	int z = 0;
    	for (int i = 0; i < this.alist.size(); i++) {
    		for (int y = 0; y < this.alist.get(i).size(); y++) {
    			if (this.alist.get(i).get(y).getMark().getColor() == b.alist.get(i).get(y).getMark().getColor()) {
    				z++;
    			}
    		}
    	}
    	if (z == 61) {
    		return true;
    	}
    	return false;
    }
    /**
     * it clones the board
     * @param board the board of the game
     */
    public void cloneBoard(Board board) {
    	for (int i = 0; i < this.alist.size(); i++) {
    		for (int y = 0; y < this.alist.get(i).size(); y++) {
    			this.alist.get(i).get(y).getMark().SetColor(board.alist.get(i).get(y).getMark().getColor());
    		}
    	}
    }
}

