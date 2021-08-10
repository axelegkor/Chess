package sjakk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class LegalMovesTest {
	
	private LegalMoves lm;
	private Main game;
	
	@BeforeEach
	public void setup() {
		lm = new LegalMoves(game);
	}
	
	@Test
	public void testGetLegalMovesOnColor() {
		Move move1 = new Move(1,2,3,4);
		Move move2 = new Move(5,6,7,8);
		Move move3 = new Move(3,1,1,3);
		Move move4 = new Move(7,4,5,2);
		lm.addMoveToLegalWhiteMoves(move1);
		lm.addMoveToLegalWhiteMoves(move2);
		lm.addMoveToLegalBlackMoves(move3);
		lm.addMoveToLegalBlackMoves(move4);
		assertEquals(lm.getAllLegalWhiteMoves(), lm.getLegalMovesOnColor("white"));
		assertEquals(lm.getAllLegalBlackMoves(), lm.getLegalMovesOnColor("black"));
		assertEquals(lm.getAllLegalMoves(), lm.getLegalMovesOnColor("sdf"));
	}
	
	@Test
	public void testEmpty() {
		assertTrue(lm.getAllLegalMoves().isEmpty());
		assertTrue(lm.getAllLegalWhiteMoves().isEmpty());
		assertTrue(lm.getAllLegalBlackMoves().isEmpty());
	}
	
	@Test
	public void testAddMoveToLegalMoves() {
		Move move1 = new Move(1,2,3,4);
		Move move2 = new Move(5,6,7,8);
		Move move3 = new Move(3,1,1,3);
		Move move4 = new Move(7,4,5,2);
		List<Move> moveList1 = Arrays.asList(new Move[]{move1, move2});
		List<Move> moveList2 = Arrays.asList(new Move[]{move3, move4});
		List<Move> moveList3 = Arrays.asList(new Move[] {move1, move2, move3, move4});
		lm.addMoveToLegalWhiteMoves(move1);
		lm.addMoveToLegalWhiteMoves(move2);
		lm.addMoveToLegalBlackMoves(move3);
		lm.addMoveToLegalBlackMoves(move4);
		assertEquals(lm.getAllLegalWhiteMoves(), moveList1);
		assertEquals(lm.getAllLegalBlackMoves(), moveList2);
		assertEquals(lm.getAllLegalMoves(), moveList3);
		}
	
	@Test
	public void testPieceOnBoard() {
		assertTrue(lm.pieceOnBoard(2, 5));
		assertFalse(lm.pieceOnBoard(6, 9));
		assertFalse(lm.pieceOnBoard(8, 5));
		assertTrue(lm.pieceOnBoard(0, 0));
		
	}
	
	
	
	
}
