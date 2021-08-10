package sjakk;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Main {
	private static final int width = 8;
	private static final int height = 8;
	private Square[][] board;
	private static final String StartFEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
	private String currentFEN = StartFEN;
	private char type;
	private int size = 400;
	private int ruter = 8;
	private int squareSize = size/ruter;
	private int oldX;
	private int oldY;
	private String currentPlayer;
	private boolean active = true;
	private Text whiteWonText = new Text();
	private Text blackWonText = new Text();
	
	public void hideWhiteWonText() {
		whiteWonText.setVisible(false);
	}
	
	public void hideBlackWonText() {
		blackWonText.setVisible(false);
	}
	
	public void winTextWhite(Pane pane) {
	    whiteWonText.setText("White wins!");
	    whiteWonText.setFill(Color.GREEN);
	    whiteWonText.setStyle("-fx-font-size: 35px;");
	    whiteWonText.setTranslateX(((double) getWidth() * 20) + 250);
	    whiteWonText.setTranslateY(((double) getHeight() * 20) / 2);
	    pane.getChildren().add(whiteWonText);
	    whiteWonText.setVisible(true);
	}
	
	public void winTextBlack(Pane pane) {
	    blackWonText.setText("Black wins!");
	    blackWonText.setFill(Color.GREEN);
	    blackWonText.setStyle("-fx-font-size: 35px;");
	    blackWonText.setTranslateX(((double) getWidth() * 20) + 252);
	    blackWonText.setTranslateY(((double) getHeight() * 20) / 2);
	    pane.getChildren().add(blackWonText);
	    blackWonText.setVisible(true);
	}
	
	
	public boolean isWhiteWon() {
		return !currentFEN.contains("k");
	}
	
	public boolean isBlackWon() {
		return !currentFEN.contains("K");
	}

	public int getHeight() {
		return height;
	}

	
	public int getWidth() {
		return width;
	}
	
	public Main() {
		this.currentPlayer = "white";
		this.board = new Square[height][width];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				board[y][x] = new Square(x, y);
			}	
		}
	}
	public Square getSquare(int x, int y) {
		return board[y][x];
	}
	public void fromFENToBoard(String FEN) {
		String[] lst = FEN.split(" ");
		String[] position = lst[0].split("/");
		int n = 0;
		int k = 0;
		for (String pos : position) {
			for (int i = 0; i < pos.length(); i++) {
				if (Character.isDigit(pos.charAt(i))) {
					k += Character.getNumericValue(pos.charAt(i))-1;
				}
				else if (pos.charAt(i) == 'r') {
					getSquare(i+k, n).setBlackRook();
				}
				else if (pos.charAt(i) == 'R') {
					getSquare(i+k, n).setWhiteRook();
				}
				else if (pos.charAt(i) == 'P') {					
					getSquare(i+k, n).setWhitePawn();
				}
				else if (pos.charAt(i) == 'p') {
					getSquare(i+k, n).setBlackPawn();
				}
				else if (pos.charAt(i) == 'Q') {
					getSquare(i+k, n).setWhiteQueen();
				}
				else if (pos.charAt(i) == 'q') {
					getSquare(i+k, n).setBlackQueen();
				}
				else if (pos.charAt(i) == 'K') {
					getSquare(i+k, n).setWhiteKing();
				}
				else if (pos.charAt(i) == 'k') {
					getSquare(i+k, n).setBlackKing();
				}
				else if (pos.charAt(i) == 'N') {
					getSquare(i+k, n).setWhiteKnight();
				}
				else if (pos.charAt(i) == 'n') {
					getSquare(i+k, n).setBlackKnight();
				}
				else if (pos.charAt(i) == 'B') {
					getSquare(i+k, n).setWhiteBishop();
				}
				else if (pos.charAt(i) == 'b') {
					getSquare(i+k, n).setBlackBishop();
				}
			}
			k = 0;
			n+=1;
		}
	}
	
	public String fromBoardToFEN() {
		String FEN = "";
		int n = 0;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (getSquare(x,y).getType() == ' ') {
					n+=1;
				}
				else if (getSquare(x,y).getType() != ' ' && n > 0) {
						FEN += String.valueOf(n);
						FEN += getSquare(x, y);
						n=0;
				}
				else if (getSquare(x,y).getType() != ' ' && n==0) {
					FEN += getSquare(x, y);
					}
				}
			if (n>0) {
				FEN += String.valueOf(n);
				n=0;
			}
			if (y<7) {
				FEN += "/";
			}
		}
		
	return FEN;
	}
	
	public void setCurrentFEN(String currentFEN) {
		this.currentFEN = currentFEN;
	}
	public String getCurrentFEN() {
		return currentFEN;
	}

	public String getStartFEN() {
		return StartFEN;
	}
	

	public String getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(String currentPlayer) {
		if (!(currentPlayer.equals("white") || currentPlayer.equals("black"))) {
			throw new IllegalArgumentException("Player must be white or black");
		} else {
			this.currentPlayer = currentPlayer;
		}
	}
	
	private void makeMove(Move move) {
		type = getSquare(move.getFromX(), move.getFromY()).getType();
		getSquare(move.getToX(), move.getToY()).setEmpty();
		getSquare(move.getToX(), move.getToY()).setType(type);
		getSquare(move.getFromX(), move.getFromY()).setEmpty();
		setCurrentFEN(fromBoardToFEN());
		fromFENToBoard(getCurrentFEN());
		if (getCurrentPlayer().equals("white")) {
			setCurrentPlayer("black");
		}
		else {
			setCurrentPlayer("white");
		}
					
	}
	
	private void pressed(MouseEvent event, Piece p, Rectangle[][] grid) {
		if (active) {
		oldX = (int)(p.getX()+squareSize/2)/squareSize;
		oldY = (int)(p.getY()+squareSize/2)/squareSize;
		LegalMoves lm = new LegalMoves(this);
		lm.findAllLegalMovesOnColor(this.getCurrentPlayer());
		for (Move move : lm.getAllLegalMoves()) {
			if (sameKoordinater(new Koordinater(oldX,oldY),new Koordinater(move.getFromX(),move.getFromY()))) {
				grid[move.getToX()][move.getToY()].setFill(Color.GREEN);
			}
		}
		} else {
			System.out.println("Game is over, you may start a new game");
			throw new IllegalArgumentException("Game is over, you may start a new game");
		}
	}
	
	private void dragged(MouseEvent event, Piece p) {
		boolean yourTurn;
		if (getSquare(oldX, oldY).isWhitePiece() && getCurrentPlayer().equals("white")) {
			yourTurn = true;
		} else if(getSquare(oldX, oldY).isBlackPiece() && getCurrentPlayer().equals("black")) {
			yourTurn = true;
		} else {
			yourTurn = false;
		}
		if(yourTurn && active) {
		p.setX(event.getX()-squareSize/2);
		p.setY(event.getY()-squareSize/2);
		p.draw();
		}
	}
	
	private void released(MouseEvent event, Piece p, Rectangle[][] grid, Pane pane) {
		LegalMoves lm = new LegalMoves(this);
		lm.findAllLegalMoves();
		for (int y = 0; y < this.getHeight(); y++) {
			for (int x = 0; x < this.getWidth(); x++) {
				grid[x][y].setFill(Color.TRANSPARENT);
			}
		}
		int gridx = (int)(p.getX()+squareSize/2)/squareSize;
		int gridy = (int)(p.getY()+squareSize/2)/squareSize;
		
		Move mv = new Move(oldX, oldY, gridx, gridy);
		boolean canMove = false;
		
		for (Move Move : lm.getLegalMovesOnColor(getCurrentPlayer())) {
			if (sameProperties(Move, mv)) {
				canMove = true;
			}
		}
		if (canMove && active) {
			getSquare(gridx, gridy).setEmpty();
			makeMove(mv);
			canMove = false;
			p.setX(squareSize*gridx);
			p.setY(squareSize*gridy);
		} else {
			p.setX(squareSize*oldX);
			p.setY(squareSize*oldY);
		}
		p.draw();
		drawBoard(this, pane, grid);
	}
	
	private final static boolean sameKoordinater(Koordinater k1, Koordinater k2) {
		if (k1.getX() == k2.getX() && k1.getY() == k2.getY()) {
			return true;
		}
		else {
			return false;
		}
	}
	private final static boolean sameProperties(Move mv1, Move mv2) {
		if (mv1.getToX() == mv2.getToX() && mv1.getToY() == mv2.getToY() && mv1.getFromX() == mv2.getFromX() && mv1.getFromY() == mv2.getFromY()) {
			return true;
		}
		else {
			return false;
		}
	}
	
    private void setBackground(Pane pane) {
		Image brett = new Image(getClass().getResourceAsStream("bilder/sjakkbrett.png"));
		ImageView brettView = new ImageView(brett);
		brettView.setFitHeight(size);
		brettView.setFitWidth(size);
		pane.getChildren().add(brettView);
	}
    
    public void clearBoard() {
    	for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				getSquare(x, y).setEmpty();
			}
		}
    }
	
    public void drawBoard(Main game, Pane pane, Rectangle[][] grid) {
		setBackground(pane);
		fromFENToBoard(getCurrentFEN());
		
		for (int i = 0; i < size; i+=squareSize) {
			for (int j = 0; j < size; j+=squareSize) {
				Rectangle r = new Rectangle(i,j,squareSize,squareSize);
				grid[i/squareSize][j/squareSize] = r;
				grid[i/squareSize][j/squareSize].setFill(Color.TRANSPARENT);
				r.setStroke(Color.BLACK);
				pane.getChildren().add(r);
			}
		}
		if (isWhiteWon()) {
			winTextWhite(pane);
		}
		if (isBlackWon()) {
			winTextBlack(pane);
		}
	    
	    active = !(isWhiteWon() || isBlackWon());
		
		List<Piece> pieces = new ArrayList<Piece>();
		for (int y = 0; y < ruter; y++) {
			for (int x = 0; x<ruter;x++) {
				if (!game.getSquare(x, y).isEmpty()) {
					String path2 = getImagePath(getSquare(x, y));
					Image img = new Image(getClass().getResourceAsStream(path2));
					ImageView imv = new ImageView();
					imv.setImage(img);
					int xpos = x*squareSize;
					int ypos = y*squareSize;
					
					Piece p = new Piece(xpos, ypos, imv);
					pieces.add(p);
					
					imv.setOnMousePressed(event -> pressed(event, p, grid));
					imv.setOnMouseDragged(event -> dragged(event, p));
					imv.setOnMouseReleased(event -> released(event, p, grid, pane));
					pane.getChildren().add(imv);
					p.draw();
				}
			}
		}
	}
	
	private String getImagePath(Square square) {
		if (square.getType()=='B') {
			return "bilder/wbishop.png";
		}
		else if (square.getType()=='b') {
			return "bilder/bbishop.png";
		}
		else if (square.getType()=='P') {
			return "bilder/wpawn.png";
		}
		else if (square.getType()=='p') {
			return "bilder/bpawn.png";
		}
		else if (square.getType()=='R') {
			return "bilder/wrook.png";
		}
		else if (square.getType()=='r') {
			return "bilder/brook.png";
		}
		else if (square.getType()=='n') {
			return "bilder/bknight.png";		
		}
		else if (square.getType()=='N') {
			return "bilder/wknight.png";
		}
		else if (square.getType()=='k') {
			return "bilder/bking.png";
		}
		else if (square.getType()=='K') {
			return "bilder/wking.png";
		}
		else if (square.getType()=='Q') {
			return "bilder/wqueen.png";
		}
		else if (square.getType()=='q') {
			return "bilder/bqueen.png";
		}
		else {
			return "bilder/bqueen.png";
		}
	}
	
	@Override
	public String toString() {
		String boardString = "";
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				boardString += getSquare(x, y);
			}
			boardString += "\n";
		}
		return boardString;
	}
}
