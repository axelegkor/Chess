package sjakk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
	
	private Main main;
	
	@BeforeEach
	public void setup() {
		main = new Main();
	}
	
	@Test
	public void testHeight() {
		assertEquals(main.getHeight(), 8);
	}
	
	@Test
	public void testWidth() {
		assertEquals(main.getWidth(), 8);
	}
	
	@Test
	public void testFromFENToBoard() {
		main.fromFENToBoard("r1b1kb1r/pp3p1p/2p2p2/8/5B2/8/PPP2PPP/R3KB1R");
		assertEquals(main.getSquare(4, 0).getType(), 'k');
		assertEquals(main.getSquare(2, 1).getType(), ' ');
		assertEquals(main.getSquare(5, 2).getType(), 'p');
		assertEquals(main.getSquare(5, 4).getType(), 'B');
		assertEquals(main.getSquare(2, 5).getType(), ' ');
	}
	
	@Test
	public void testFromBoardToFEN() {
		String FEN = "r1b1kb1r/pp3p1p/2p2p2/8/5B2/8/PPP2PPP/R3KB1R";
		main.fromFENToBoard(FEN);
		assertEquals(main.fromBoardToFEN(), FEN);
	}
	
	@Test
	public void testSetFEN() {
		assertEquals(main.getCurrentFEN(), "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
		main.setCurrentFEN("sdljdsølfj");
		assertEquals(main.getCurrentFEN(),"sdljdsølfj" );
	}	
}
