import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

class Bird extends Actor {
    Bird(int x, int y, int w) {
        super(x, y, w, new Color(0, 255, 0));
    }

    void paint(Graphics g) {
        g.setColor(color);

        Polygon wing1 = new Polygon();
        wing1.addPoint(loc.x + 5, loc.y + 5);
        wing1.addPoint(loc.x + 15, loc.y + 17);
        wing1.addPoint(loc.x + 5, loc.y + 17);
        Polygon wing2 = new Polygon();
        wing2.addPoint(loc.x + 30, loc.y + 5);
        wing2.addPoint(loc.x + 20, loc.y + 17);
        wing2.addPoint(loc.x + 30, loc.y + 17);
        Polygon body = new Polygon();
        body.addPoint(loc.x + 15, loc.y + 10);
        body.addPoint(loc.x + 20, loc.y + 10);
        body.addPoint(loc.x + 20, loc.y + 25);
        body.addPoint(loc.x + 15, loc.y + 25);

        g.fillPolygon(wing1);
        g.fillPolygon(wing2);
        g.fillPolygon(body);
    }
}