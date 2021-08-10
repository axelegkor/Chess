package sjakk;

public class Square {
	private char type = ' ';
    private int x;
    private int y;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
		return x;
	}
    public int getY() {
		return y;
	}
    
    public void setWhiteBishop() {
        type = 'B';
    }
    public void setBlackBishop() {
        type = 'b';
    }

    public void setWhiteKing() {
        type = 'K';
    }
    public void setBlackKing() {
        type = 'k';
    }
    public void setWhiteQueen() {
        type = 'Q';
    }

    public void setBlackQueen() {
        type = 'q';
    }

    public void setWhiteKnight() {
        type = 'N';
    }
    public void setBlackKnight() {
        type = 'n';
    }
    public void setWhitePawn() {
        type = 'P';
    }

    public void setBlackPawn() {
        type = 'p';
    }
    public void setWhiteRook() {
        type = 'R';
    }
    public void setBlackRook() {
        type = 'r';
    }
 
    public void setEmpty() {
    	type = ' ';
    }
    public void setType(char type) {
    	if (!(type == 'p' || type == 'r' || type == 'n'|| type == 'b'|| type == 'q'|| type == 'k' || type == 'P' || type == 'R' || type == 'N'|| type == 'B'|| type == 'Q'|| type == 'K')) {
    		throw new IllegalArgumentException("Invalid type");
    	} else {
    		this.type = type;
    	}
    }
    
    public boolean isEmpty() {
    	if (type == ' ') {
    		return true;
    	}
    	return false;
    }
    
  
    @Override
    public String toString() {
        return Character.toString(getType());
    }
    
    public boolean isBlackPiece(){
    	if (this.type == 'p' || this.type == 'r' ||this.type == 'n'|| this.type == 'b'|| this.type == 'q'|| this.type == 'k') {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isWhitePiece(){
    	if (this.type == 'P' || this.type == 'R' ||this.type == 'N'|| this.type == 'B'|| this.type == 'Q'|| this.type == 'K') {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
	public char getType() {
		return type;
	}
}
