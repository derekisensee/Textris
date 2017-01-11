package Textris;

import java.util.Scanner;

public class Driver {
    public static void main (String[] args) {
	Scanner in = new Scanner(System.in);
	Tetromino t = new Tetromino();
	System.out.println(t.getShape());
	if (in.next().equals("a")) {
		t.rotate();
	}
	System.out.println(t.getShape());
	
    }
}
