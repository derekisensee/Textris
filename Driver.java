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
			//Thread.sleep(70);
			System.out.print(board[i][j]);
		    }
		    System.out.println();
		}
		while (board[21][2].equals(".")) { // this will obvoiusly cause problems. or will it
			Tetromino t = new Tetromino(2);
			while (t.getY() < 21) {
			    int y = t.getX();
			    int x = t.getY();
			    String[] chopped = t.getShape().split("A");
			    for (int i = 0; i < chopped.length; i++) {
				String[] currLine = chopped[i].split("");
				for (int j = 0; j < currLine.length; j++) {
				    board[x][y] = "."; // we aren't printing correctly here
				    board[x + j][y] ="*";
				}
				
			    }
			    Thread.sleep(1500);
			    System.out.println("-------------");
			    for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
				    System.out.print(board[i][j]);
				}
				System.out.println();
			    }
			    t.incY();
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
