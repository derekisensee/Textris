package Textris;

public class Tetromino {
    String shape;
    int x = 0;
    int y = 0;
    public Tetromino(int n) {
	if (n == 1) {
	    shape = "****";
	    x = 3;
	    y = 20; // should i hardcode this?
	} else if (n == 2) {
	    shape = "*\n**\n *";
	    x = 4;
	    y = 20;
	} else if (n == 3) {
	    shape = "**\n**";
	    x = 4;
	    y = 20;
	} else if (n == 4) {
	    shape = "*\n**\n*";
	    x = 4;
	    y = 20;
	} else if (n == 5) {
	    shape = "*\n*\n**";
	    x = 4;
	    y = 20;
	}
    }

    public String rotate(String cur, String in) {
	if (cur.equals("****")) { // straight tetro
	    return "*\n*\n*\n*";
	}
        if (cur.equals("*\n*\n*\n*")) {
	    return "****";
	}

	if (cur.equals("**\n**")) { // square tetro
	    return "**\n**";
	}

	if (cur.equals("*\n**\n *") && in.equals("q")) { // stuck-out tetro
	    return " *\n***";
	}
	if (cur.equals(" *\n***") && in.equals("q")) {
	    return " *\n**\n *";
	}
	if (cur.equals(" *\n**\n *") && in.equals("q")) { 
	    return "***\n *";
	}
	if (cur.equals("***\n *") && in.equals("q")) { 
	    return "*\n**\n*";
	}
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
}
