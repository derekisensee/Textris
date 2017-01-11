package Textris;

public class Tetromino {
    String baseShape;
    String currentShape;
    
    public Tetromino() {
	baseShape = "****";
    }

    public Tetromino(String s) {
	baseShapeshape = s;
    }

    public String getShape() {
	return currentShape;
    }

    public String rotate() {
	
    }
}
