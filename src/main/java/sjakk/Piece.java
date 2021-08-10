package sjakk;

import javafx.scene.image.ImageView;

public class Piece {
	private double x;
	private double y;
	private ImageView img;
	
	public Piece(double x, double y, ImageView img) {
		this.x = x;
		this.y = y;
		this.img = img;
	}
	
	public void setX(double x){
		this.x = x;
	}
	public void setY(double y){
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public ImageView getImg() {
		return img;
	}
	public void draw() {
		img.setX(x);
		img.setY(y);
	}
}

