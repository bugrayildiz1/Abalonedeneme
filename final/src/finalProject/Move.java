package finalProject;

import finalProject.Exceptions.NotValidMoveException;
import finalProject.Exceptions.NotValidPlayerException;
import finalProject.Mark.Color;
import java.util.ArrayList;
import java.util.List;



public class Move {

    public Board previousboard;
    
    /**
    * this method specifies the valid moves while player want to move only one marble.
    * @param a represents the coordinates
    * @param b represents the coordinates
    * @param board board that already created in the board class
    * @return a list of direction where the directions has the Color.O which is empty
    */
    public List<Direction> ValidMoves(int a, int b, Board board) {
        List<Direction> result = new ArrayList<Direction>();
        if (a < 4) {
            if ((a != 0 && b != 0) && board.colorFinder(a - 1, b - 1) == Color.O) {
                result.add(Direction.NW);
            }
            if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a, b + 1) == Color.O) {
                result.add(Direction.EE);
            }
			if ((b != 0) && board.colorFinder(a, b - 1) == Color.O) {
				result.add(Direction.WW);
			}
			if (board.colorFinder(a + 1, b + 1) == Color.O) {
				result.add(Direction.SE);
			}
			if (board.colorFinder(a + 1, b) == Color.O) {
				result.add(Direction.SW);
			}
			if ((a != 0 && b != board.alist.get(a).size() - 1) && board.colorFinder(a - 1, b) == Color.O) {
				result.add(Direction.NE);
			}
		}

		if (a > 4) {
			if (board.colorFinder(a - 1, b) == Color.O) {
				result.add(Direction.NW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a, b + 1) == Color.O) {
				result.add(Direction.EE);
			}
			if ((b != 0) && board.colorFinder(a, b - 1) == Color.O) {
				result.add(Direction.WW);
			}
			if ((a != 8 && b != board.alist.get(a).size() - 1) && board.colorFinder(a + 1, b) == Color.O) {
				result.add(Direction.SE);
			}
			if ((a != 8 && b != 0) && board.colorFinder(a + 1, b - 1) == Color.O) {
				result.add(Direction.SW);
			}
			if (board.colorFinder(a - 1, b + 1) == Color.O) {
				result.add(Direction.NE);
			}
		}
		if (a == 4) {
			if ((b != 0) && board.colorFinder(a - 1, b - 1) == Color.O) {
				result.add(Direction.NW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a, b + 1) == Color.O) {
				result.add(Direction.EE);
			}
			if ((b != 0) && board.colorFinder(a, b - 1) == Color.O) {
				result.add(Direction.WW);
			}
			if ((b != board.alist.get(a).size() - 1) 
			        && board.colorFinder(a + 1, b) == Color.O) {
				result.add(Direction.SE);
			}
			if ((b != 0) && board.colorFinder(a + 1, b - 1) == Color.O) {
				result.add(Direction.SW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a - 1, b) == Color.O) {
				result.add(Direction.NE);
			}
		}
		return result;
	}
	/**
	 * shows the friendly marbles around the specified coordinates
	 * @param a coordinates of the cell
	 * @param b coordinates of the cell
	 * @param board board of the game
	 * @return a list of direction where the direction has the same Color or Team Member(to be implemented)
	 */
	// returns a list of direction where the direction has the same Color or Team
	// Member(to be implemented)
	public List<Direction> whereFriend(int a, int b, Board board) {
		List<Direction> result = new ArrayList<Direction>();
		Color color = board.colorFinder(a, b);
		
		if (a < 4) {
			if ((a != 0 && b != 0) && board.colorFinder(a - 1, b - 1) == color) {
				result.add(Direction.NW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a, b + 1) == color) {
				result.add(Direction.EE);
			}
			if ((b != 0) && board.colorFinder(a, b - 1) == color) {
				result.add(Direction.WW);
			}
			if (board.colorFinder(a + 1, b + 1) == color) {
				result.add(Direction.SE);
			}
			if (board.colorFinder(a + 1, b) == color) {
				result.add(Direction.SW);
			}
			if ((a != 0 && b != board.alist.get(a).size() - 1) && board.colorFinder(a - 1, b) == color) {
				result.add(Direction.NE);
			}
		}
		if (a > 4) {
			if (board.colorFinder(a - 1, b) == color) {
				result.add(Direction.NW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a, b + 1) == color) {
				result.add(Direction.EE);
			}
			if ((b != 0) && board.colorFinder(a, b - 1) == color) {
				result.add(Direction.WW);
			}
			if ((a != 9 && b != board.alist.get(a).size() - 1) && board.colorFinder(a + 1, b) == color) {
				result.add(Direction.SE);
			}
			if ((a != 9 && b != 0) && board.colorFinder(a + 1, b - 1) == color) {
				result.add(Direction.SW);
			}
			if (board.colorFinder(a - 1, b + 1) == color) {
				result.add(Direction.NE);
			}
		}
		if (a == 4) {
			if ((b != 0) && board.colorFinder(a - 1, b - 1) == color) {
				result.add(Direction.NW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a, b + 1) == color) {
				result.add(Direction.EE);
			}
			if ((b != 0) && board.colorFinder(a, b - 1) == color) {
				result.add(Direction.WW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a + 1, b) == color) {
				result.add(Direction.SE);
			}
			if ((b != 0) && board.colorFinder(a + 1, b - 1) == color) {
				result.add(Direction.SW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a - 1, b) == color) {
				result.add(Direction.NE);
			}
		}
		return result;
	}

	// returns a list of direction where the direction has the same Color or Team
	// Member(to be implemented)
	/**
	 * shows the enemy marbles around the specified coordinates
	 * @param a coordinates
	 * @param b coordinates
	 * @param board Board
	 * @return a list of direction where the direction has the same Color or Team Member(to be implemented)
	 */
	public List<Direction> whereEnemy(int a, int b, Board board) {
		List<Direction> result = new ArrayList<Direction>();
		Color color = board.colorFinder(a, b);
		if (a < 4) {
			if ((a != 0 && b != 0) && board.colorFinder(a - 1, b - 1) != color
					&& board.colorFinder(a - 1, b - 1) != Color.O) {
				result.add(Direction.NW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a, b + 1) != color
					&& board.colorFinder(a, b + 1) != Color.O) {
				result.add(Direction.EE);
			}
			if ((b != 0) && board.colorFinder(a, b - 1) != color && board.colorFinder(a, b - 1) != Color.O) {
				result.add(Direction.WW);
			}
			if (board.colorFinder(a + 1, b + 1) != color && board.colorFinder(a + 1, b + 1) != Color.O) {
				result.add(Direction.SE);
			}
			if (board.colorFinder(a + 1, b) != color && board.colorFinder(a + 1, b) != Color.O) {
				result.add(Direction.SW);
			}
			if ((a != 0 && b != board.alist.get(a).size() - 1) 
					&& board.colorFinder(a - 1, b) != color
					&& board.colorFinder(a - 1, b) != Color.O) {
				result.add(Direction.NE);
			}
		}
		if (a > 4) {
			if (board.colorFinder(a - 1, b) != color 
					&& board.colorFinder(a - 1, b) != Color.O) {
				result.add(Direction.NW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a, b + 1) != color
					&& board.colorFinder(a, b + 1) != Color.O) {
				result.add(Direction.EE);
			}
			if ((b != 0) && board.colorFinder(a, b - 1) != color && board.colorFinder(a, b - 1) != Color.O) {
				result.add(Direction.WW);
			}
			if ((a != 9 && b != board.alist.get(a).size() - 1) && board.colorFinder(a + 1, b) != color
					&& board.colorFinder(a + 1, b) != Color.O) {
				result.add(Direction.SE);
			}
			if ((a != 9 && b != 0) && board.colorFinder(a + 1, b - 1) != color
					&& board.colorFinder(a + 1, b - 1) != Color.O) {
				result.add(Direction.SW);
			}
			if (board.colorFinder(a - 1, b + 1) != color && board.colorFinder(a - 1, b + 1) != Color.O) {
				result.add(Direction.NE);
			}
		}
		if (a == 4) {
			if ((b != 0) && board.colorFinder(a - 1, b - 1) != color && board.colorFinder(a - 1, b - 1) != Color.O) {
				result.add(Direction.NW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a, b + 1) != color
					&& board.colorFinder(a, b + 1) != Color.O) {
				result.add(Direction.EE);
			}
			if ((b != 0) && board.colorFinder(a, b - 1) != color && board.colorFinder(a, b - 1) != Color.O) {
				result.add(Direction.WW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a + 1, b) != color
					&& board.colorFinder(a + 1, b) != Color.O) {
				result.add(Direction.SE);
			}
			if ((b != 0) && board.colorFinder(a + 1, b - 1) != color && board.colorFinder(a + 1, b - 1) != Color.O) {
				result.add(Direction.SW);
			}
			if ((b != board.alist.get(a).size() - 1) && board.colorFinder(a - 1, b) != color
					&& board.colorFinder(a - 1, b) != Color.O) {
				result.add(Direction.NE);
			}
		}
		return result;
	}
	
	public boolean isitEmpty(int a, int b, Direction d, Board board) {
	
		if (ValidMoves(a, b, board).contains(d)) {
			return true;
		}
		
		return false;
	}
	
	public Field findMiddle(int a1, int b1, int a2, int b2, Direction d, Board b, Player p) {
		Field middle = null;
		Color c = p.getColor();
		System.out.println(c.toString());
		if ((a1 == 3 && a2 == 5) || (a1 == 5 && a2 == 3)) {
		    middle = new Field(b, (a1 + a2) / 2, ((b1 + b2) / 2) + 1, c);
		    
		}
		else {
			middle = new Field(b, (a1 + a2) / 2, (b1 + b2) / 2, c);
		}
		
		return middle;
	}
	
	public boolean canyouPush(int a, int b, Direction d, int numberofmarbleplaying, Board board, Player p) throws NotValidPlayerException {
		Field enemy = findField(a, b, d, board);
		if (numberofmarbleplaying == 1) {
			return false; 
        }
		else if (findField(a, b, d.DirectionOther(), board).getMark().getColor().equals(p.getColor())) {
			try {
				Field enemyback = findField(enemy.x, enemy.y, d, board);
				if (numberofmarbleplaying == 2) {
					if (p.enemyColors(board).contains(enemy.getMark().getColor())  && enemyback.getMark().getColor() == Color.O) {
						return true;
					}
				}
				else if (numberofmarbleplaying == 3) {
					Field enemybackback = findField(enemyback.x, enemyback.y, d, board);
					if (enemy.getMark().getColor().equals(enemyback.getMark().getColor()) &&
							p.enemyColors(board).contains(enemy.getMark().getColor()) &&
							enemybackback.getMark().getColor().equals(Color.O)) {
						return true;
					}
					else if (p.enemyColors(board).contains(enemy.getMark().getColor()) &&
							enemybackback.getMark().getColor().equals(Color.O)) {
						return true;
					}
				}
			} catch (NullPointerException e) {
				return true;
			}
		}		
		return false;
	}
	
	public boolean isitLineStep(int a2, int b2, Direction d, int numberofmarbleplaying, Board b, Player p) {
		if (whereFriend(a2, b2, b).contains(d.DirectionOther())) {
			return true;
		}
		return false;
	}
	
	// returns the field on that direction (you can pull the x and y components)
	/**
	 * this method helps player to find the coordinate of the cell that wants to go(direction specification needed)
	 * @param a coordinates
	 * @param b coordinates
	 * @param d Direction
	 * @param board
	 * @return the field on that direction (you can pull the x and y components)
	 */
	public Field findField(int a, int b, Direction d, Board board) {
		Field result = null;
		if (a < 4) {
			if (b != board.alist.get(a).size() - 1 && d == Direction.EE) {
				result = board.alist.get(a).get(b + 1);
			}
			if (b != 0 && d == Direction.WW) {
				result = board.alist.get(a).get(b - 1);
			}
			if (d == Direction.SE) {
				result = board.alist.get(a + 1).get(b + 1);
			}
			if (d == Direction.SW) {
				result = board.alist.get(a + 1).get(b);
			}
			if (a != 0 && b != board.alist.get(a).size() - 1 && d == Direction.NE) {
				result = board.alist.get(a - 1).get(b);
			}
			if ((a != 0 && b != 0) && d == Direction.NW) {
				result = board.alist.get(a - 1).get(b - 1);
			}
		}
		if (a > 4) {
			if ((b != board.alist.get(a).size() - 1) && d == Direction.EE) {
				result = board.alist.get(a).get(b + 1);
			}
			if ((b != 0) && d == Direction.WW) {
				result = board.alist.get(a).get(b - 1);
			}
			if ((a != 8 && b != board.alist.get(a).size() - 1) && d == Direction.SE) {
				result = board.alist.get(a + 1).get(b);
			}
			if ((a != 8 && b != 0) && d == Direction.SW) {
				result = board.alist.get(a + 1).get(b - 1);
			}
			if (d == Direction.NE) {
				result = board.alist.get(a - 1).get(b + 1);
			}
			if (d == Direction.NW) {
				result = board.alist.get(a - 1).get(b);
			}
		}
		if (a == 4) {
			if ((b != board.alist.get(a).size() - 1) && d == Direction.EE) {
				result = board.alist.get(a).get(b + 1);
			}
			if ((b != 0) && d == Direction.WW) {
				result = board.alist.get(a).get(b - 1);
			}
			if ((b != board.alist.get(a).size() - 1) && d == Direction.SE) {
				result = board.alist.get(a + 1).get(b);
			}
			if ((b != 0) && d == Direction.SW) {
				result = board.alist.get(a + 1).get(b - 1);
			}
			if ((b != board.alist.get(a).size() - 1) && d == Direction.NE) {
				result = board.alist.get(a - 1).get(b);
			}
			if ((b != 0) && d == Direction.NW) {
				result = board.alist.get(a - 1).get(b - 1);
			}
		}
		return result;
	}
	/**
	 * this method makes move for one marble. If player want to move more tha one marble, he/she needs to check other methods
	 * @param a coordinate
	 * @param b coordinate
	 * @param d Direction
	 * @param board Board
	 * @throws NotValidMoveException
	 */
	public void MakeMoveforOne(int a, int b, Direction d, Board board) throws NotValidMoveException  {
		Color color = board.colorFinder(a, b);
		if (!isitEmpty(a, b, d, board)) {
			throw new NotValidMoveException(d.toString() + " not a valid move.");

		} else if (isitEmpty(a, b, d, board)) {
			board.alist.get(a).get(b).setMark(Color.O);
			if (a < 4) {
				if (d == Direction.EE) {

					board.alist.get(a).get(b + 1).setMark(color);
				} else if (d == Direction.NE) {
					board.alist.get(a - 1).get(b).setMark(color);
				} else if (d == Direction.NW) {
					board.alist.get(a - 1).get(b - 1).setMark(color);
				} else if (d == Direction.SE) {
					board.alist.get(a + 1).get(b + 1).setMark(color);
				} else if (d == Direction.SW) {
					board.alist.get(a + 1).get(b).setMark(color);
				} else if (d == Direction.WW) {
					board.alist.get(a).get(b - 1).setMark(color);
				}
			}
			if (a > 4) {
				if (d == Direction.EE) {

					board.alist.get(a).get(b + 1).setMark(color);
				} else if (d == Direction.NE) {

					board.alist.get(a - 1).get(b + 1).setMark(color);
				} else if (d == Direction.NW) {
					board.alist.get(a - 1).get(b).setMark(color);
				} else if (d == Direction.SE) {
					board.alist.get(a + 1).get(b).setMark(color);
				} else if (d == Direction.SW) {
					board.alist.get(a + 1).get(b - 1).setMark(color);
				} else if (d == Direction.WW) {
					board.alist.get(a).get(b - 1).setMark(color);
				}
			}
			if (a == 4) {
				if (d == Direction.EE) {
					board.alist.get(a).get(b + 1).setMark(color);
				} else if (d == Direction.NE) {
					board.alist.get(a - 1).get(b).setMark(color);
				} else if (d == Direction.NW) {
					board.alist.get(a - 1).get(b - 1).setMark(color);
				} else if (d == Direction.SE) {
					board.alist.get(a + 1).get(b).setMark(color);
				} else if (d == Direction.SW) {
					board.alist.get(a + 1).get(b - 1).setMark(color);
				} else if (d == Direction.WW) {
					board.alist.get(a).get(b - 1).setMark(color);
				}
			}
		}
	}
	
	public void Sumito2(int a1, int b1, int a2, int b2, Direction d, Board b, Player p) throws NotValidMoveException, NotValidPlayerException {
		Field enemy1 = null;
		Field enemy2 = null;
		Field enemy3 = null;
		Field middle = null;
		boolean point = false;
		int numberofmarbleplaying = findPlayedMarks(a1, b1, a2, b2, d, b);
		try {
			System.out.println("1");
			enemy1 = findField(a2, b2, d, b);
		} catch (NullPointerException e){
			System.out.println("2");
			return;
		}
		try {
			System.out.println("3");
			enemy2 = findField(enemy1.x, enemy1.y, d, b);
			enemy3 = findField(enemy2.x, enemy2.y, d, b);
		}catch (NullPointerException e) { //making true because that means that the enemy in the corner.
			System.out.println("4");
			point = true;
		}
		if (findPlayedMarks(a1, b1, a2, b2, d, b) == 3) {
			middle = findMiddle(a1, b1, a2, b2, d, b, p);
			System.out.println(middle.x + " "+ middle.y);
			//if the middle is not the same color finish the function
			if (!middle.getMark().getColor().equals(p.getColor())) {
				System.out.println("5");
				return;
			}
		}
		
		//if its push
		if (canyouPush(a2, b2, d, numberofmarbleplaying, b, p)) {
			//means it will push an enemy for point
			System.out.println("inside of push");
			if (point) {
				if (numberofmarbleplaying == 2) {
					System.out.println("inside of push for 2");
					enemy1.getMark().SetColor(Color.O);
					MakeMoveforOne(a2, b2, d, b);
					MakeMoveforOne(a1, b1, d, b);
					p.setPoint(p.getPoint() + 1);
					//This increase will not shown if the game is not 4 player
					p.setTeamScore(p.getTeamScore() + 1);
					return;
				}
				else if (numberofmarbleplaying == 3) {
					System.out.println("inside of push for 3");
					//pushing 2
					if (enemy2 != null) {
						enemy2.getMark().SetColor(Color.O);
						MakeMoveforOne(enemy1.x, enemy1.y, d, b);	
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(middle.x, middle.y, d, b);
						MakeMoveforOne(a1, b1, d, b);
						p.setPoint(p.getPoint() + 1);
					}
					//pushing 1
					else {
						enemy1.getMark().SetColor(Color.O);
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(middle.x, middle.y, d, b);
						MakeMoveforOne(a1, b1, d, b);
						p.setPoint(p.getPoint() + 1);
					}
				}	
			}
//			pushing in the board
			else {
				if (numberofmarbleplaying == 2 && enemy2.getMark().getColor().equals(Color.O)) {
					MakeMoveforOne(enemy1.x, enemy1.y, d, b);
					MakeMoveforOne(a2, b2, d, b);
					MakeMoveforOne(a1, b1, d, b);
				}
				else if (numberofmarbleplaying == 3) {
					if (enemy2.getField().getMark().getColor().equals(Color.O)) {
						MakeMoveforOne(enemy1.x, enemy1.y, d, b);
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(middle.x, middle.y, d, b);
						MakeMoveforOne(a1, b1, d, b);
					}
					else if (enemy3.getMark().getColor().equals(Color.O)) {
						MakeMoveforOne(enemy2.x, enemy2.y, d, b);
						MakeMoveforOne(enemy1.x, enemy1.y, d, b);
						MakeMoveforOne(a2, b2, d, b);
						MakeMoveforOne(middle.x, middle.y, d, b);
						MakeMoveforOne(a1, b1, d, b);
					}
				}
			}
        }
	    //if its not pushing its moving
        else if (enemy1.getMark().getColor() == Color.O) {
		    System.out.println("inside of move");
		    if (numberofmarbleplaying == 1 && isitEmpty(a2, b2, d, b)) {
			    System.out.println("inside of move for one");
			    MakeMoveforOne(a2, b2, d, b);
			}
		    //line-step
		    else if (isitLineStep(a2, b2, d, numberofmarbleplaying, b, p)) {
				System.out.println("linestep");
				if (numberofmarbleplaying == 2) {
					MakeMoveforOne(a2, b2, d, b);
					MakeMoveforOne(a1, b1, d, b);
				}
				else if (numberofmarbleplaying == 3) {
					MakeMoveforOne(a2, b2, d, b);
					MakeMoveforOne(middle.x, middle.y, d, b);
					MakeMoveforOne(a1, b1, d, b);
				}
			}
			//side-step
			else if (findField(a1, b1, d, b).getMark().getColor().equals(Color.O)) {
				System.out.println("sidestep");
				if (numberofmarbleplaying == 2) {
					MakeMoveforOne(a2, b2, d, b);
					MakeMoveforOne(a1, b1, d, b);
				}
				else if (numberofmarbleplaying == 3 &&
						findField(middle.x, middle.y, d, b).getMark().getColor().equals(Color.O)) {
					MakeMoveforOne(a2, b2, d, b);
					MakeMoveforOne(middle.x, middle.y, d, b);
					MakeMoveforOne(a1, b1, d, b);
				}
			}
		}
	}
	

    // finds the number of played marks per turn..

    /**
     * finds the number of played marks per turn.
     * @param a1 coordinates of the initial marble
     * @param b1 coordinates of the initial marble
     * @param a2 coordinates of second initial marble
     * @param b2 coordinates of second initial marble
     * @param d Direction
     * @param b Board
     * @return the marks which were already played
     */
    public int findPlayedMarks(int a1, int b1, int a2, int b2, Direction d, Board b) {
        int result = 0;
		if (a1 == a2 && b1 == b2) {
			result = 1;
        }
		else if (Math.abs(a1 - a2) == 1 || Math.abs(b1 - b2) == 1) {
			result = 2;
		}
		// this is not else if because the some 3 mark rows could have (b1-b2) == 1
		if (Math.abs(a1 - a2) == 2 || Math.abs(b1 - b2) == 2) {
			result = 3;
		}
		return result;
	}

}
