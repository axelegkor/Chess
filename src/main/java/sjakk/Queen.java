package sjakk;

public class Queen {
	private final static int[][] queenOffset = new int[][] {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
	private Main game;
	private LegalMoves lm;
	public Queen(Main game,LegalMoves legalMoves) {
		this.game = game;
		this.lm = legalMoves;
	}
	public void getLegalWhiteQueenMoves() {
		for (int y = 0; y < game.getHeight(); y++) {
			for (int x = 0; x < game.getWidth(); x++) {
				if (game.getSquare(x, y).getType() == 'Q') {
					for (int[] ofset : queenOffset) {
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
	public void getLegalBlackQueenMoves() {
		for (int y = 0; y < game.getHeight(); y++) {
			for (int x = 0; x < game.getWidth(); x++) {
				if (game.getSquare(x, y).getType() == 'q') {
					for (int[] ofset : queenOffset) {
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
