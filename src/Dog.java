import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

class Dog extends Actor {
    Dog(int x, int y, int w) {
        super(x, y, w, new Color(255, 255, 0));
    }

    void paint(Graphics g) {
        g.setColor(color);

        Polygon ear1 = new Polygon();
        ear1.addPoint(loc.x + 5, loc.y + 5);
        ear1.addPoint(loc.x + 15, loc.y + 5);
        ear1.addPoint(loc.x + 5, loc.y + 15);
        Polygon ear2 = new Polygon();
        ear2.addPoint(loc.x + 20, loc.y + 5);
        ear2.addPoint(loc.x + 30, loc.y + 5);
        ear2.addPoint(loc.x + 30, loc.y + 15);
        Polygon face = new Polygon();
        face.addPoint(loc.x + 8, loc.y + 7);
        face.addPoint(loc.x + 27, loc.y + 7);
        face.addPoint(loc.x + 27, loc.y + 25);
        face.addPoint(loc.x + 8, loc.y + 25);

        g.fillPolygon(ear1);
        g.fillPolygon(ear2);
        g.fillPolygon(face);
    }
}