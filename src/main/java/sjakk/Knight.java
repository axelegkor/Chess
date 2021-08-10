package sjakk;

public class Knight {
	private final static int[][] knightOfset = new int[][] {{2,1}, {1,2}, {-1,2}, {-2,1}, {-2,-1}, {-1,-2}, {1,-2}, {2,-1}};
	private Main game;
	private LegalMoves lm;
	public Knight(Main game,LegalMoves legalMoves) {
		this.game = game;
		this.lm = legalMoves;
	}
	public void getLegalWhiteKnightMoves() {
		for (int y = 0; y < game.getHeight(); y++) {
			for (int x = 0; x < game.getWidth(); x++) {
				if (game.getSquare(x, y).getType() == 'N') {
					for (int[] ofset : knightOfset) {
						if (lm.pieceOnBoard(x+ofset[0],y+ofset[1])) {
							if (game.getSquare(x+ofset[0], y+ofset[1]).isEmpty() || game.getSquare(x+ofset[0], y+ofset[1]).isBlackPiece()) {
								lm.addMoveToLegalWhiteMoves(new Move(x,y,x+ofset[0], y+ofset[1]));
							}
						}
					}
				}
			}
		}
	}
	public void getLegalBlackKnightMoves() {
		for (int y = 0; y < game.getHeight(); y++) {
			for (int x = 0; x < game.getWidth(); x++) {
				if (game.getSquare(x, y).getType() == 'n') {
					for (int[] ofset : knightOfset) {
						if (lm.pieceOnBoard(x+ofset[0],y+ofset[1])) {
							if (game.getSquare(x+ofset[0], y+ofset[1]).isEmpty() || game.getSquare(x+ofset[0], y+ofset[1]).isWhitePiece()) {
								lm.addMoveToLegalBlackMoves(new Move(x,y,x+ofset[0], y+ofset[1]));
							}
						}
					}
				}
			}
		}
	}
}
