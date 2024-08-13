import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Polygon;

class Actor {
    Cell loc;
    Color color;
    ArrayList<Polygon> shapes;

    Actor(int x, int y, int w, Color color) {
        this.loc = new Cell(x, y, w);
        this.color = color;
        this.shapes = new ArrayList<Polygon>();
    }

    void paint(Graphics g) {
        g.setColor(color);
        for (Polygon p : shapes) {
            g.fillPolygon(p);
        }
    }

}