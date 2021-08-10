package sjakk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueenTest {
	
	private Queen queen;
	private Main game;
	private LegalMoves lm;
	
	@BeforeEach
	public void setup() {
		game = new Main();
		lm = new LegalMoves(game);
		queen = new Queen(game, lm);
		
	}
	
	@Test
	public void testWhiteQueenMovesStart() {
		game.fromFENToBoard(game.getStartFEN());
		queen.getLegalWhiteQueenMoves();
		assertTrue(lm.getAllLegalWhiteMoves().isEmpty());
	}
	
	@Test
	public void testGetWhiteQueenMoves() {
		game.fromFENToBoard("Q5n1/8/2n5/4Nk2/2K5/2N5/5q2/8");
		queen.getLegalWhiteQueenMoves();
		assertEquals(lm.getAllLegalWhiteMoves().size(), 15);
	}
	
	@Test
	public void testGetWhiteQueenMovesNone() {
		game.fromFENToBoard("r3kr2/p1p3pp/B1p5/4Pp2/4b3/2P2P2/P5PP/1RBKR3");
		queen.getLegalWhiteQueenMoves();
		assertTrue(lm.getAllLegalWhiteMoves().isEmpty());
	}
	
	@Test
	public void testBlackQueenMovesStart() {
		game.fromFENToBoard(game.getStartFEN());
		queen.getLegalBlackQueenMoves();
		assertTrue(lm.getAllLegalBlackMoves().isEmpty());
	}
	
	@Test
	public void testGetBlackQueenMoves() {
		game.fromFENToBoard("Q5n1/8/2n5/4Nk2/2K5/2N5/5q2/8");
		queen.getLegalBlackQueenMoves();
		assertEquals(lm.getAllLegalBlackMoves().size(), 19);
	}
	
	@Test
	public void testGetBlackQueenMovesNone() {
		game.fromFENToBoard("r3kr2/p1p3pp/B1p5/4Pp2/4b3/2P2P2/P5PP/1RBKR3");
		queen.getLegalBlackQueenMoves();
		assertTrue(lm.getAllLegalBlackMoves().isEmpty());
	}

}
