package sjakk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {
	private Knight knight;
	private Main game;
	private LegalMoves lm;
	
	@BeforeEach
	public void setup() {
		game = new Main();
		lm = new LegalMoves(game);
		knight = new Knight(game, lm);
	}
	
	@Test
	public void testGetWhiteKnightMovesStart() {
		game.fromFENToBoard(game.getStartFEN());
		knight.getLegalWhiteKnightMoves();
		assertEquals(lm.getAllLegalWhiteMoves().size(), 4);
	}
	
	
	@Test
	public void testGetWhiteKnightMoves() {
		game.fromFENToBoard("Q5n1/8/2n5/4Nk2/2K5/2N5/5q2/8");
		knight.getLegalWhiteKnightMoves();
		assertEquals(lm.getAllLegalWhiteMoves().size(), 15);
	}
	
	
	@Test
	public void testGetWhiteKnightMovesNone() {
		game.fromFENToBoard("r3kr2/p1p3pp/B1p5/4Pp2/4b3/2P2P2/P5PP/1RBKR3");
		knight.getLegalWhiteKnightMoves();
		assertTrue(lm.getAllLegalWhiteMoves().isEmpty());
	}
	
	@Test
	public void testGetBlackKnightMovesStart() {
		game.fromFENToBoard(game.getStartFEN());
		knight.getLegalBlackKnightMoves();
		assertEquals(lm.getAllLegalBlackMoves().size(), 4);
	}

	

	@Test
	public void testGetBlackKnightMoves() {
		game.fromFENToBoard("Q5n1/8/2n5/4Nk2/2K5/2N5/5q2/8");
		knight.getLegalBlackKnightMoves();
		assertEquals(lm.getAllLegalBlackMoves().size(), 11);
	}
	
	@Test
	public void testGetBlackKnightMovesNone() {
		game.fromFENToBoard("r3kr2/p1p3pp/B1p5/4Pp2/4b3/2P2P2/P5PP/1RBKR3");
		knight.getLegalBlackKnightMoves();
		assertTrue(lm.getAllLegalBlackMoves().isEmpty());
		
	}
	

}
