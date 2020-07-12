package finalProject;

import finalProject.Mark.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;



public class ComputerPlayer extends Player{

	/**
	 * this represents the name and color of the artificial intelligent player
	 * @param name the name of the computer player
	 * @param color the color of the computer player
	 */
	public ComputerPlayer(String name, Color color) {
		super(name, color);
	}

	/**
	 * AI player makes his random moves. It checks the all possibilities that it can do and priority of the moves that its going to make is sidestep moves.
	 * @param board is in type of Board class
	 * @return move of the computer player
	 */
	@Override
	public String determineMove(Board board) {
		Map<Field, List<Direction>> kek = new HashMap<Field, List<Direction>>();
		Move m = new Move();
		int x = 0;
		int y = 0;
		Direction d = null;
		for (int i = 0; i< board.alist.size()-1; i++) {
			for (int z =0; z<board.alist.get(i).size()-1; z++) {
				if (board.alist.get(i).get(z).getMark().getColor() == this.getColor()) {
					
					List<Direction> list = m.ValidMoves(i, z, board);
					kek.put(board.alist.get(i).get(z), list);
				}
			}
		}
		for (Entry<Field, List<Direction>> e: kek.entrySet()) {
				if (e.getValue().contains(Direction.SE)) {
					d = Direction.SE;
					x = e.getKey().x;
					y =e.getKey().y;
					
				}
				else if (e.getValue().contains(Direction.NE)) {
					d = Direction.NE;
					x = e.getKey().x;
					y =e.getKey().y;
					
				}
				else if (e.getValue().contains(Direction.SW)) {
					d = Direction.SW;
					x = e.getKey().x;
					y =e.getKey().y;
					
				}
				else if (e.getValue().contains(Direction.NW)) {
					d = Direction.NW;
					x = e.getKey().x;
					y =e.getKey().y;
					
				}
				else if (e.getValue().contains(Direction.EE)) {
					d = Direction.EE;
					x = e.getKey().x;
					y =e.getKey().y;
					
				}
				else if (e.getValue().contains(Direction.WW)) {
					d = Direction.WW;
					x = e.getKey().x;
					y =e.getKey().y;
					
				}
			}
		
	return "MOVE;"+ x+""+y+";"+x+""+y+";"+d.toString();

	}
}
