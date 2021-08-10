package sjakk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {
	
	private Pawn pawn;
	private Main game;
	private LegalMoves lm;
	
	@BeforeEach
	public void setup() {
		game = new Main();
		lm = new LegalMoves(game);
		pawn = new Pawn(game, lm);
		
	}
	
	@Test
	public void testWhitePawnMovesStart() {
		game.fromFENToBoard(game.getStartFEN());
		pawn.getLegalWhitePawnMoves();
		assertEquals(lm.getAllLegalWhiteMoves().size(), 16);
	}
	
	@Test
	public void testGetWhitePawnMoves() {
		game.fromFENToBoard("r3kr2/p1p3pp/B1p5/4Pp2/4b3/2P2P2/P5PP/1RBKR3");
		pawn.getLegalWhitePawnMoves();
		assertEquals(lm.getAllLegalWhiteMoves().size(), 10);
	}
	
	@Test
	public void testGetWhitePawnMovesNone() {
		game.fromFENToBoard("Q5n1/8/2n5/4Nk2/2K5/2N5/5q2/8");
		pawn.getLegalWhitePawnMoves();
		assertTrue(lm.getAllLegalWhiteMoves().isEmpty());
	}
	
	@Test
	public void testBlackPawnMovesStart() {
		game.fromFENToBoard(game.getStartFEN());
		pawn.getLegalBlackPawnMoves();
		assertEquals(lm.getAllLegalBlackMoves().size(), 16);
	}
	
	@Test
	public void testGetBlackPawnMoves() {
		game.fromFENToBoard("r3kr2/p1p3pp/B1p5/4Pp2/4b3/2P2P2/P5PP/1RBKR3");
		pawn.getLegalBlackPawnMoves();
		assertEquals(lm.getAllLegalBlackMoves().size(), 6);
	}
	
	@Test
	public void testGetBlackPawnMovesNone() {
		game.fromFENToBoard("Q5n1/8/2n5/4Nk2/2K5/2N5/5q2/8");
		pawn.getLegalBlackPawnMoves();
		assertTrue(lm.getAllLegalBlackMoves().isEmpty());
	}

}
