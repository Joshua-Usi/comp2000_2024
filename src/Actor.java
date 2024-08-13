import java.awt.Color;
import java.awt.Graphics;

class Actor {
    Cell loc;
    Color color;

    Actor(int x, int y, int w, Color color) {
        this.loc = new Cell(x, y, w);
        this.color = color;
    }

    void paint(Graphics g) {
        // Unpainted
    }
}