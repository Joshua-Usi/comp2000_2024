import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

class Grid {

    public int offsetX, offsetY;
    private ArrayList<Cell> cells;

    public Grid(int offsetX, int offsetY, ArrayList<Cell> cells) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.cells = cells;
    }

    public void paint(Graphics g, Point mousePosition) {
        g.translate(offsetX, offsetY);
        // account for offset
        mousePosition.x -= offsetX;
        mousePosition.y -= offsetY;
        for (Cell c : cells) {
            c.paint(g, mousePosition);
        }
        // Move it back to center
        g.translate(-offsetX, -offsetY);
    }
}