package sjakk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {
	
	private Move moves;
	
	@BeforeEach
	public void setup() {
		moves = new Move(6, 2, 3, 5);
	}
	
	@Test
	public void testGetFromX() {
		assertEquals(moves.getFromX(), 6);
	}
	
	@Test
	public void testGetFromY() {
		assertEquals(moves.getFromY(), 2);
	}
	
	@Test
	public void testGetToX() {
		assertEquals(moves.getToX(), 3);
	}
	
	@Test
	public void testGetToY() {
		assertEquals(moves.getToY(), 5);
	}
	
	@Test
	public void testToString() {
		assertEquals(moves.toString(), "(6,2) -> (3,5)");
	}
	

}
