package sjakk;

import java.util.ArrayList;
import java.util.List;

public class LegalMoves {
	private List<Move> allLegalMoves = new ArrayList<Move>();
	private List<Move> allLegalWhiteMoves = new ArrayList<Move>();
	private List<Move> allLegalBlackMoves = new ArrayList<Move>();

	private King king;
	private Knight knight;
	private Rook rook;
	private Bishop bishop;
	private Queen queen;
	private Pawn pawn;
	
	public List<Move> getLegalMovesOnColor(String color){
		if (color == "white") {
			return new ArrayList<>(allLegalWhiteMoves);
		}
		else if (color == "black") {
			return new ArrayList<>(allLegalBlackMoves);
		}
		else {
			return new ArrayList<>(allLegalMoves);
		}
	}
	public List<Move> getAllLegalMoves() {
		return new ArrayList<>(allLegalMoves);
	}
	public List<Move> getAllLegalBlackMoves() {
		return new ArrayList<>(allLegalBlackMoves);
	}
	public List<Move> getAllLegalWhiteMoves() {
		return new ArrayList<>(allLegalWhiteMoves);
	}
	

	public void findAllLegalMovesOnColor(String color) {
		allLegalBlackMoves.clear();
		allLegalMoves.clear();
		allLegalWhiteMoves.clear();
		if (color == "white") {
			king.getLegalWhiteKingMoves();
			knight.getLegalWhiteKnightMoves();
			rook.getLegalWhiteRookMoves();
			queen.getLegalWhiteQueenMoves();
			bishop.getLegalWhiteBishopMoves();
			pawn.getLegalWhitePawnMoves();
		}
		else if(color == "black") {
			knight.getLegalBlackKnightMoves();
			rook.getLegalBlackRookMoves();
			bishop.getLegalBlackBishopMoves();
			queen.getLegalBlackQueenMoves();
			pawn.getLegalBlackPawnMoves();
			king.getLegalBlackKingMoves();
		}
	}

	public void findAllLegalMoves() {
		pawn.getLegalBlackPawnMoves();
		pawn.getLegalWhitePawnMoves();
		king.getLegalWhiteKingMoves();
		knight.getLegalWhiteKnightMoves();
		rook.getLegalWhiteRookMoves();
		bishop.getLegalWhiteBishopMoves();
		queen.getLegalWhiteQueenMoves();
		king.getLegalBlackKingMoves();
		knight.getLegalBlackKnightMoves();
		rook.getLegalBlackRookMoves();
		bishop.getLegalBlackBishopMoves();
		queen.getLegalBlackQueenMoves();
	}

	public LegalMoves(Main game) {
		pawn = new Pawn(game,this);
		king = new King(game,this);
		knight =  new Knight(game,this);
		rook = new Rook(game,this);
		bishop = new Bishop(game,this);
		queen = new Queen(game,this);
	}
	
	
	public void addMoveToLegalWhiteMoves(Move move) {
		allLegalWhiteMoves.add(move);
		allLegalMoves.add(move);
	}
	public void addMoveToLegalBlackMoves(Move move) {
		allLegalBlackMoves.add(move);
		allLegalMoves.add(move);
	}
	
	public boolean pieceOnBoard(int x,int y) {
		if (x>=0 && y>=0 && x<=7 && y<=7) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s", allLegalMoves);
	}
	
	
}