package Textris;

public class Tetromino {
    String baseShape;
    String currentShape;
    
    public Tetromino() {
	baseShape = "****";
	currentShape = "*\n*\n*\n*";
    }

    public Tetromino(String s) {
	baseShape = s;
    }

    public String getShape() {
	return currentShape;
    }

    public void rotate() {
	currentShape += "NEW";
    }
}
