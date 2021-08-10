package sjakk;

public class Bishop {
	
	private final static int[][] bishopOffset = new int[][] {{1,1},{-1,1},{-1,-1},{1,-1}};
	private Main game;
	private LegalMoves lm;
	public Bishop(Main game,LegalMoves legalMoves) {
		this.game = game;
		this.lm = legalMoves;
	}
	public void getLegalWhiteBishopMoves() {
		for (int y = 0; y < game.getHeight(); y++) {
			for (int x = 0; x < game.getWidth(); x++) {
				if (game.getSquare(x, y).getType() == 'B') {
					for (int[] ofset : bishopOffset) {
						for (int i = 1; i < 8; i++) {
							if (lm.pieceOnBoard(x+i*ofset[0],y+i*ofset[1])) {
								if(game.getSquare(x+i*ofset[0], y+i*ofset[1]).isEmpty()) {
									lm.addMoveToLegalWhiteMoves(new Move(x,y,x+i*ofset[0], y+i*ofset[1]));
								}
								else if(game.getSquare(x+i*ofset[0], y+i*ofset[1]).isWhitePiece()) {
									break;
								}
								else if(game.getSquare(x+i*ofset[0], y+i*ofset[1]).isBlackPiece()) {
									lm.addMoveToLegalWhiteMoves(new Move(x,y,x+i*ofset[0], y+i*ofset[1]));
									break;
								}
							}
						}
					}
				}
			}
		}
	}
	public void getLegalBlackBishopMoves() {
		for (int y = 0; y < game.getHeight(); y++) {
			for (int x = 0; x < game.getWidth(); x++) {
				if (game.getSquare(x, y).getType() == 'b') {
					for (int[] ofset : bishopOffset) {
						for (int i = 1; i < 8; i++) {
							if (lm.pieceOnBoard(x+i*ofset[0],y+i*ofset[1])) {
								if(game.getSquare(x+i*ofset[0], y+i*ofset[1]).isEmpty()) {
									lm.addMoveToLegalBlackMoves(new Move(x,y,x+i*ofset[0], y+i*ofset[1]));
								}
								else if(game.getSquare(x+i*ofset[0], y+i*ofset[1]).isBlackPiece()) {
									break;
								}
								else if(game.getSquare(x+i*ofset[0], y+i*ofset[1]).isWhitePiece()) {
									lm.addMoveToLegalBlackMoves(new Move(x,y,x+i*ofset[0], y+i*ofset[1]));
									break;
								}
							}
						}
					}
				}
			}
		}
	}
}
