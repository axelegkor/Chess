package sjakk;

public class Pawn {
	private final static int[][] whitePawnInitialOffset = new int[][] {{0,-2}};
	private final static int[][] blackPawnInitialOffset = new int[][] {{0,2}};
	private final static int[][] whitePawnTakeOffset = new int[][] {{1,-1},{-1,-1}};
	private final static int[][] blackPawnTakeOffset = new int[][] {{1,1},{-1,1}};
	private final static int[][] whitePawnOffset = new int[][] {{0,-1}};
	private final static int[][] blackPawnOffset = new int[][] {{0,1}};

	private Main game;
	private LegalMoves lm;
	public Pawn(Main game,LegalMoves legalMoves) {
		this.game = game;
		this.lm = legalMoves;
	}
	public void getLegalWhitePawnMoves() {
		for (int y = 0; y < game.getHeight(); y++) {
			for (int x = 0; x < game.getWidth(); x++) {
				if (game.getSquare(x, y).getType() == 'P') {
					if(y==6) {
						for (int[] offset : whitePawnInitialOffset) {
							if (lm.pieceOnBoard(x+offset[0],y+offset[1])) {
								if (game.getSquare(x+offset[0], y+offset[1]).isEmpty() && game.getSquare(x, y-1).isEmpty()) {
									lm.addMoveToLegalWhiteMoves(new Move(x,y,x+offset[0], y+offset[1]));
								}
							}
						}
					}
						for (int[] offset : whitePawnOffset) {
							if (lm.pieceOnBoard(x+offset[0],y+offset[1])) {
								if (game.getSquare(x+offset[0], y+offset[1]).isEmpty()) {
									lm.addMoveToLegalWhiteMoves(new Move(x,y,x+offset[0], y+offset[1]));
								}
							}
						}
					
					for (int[] offset : whitePawnTakeOffset) {
						if (lm.pieceOnBoard(x+offset[0],y+offset[1])) {
							if (game.getSquare(x+offset[0], y+offset[1]).isBlackPiece()) {
								lm.addMoveToLegalWhiteMoves(new Move(x,y,x+offset[0], y+offset[1]));
							}
						}
					}
				}
			}
		}
	}
	public void getLegalBlackPawnMoves() {
		for (int y = 0; y < game.getHeight(); y++) {
			for (int x = 0; x < game.getWidth(); x++) {
				if (game.getSquare(x, y).getType() == 'p') {
					if(y==1) {
						for (int[] offset : blackPawnInitialOffset) {
							if (lm.pieceOnBoard(x+offset[0],y+offset[1])) {
									if (game.getSquare(x+offset[0], y+offset[1]).isEmpty() && game.getSquare(x, y+1).isEmpty()) {
										lm.addMoveToLegalBlackMoves(new Move(x,y,x+offset[0], y+offset[1]));
								}
							}
						}
					}
						for (int[] offset : blackPawnOffset) {
							if (lm.pieceOnBoard(x+offset[0],y+offset[1])) {
								if (game.getSquare(x+offset[0], y+offset[1]).isEmpty()) {
									lm.addMoveToLegalBlackMoves(new Move(x,y,x+offset[0], y+offset[1]));
								}
							}
						}
					for (int[] offset : blackPawnTakeOffset) {
						if (lm.pieceOnBoard(x+offset[0],y+offset[1])) {
							if (game.getSquare(x+offset[0], y+offset[1]).isWhitePiece()) {
								lm.addMoveToLegalBlackMoves(new Move(x,y,x+offset[0], y+offset[1]));
							}
						}
					}
				}
			}
		}
	}
}
