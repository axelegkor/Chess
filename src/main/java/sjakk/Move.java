package sjakk;

public class Move {
	private int fromX;
	private int fromY;
	private int toX;
	private int toY;
	
	public Move(int fromX, int fromY, int toX, int toY) {
		this.fromX = fromX;
		this.fromY = fromY;
		this.toX = toX;
		this.toY = toY;
	}
	
	public int getFromX() {
		return fromX;
	}
	public int getFromY() {
		return fromY;
	}
	public int getToX() {
		return toX;
	}
	public int getToY() {
		return toY;
	}
	@Override
	public String toString() {
		return String.format("(%s,%s) -> (%s,%s)", fromX, fromY, toX, toY);
	}
	
	public static void main(String[] args) {
		Move moves = new Move(2,2,4,4);
		System.out.println(moves);
	}
}