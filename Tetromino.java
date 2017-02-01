package Textris;

public class Tetromino {
    String shape;
    int x = 0;
    int y = 0;

    public Tetromino(int n) {
        if (n == 1) {
            shape = "****";
            x = 3;
            y = 0; // should i hardcode this?
        } else if (n == 2) {
            shape = "*A**A *";
            x = 4;
            y = 0;
        } else if (n == 3) {
            shape = "**A**";
            x = 4;
            y = 2;
        } else if (n == 4) {
            shape = "*A**A*";
            x = 4;
            y = 2;
        } else if (n == 5) {
            shape = "*A*A**";
            x = 4;
            y = 2;
        }
    }

    public String rotate(String cur, String in) {
        if (cur.equals("****")) { // straight tetro
            return "*A*A*A*";
        }
            if (cur.equals("*A*A*A*")) {
            return "****";
        }

        if (cur.equals("**A**")) { // square tetro
            return "**A**";
        }

        if (cur.equals("*A**A *") && in.equals("q")) { // stuck-out tetro
            return " *A***";
        }
        if (cur.equals(" *A***") && in.equals("q")) {
            return " *A**A *";
        }
        if (cur.equals(" *A**A *") && in.equals("q")) {
            return "***A *";
        }
        if (cur.equals("***A *") && in.equals("q")) {
            return "*A**A*";
        }
        return "****";
    }

    public int getBottom() {
        if (getShape().equals("*A**A *")) {
            return y;
        }
        if (getShape().equals("****")) {
            return y;
        }
        if (getShape().equals("**A**")) {
            return y;
        }
        if (getShape().equals("*A**A*")) {
            return y + 1;
        }
        return y;
    }
	    
    public String getShape() {
	return shape;
    }

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    public void incX() {
	x++;
    }

    public void incY() {
	y++;
    }

    public void decX() {
	x--;
    }

    public void decY() {
	y--;
    }
}