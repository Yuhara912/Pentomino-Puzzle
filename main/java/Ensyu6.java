
public class Ensyu6 {
	static int SIZE = 8;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]queens = new int[SIZE]; 
		int row = 0;
		search(row,queens);
	}
	
	static void printBoard(int[] queens) {
	    for (int row = 0; row < SIZE; row++) {
	        for (int col = 0; col < SIZE; col++) {
	            System.out.print(
	                queens[row] == col ? "Q " : ". ");
	        }
	        System.out.println();
	    }
	    System.out.println();
	}
	static void search(int row,int[] queens) {
		if(row == SIZE) {
			printBoard(queens);
			return;
		}
		
		for(int i = 0;i < SIZE;i ++) {
			if(isSafe(row,i,queens) == false) {
				continue;
			}
			queens[row] = i; 
			search(row + 1,queens);
		}
	}
	static boolean isSafe(int row,int col, int[] queens) {
		for(int prevRow = 0;prevRow < row; prevRow ++) {
			int prevCol = queens[prevRow];
			if(Math.abs(prevCol - col) == Math.abs(prevRow - row) || prevCol == col) {
				return false;
			} 
		}
		return true;
	}
	
}
