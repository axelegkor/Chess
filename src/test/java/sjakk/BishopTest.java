package sjakk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BishopTest {
	
	private Bishop bishop;
	private Main game;
	private LegalMoves lm;
	
	@BeforeEach
	public void setup() {
		game = new Main();
		lm = new LegalMoves(game);
		bishop = new Bishop(game, lm);
		
	}
	
	@Test
	public void testWhiteBishopMovesStart() {
		game.fromFENToBoard(game.getStartFEN());
		bishop.getLegalWhiteBishopMoves();
		assertTrue(lm.getAllLegalWhiteMoves().isEmpty());
	}
	
	@Test
	public void testGetWhiteBishopMoves() {
		game.fromFENToBoard("r3kr2/p1p3pp/B1p5/4Pp2/4b3/2P2P2/P5PP/1RBKR3");
		bishop.getLegalWhiteBishopMoves();
		assertEquals(lm.getAllLegalWhiteMoves().size(), 14);
	}
	
	@Test
	public void testGetWhiteBishopMovesNone() {
		game.fromFENToBoard("Q5n1/8/2n5/4Nk2/2K5/2N5/5q2/8");
		bishop.getLegalWhiteBishopMoves();
		assertTrue(lm.getAllLegalWhiteMoves().isEmpty());
	}
	
	@Test
	public void testBlackBishopMovesStart() {
		game.fromFENToBoard(game.getStartFEN());
		bishop.getLegalBlackBishopMoves();
		assertTrue(lm.getAllLegalBlackMoves().isEmpty());
	}
	
	@Test
	public void testGetBlackBishopMoves() {
		game.fromFENToBoard("r3kr2/p1p3pp/B1p5/4Pp2/4b3/2P2P2/P5PP/1RBKR3");
		bishop.getLegalBlackBishopMoves();
		assertEquals(lm.getAllLegalBlackMoves().size(), 5);
	}
	
	@Test
	public void testGetBlackBishopMovesNone() {
		game.fromFENToBoard("Q5n1/8/2n5/4Nk2/2K5/2N5/5q2/8");
		bishop.getLegalBlackBishopMoves();
		assertTrue(lm.getAllLegalBlackMoves().isEmpty());
	}

}
