package sjakk;

public class King {
	private final static int[][] kingOfset = new int[][] {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
	
	private Main game;
	private LegalMoves lm;
	public King(Main game,LegalMoves legalMoves) {
		this.game = game;
		this.lm = legalMoves;
	}
	public void getLegalWhiteKingMoves() {
		for (int y = 0; y < game.getHeight(); y++) {
			for (int x = 0; x < game.getWidth(); x++) {
				if (game.getSquare(x, y).getType() == 'K') {
					for (int[] ofset : kingOfset) {
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
	public void getLegalBlackKingMoves() {
		for (int y = 0; y < game.getHeight(); y++) {
			for (int x = 0; x < game.getWidth(); x++) {
				if (game.getSquare(x, y).getType() == 'k') {
					for (int[] ofset : kingOfset) {
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
