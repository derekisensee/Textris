package Textris;
import java.util.Scanner;
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
	        Scanner in = new Scanner(System.in);
            for (int i = 0; i < board.length; i++) { // print empty board
                for (int j = 0; j < board[i].length; j++) {
                //Thread.sleep(70); cute animation
                System.out.print(board[i][j]);
                }
                System.out.println();
            }
            while (board[21][2].equals(".")) { // this will obvoiusly cause problems. or will it?
                Tetromino t = new Tetromino((int)(Math.random() * (5 - 1))); // this just works okay
                while (t.getY() < 21) { // while the tetro hasn't reached the "current" bottom of the screen. will have to correct this.
                    int y = t.getX(); int currY = y;
                    int x = t.getY(); int currX = x;

                    String[] chopped = t.getShape().split("A");

                    if (t.getBottom() == 20 || board[x][t.getBottom()].equals("#")) { // if we reach the bottom of the board
                        for (int i = 0; i < board.length; i++) {
                            for (int j = 0; j < board[0].length; j++) {
                                if (board[i][j].equals("*")) {
                                    board[i][j] = "#";
                                }
                            }
                            System.out.println();
                        }

                        System.out.println("-------------");
                        for (int i = 0; i < board.length; i++) {
                            for (int j = 0; j < board[0].length; j++) {
                                System.out.print(board[i][j]);
                            }
                            System.out.println();
                        }
                        t = new Tetromino((int)(Math.random() * (5 - 1)));
                    }
                    else {
                        for (int i = 0; i < board.length; i++) {
                            for (int j = 0; j < board[0].length; j++) {
                                if (!(board[i][j].equals("#"))) {
                                    board[i][j] = ".";
                                }
                            }
                        }

                        for (int i = 0; i < chopped.length; i++) {
                            String[] splitted = chopped[i].split("");
                            for (int j = 0; j < splitted.length; j++) {
                                if (!(splitted[j].equals(" "))) {
                                    board[currX][currY + j] = splitted[j];
                                }
                                x = currX - 1;
                            }
                            currX++;
                        }

                        Thread.sleep(300);
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
