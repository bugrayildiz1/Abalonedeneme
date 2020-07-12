package finalProject.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import finalProject.Board;
import finalProject.HumanPlayer;
import finalProject.Exceptions.NotValidPlayerException;
import finalProject.Mark.Color;

public class BoardTest {
	Board board;
	@BeforeEach
	public void setup() throws NotValidPlayerException {
		board = new Board();
		board.setup(2);
		new HumanPlayer("test1", Color.W);
		new HumanPlayer("test2", Color.B);
		
	}
	@Test
	public void howManyColorsInGameTest() {
		assertEquals(2, board.howManyColorsInGame());
	}
	@Test
	public void ColorFinderTest() {
		assertEquals(Color.W, board.colorFinder(8, 2));
		assertEquals(Color.B, board.colorFinder(0, 0));
	}
	
}
