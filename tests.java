import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class tests {
	
	@Test
	void testBishopsOppositeColors() {
		Board b = new Board();
		b.initialiseBoard(true);
		Cell[][] squares = b.squares;
		
		int first = -1;
		for(int i=1;i<9;i++) {
			if(squares[8][i].getPieceId() == "BISHOP") {
				if(first == -1) {
					first = i%2;
				}
				else {
					if(first == i%2) {
						assertTrue(false);
					}
				}
			}
		}
		assertTrue(true);
	}
	
	@Test
	void testKingBetweenRooks(){
		Board b = new Board();
		b.initialiseBoard(true);
		Cell[][] squares = b.squares;
		
		boolean rook = false;
		for(int i=1;i<9;i++) {
			String str = squares[8][i].getPieceId();
			if(str == "ROOK" && rook == false) {
				rook = true;
			}
			else if(str == "KING" && rook == true) {
				assertTrue(true);
				break;
			}
			else if(str == "KING" && rook == false) {
				assertTrue(false);
			}
			else if(str == "ROOK" && rook == true) {
				assertTrue(false);
			}
		}
		
	}
	
	@Test
	void testWhiteAndBlackOpposite(){
		Board b = new Board();
		b.initialiseBoard(true);
		Cell[][] squares = b.squares;
		for(int i=1;i<9;i++) {
			String strw = squares[8][i].getPieceId();
			String strb = squares[1][i].getPieceId();
			if(strw != strb) {
				assertTrue(false);
			}
		}
		assertTrue(true);
	}
	
	@Test
	void testTraditional(){
		Board b = new Board();
		b.initialiseBoard(false);
		Cell[][] squares = b.squares;
		String[] trad = {"ROOK", "KNIGHT", "BISHOP", "QUEEN", "KING", "BISHOP", "KNIGHT", "ROOK"};
		for(int i=1;i<9;i++) {
			String str = squares[8][i].getPieceId();
			if(str != trad[i-1]) {
				assertTrue(false);
			}
		}
		assertTrue(true);
	}
	
	@Test
	void testNotTraditional(){
		Board b = new Board();
		b.initialiseBoard(true);
		Cell[][] squares = b.squares;
		String[] trad = {"ROOK", "KNIGHT", "BISHOP", "QUEEN", "KING", "BISHOP", "KNIGHT", "ROOK"};
		int num = 0;
		for(int i=1;i<9;i++) {
			String str = squares[8][i].getPieceId();
			if(str == trad[i-1]) {
				num += 1;
			}
		}
		if(num == 8) {
			assertTrue(false);
		}
		assertTrue(true);
	}
}
