import java.awt.*;

public class Cell extends Rectangle {

    public Cell(int x, int y, int width) {
        super(x, y, width, width);
    }

    public void paint(Graphics g, Point mousePosition) {
        int colorHex = 255;
        if (contains(mousePosition.x, mousePosition.y))
            colorHex = 128;
        g.setColor(new Color(colorHex, colorHex, colorHex));
        g.fillRect(x, y, width, height);
        // Draw outline
        g.setColor(new Color(0, 0, 0));
        g.drawRect(x, y, width, height);
    }
}