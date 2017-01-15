package Textris;

public class Driver {
    static class StartGame extends Thread {
	String[][] board;
	StartGame(String[][] board) {
	    this.board = board;
	}

	public void checkEmpty() {

	}
	
	public void run() {
	    try {
		for (int i = 0; i < board.length; i++) { // print empty board
		    for (int j = 0; j < board[i].length; j++) {
			Thread.sleep(70);
			System.out.print(board[i][j]);
		    }
		    System.out.println();
		}
		while (board[0].equals("..........") { // this will obvoiusly cause problems
			Tetromino t = new Tetromino(2);
			for (int i = 0; i < board.length; i++) {
			    
			}
	        }
		    System.out.println("Game over");
	    }
	    catch (InterruptedException e) {
		System.out.println(e.getMessage());
	    }
	}
    }
    
    public static void main (String[] args) {
	Tetromino t = new Tetromino();
	System.out.println(t.getShape());

	String[][] board = new String[22][10];
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j] = ".";
	    }
	}



	StartGame s = new StartGame(board);
	s.start();
    }
}
