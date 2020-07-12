/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

/**
 *
 * @author Batu Budin
 */
public class Mark {
    
    public enum Color {
        B,    // black
        R,   // red
        W,  // white
        Y, // yellow
        O //empty
        }
    
    private int position[][];
    private Color color;
    	
    public int[][] getPosition() {
        return position;
    }
    public void setPosition(int[][] positionRow) {
        this.position = positionRow;
    }
    /**
     * it is a method to set color to the specific location.
     * @param renk
     */
    public void SetColor(Color renk) {
    	this.color = renk;
    }
    /**
     * gets the color for the cell
     * @return the color of the cell
     */
    public Color getColor() {
		return this.color;
    }
    /**
     *
     * @return it gives the color of the mark as string
     */
    public String toString() {
    	return this.color.toString();
    }

 
}
