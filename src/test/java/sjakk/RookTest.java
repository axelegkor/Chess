package sjakk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RookTest {
	
	private Rook rook;
	private Main game;
	private LegalMoves lm;
	
	@BeforeEach
	public void setup() {
		game = new Main();
		lm = new LegalMoves(game);
		rook = new Rook(game, lm);
		
	}
	
	@Test
	public void testGetWhiteRookMovesStart() {
		game.fromFENToBoard(game.getStartFEN());
		rook.getLegalWhiteRookMoves();
		assertTrue(lm.getAllLegalWhiteMoves().isEmpty());
	}
	
	@Test
	public void testGetWhiteRookMoves() {
		game.fromFENToBoard("r3kr2/p1p3pp/B1p5/4Pp2/4b3/2P2P2/P5PP/1RBKR3");
		rook.getLegalWhiteRookMoves();
		assertEquals(lm.getAllLegalWhiteMoves().size(), 14);
	}
	
	@Test
	public void testGetWhiteRookMovesNone() {
		game.fromFENToBoard("Q5n1/8/2n5/4Nk2/2K5/2N5/5q2/8");
		rook.getLegalWhiteRookMoves();
		assertTrue(lm.getAllLegalWhiteMoves().isEmpty());
	}
	
	@Test
	public void testGetBlackRookMovesStart() {
		game.fromFENToBoard(game.getStartFEN());
		rook.getLegalBlackRookMoves();
		assertTrue(lm.getAllLegalBlackMoves().isEmpty());
	}
	
	@Test
	public void testGetBlackRookMoves() {
		game.fromFENToBoard("r3kr2/p1p3pp/B1p5/4Pp2/4b3/2P2P2/P5PP/1RBKR3");
		rook.getLegalBlackRookMoves();
		assertEquals(lm.getAllLegalBlackMoves().size(), 7);
	}
	
	@Test
	public void testGetBlackRookMovesNone() {
		game.fromFENToBoard("Q5n1/8/2n5/4Nk2/2K5/2N5/5q2/8");
		rook.getLegalBlackRookMoves();
		assertTrue(lm.getAllLegalBlackMoves().isEmpty());
	}
	

}
