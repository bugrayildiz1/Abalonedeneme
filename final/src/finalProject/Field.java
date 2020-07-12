package finalProject;

import finalProject.Mark.Color;

public class Field {
    Board board;
    Mark mark;
    int x;
    int y;

    /**
     * this class that stores the location of the cells
     * @param board Board
     * @param x coordinates of the marble
     * @param y coordinates of the marble
     **/
    public Field(Board board, int x, int y) {
        this.x = x;
        this.y = y;
        this.board = board;
        mark = new Mark();
        this.mark.SetColor(Mark.Color.O);
    }
    /**
     * this class that stores the location of the cells
     * @param board Board
     * @param x coordinates of the marble
     * @param y coordinates of the marble
     * @param c is the color you want to define
     **/
    public Field(Board board, int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.board = board;
        mark = new Mark();
        this.mark.SetColor(c);
    }
    /**
     *
     * @return the exact location of the marks
     */
    public Field getField() { 
        return this;
    }

    /**
     * gets mark from the cell
     * @return mark
     */
    public Mark getMark() {
        return this.mark;
    }

    /**
     * sets color for the cell
     * @param w the color which is set for the cell
     */
    public void setMark(Color w) {
        this.mark.SetColor(w);
    }
	
    public String toString() {
        return this.mark.toString();
    }
}
