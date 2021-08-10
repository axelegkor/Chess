package sjakk;

public class Koordinater {
	private int x;
	private int y;
	
	public Koordinater(int x, int y) {
	this.x = x;
	this.y = y;	
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %s)", x, y);
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
