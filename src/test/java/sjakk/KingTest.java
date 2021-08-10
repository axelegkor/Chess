package sjakk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KingTest {
	
	private King king;
	private Main game;
	private LegalMoves lm;
	
	@BeforeEach
	public void setup() {
		game = new Main();
		lm = new LegalMoves(game);
		king = new King(game, lm);
		
	}
	
	@Test
	public void testWhiteKingMovesStart() {
		game.fromFENToBoard(game.getStartFEN());
		king.getLegalWhiteKingMoves();
		assertTrue(lm.getAllLegalWhiteMoves().isEmpty());
	}
	
	@Test
	public void testGetWhiteKingMoves() {
		game.fromFENToBoard("r3kr2/p1p3pp/B1p5/4Pp2/4b3/2P2P2/P5PP/1RBKR3");
		king.getLegalWhiteKingMoves();
		assertEquals(lm.getAllLegalWhiteMoves().size(), 3);
	}
	
	@Test
	public void testBlackKingMovesStart() {
		game.fromFENToBoard(game.getStartFEN());
		king.getLegalBlackKingMoves();
		assertTrue(lm.getAllLegalBlackMoves().isEmpty());
	}
	
	@Test
	public void testGetBlackKingMoves() {
		game.fromFENToBoard("r3kr2/p1p3pp/B1p5/4Pp2/4b3/2P2P2/P5PP/1RBKR3");
		king.getLegalBlackKingMoves();
		assertEquals(lm.getAllLegalBlackMoves().size(), 4);
	}

}
