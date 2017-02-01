package Textris;
import java.util.*;
import java.io.*;
public class Driver {
    static class StartGame extends Thread {
        String[][] board;

        StartGame(String[][] board) {
            this.board = board;
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
                while (!(board[0][4].equals("#"))) { // this will obvoiusly cause problems. or will it?
                    Tetromino t = new Tetromino((int)(Math.random() * 4 + 1)); // this just works okay
                    while (t.getY() < 22) { // while the tetro hasn't reached the "current" bottom of the screen. will have to correct this.
                        int y = t.getX();
                        int currY = y;
                        int x = t.getY();
                        int currX = x;

                        String[] chopped = t.getShape().split("A"); // have to include a clause for shapes without A's

                        if (t.getShape().equals("****") && (t.getBottom() == 21 || (t.getBottom() < 20 && board[t.getBottom() + 1][y].equals("#")))) { // i know this is super hacky and it will get fixed at a later point in time
                            boolean tripped = false;
                            if ((t.getBottom() < 20 && board[t.getBottom() + 1][y].equals("#"))) {
                                tripped = true;
                                for (int i = 0; i < board.length - 1; i++) {
                                    for (int j = 0; j < board[0].length; j++) {
                                        if (board[i][j].equals("*")) {
                                            board[i + 1][j] = "#";
                                        }
                                    }
                                    System.out.println();
                                }
                                for (int i = 0; i < board.length; i++) { // clears Tetro's previous spot
                                    for (int j = 0; j < board[0].length; j++) {
                                        if (!(board[i][j].equals("#"))) {
                                            board[i][j] = ".";
                                        }
                                    }
                                }
                            }
                            if (!tripped) { // if the bottom of the board
                                for (int i = 0; i < board.length; i++) {
                                    for (int j = 0; j < board[0].length; j++) {
                                        if (board[i][j].equals("*")) {
                                            board[i][j] = "#";
                                        }
                                    }
                                    System.out.println();
                                }
                            }
                            System.out.println("----------");
                            for (int i = 0; i < board.length; i++) {
                                for (int j = 0; j < board[0].length; j++) {
                                    System.out.print(board[i][j]);
                                }
                                System.out.println();
                            }
                            t = new Tetromino((int)(Math.random() * 4 + 1));
                        } else if (!(t.getShape().equals("****")) && ((t.getBottom() < 20 && board[t.getBottom() + 1][y].equals("#")) || t.getBottom() == 19)) { // 19 is causing weird behavior
                            // if we reach the bottom of the board or if we hit another piece once the thread goes. dumb hacks included.
                            for (int i = 0; i < board.length; i++) {
                                for (int j = 0; j < board[0].length; j++) {
                                    if (board[i][j].equals("*")) {
                                        board[i][j] = "#";
                                    }
                                }
                                System.out.println();
                            }

                            System.out.println("----------");
                            for (int i = 0; i < board.length; i++) {
                                for (int j = 0; j < board[0].length; j++) {
                                    System.out.print(board[i][j]);
                                }
                                System.out.println();
                            }
                            t = new Tetromino((int)(Math.random() * 4 + 1));
                        } else { // here we keep moving if we haven't touched another piece
                            System.out.println("!!!!!!!!!!!!" + t.getBottom());

                            String input = in.nextLine();

                            if (input.equals("a")) {
                                t.decX();
                            }
                            if (input.equals("d")) {
                                t.incX();
                            }

                            for (int i = 0; i < board.length; i++) { // clears Tetro's previous spot
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
                            System.out.println("----------");
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
                System.out.println("LOSER!");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        String[][] board = new String[21][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ".";
            }
        }

        StartGame s = new StartGame(board);
        s.start();
    }

}
