import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
        Main window = new Main();
    }

    class Cell {
        private int x, y, width;

        public Cell(int x, int y, int width) {
            this.x = x;
            this.y = y;
            this.width = width;
        }

        public void paint(Graphics g, Point mousePosition) {
            int colorHex = 255;
            if (withinBounds(mousePosition.x, mousePosition.y, x, y, width, width))
                colorHex = 128;
            g.setColor(new Color(colorHex, colorHex, colorHex));
            g.fillRect(x, y, width, width);
            // Draw outline
            g.setColor(new Color(0, 0, 0));
            g.drawRect(x, y, width, width);
        }
    }

    class Grid {

        private int offsetX, offsetY;
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

    class Canvas extends JPanel {
        public Grid grid;

        public Canvas() {
            setPreferredSize(new Dimension(720, 720));

            ArrayList<Cell> cells = new ArrayList<>();
            final int CELL_WIDTH = 35;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    cells.add(new Cell(j * CELL_WIDTH, i * CELL_WIDTH, CELL_WIDTH));
                }
            }
            grid = new Grid(10, 10, cells);
        }

        public void paint(Graphics g) {
            Point mousePosition = this.getMousePosition();
            if (mousePosition == null)
                mousePosition = new Point(-1, -1);
            grid.paint(g, mousePosition);
        }
    }

    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.setVisible(true);
        this.pack();

        Timer timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.repaint();
            }
        });

        timer.start();
    }

    private static boolean withinBounds(int mouseX, int mouseY, int x, int y, int width, int height) {
        if (mouseX < x)
            return false;
        if (mouseX >= x + width)
            return false;
        if (mouseY < y)
            return false;
        if (mouseY >= y + width)
            return false;
        return true;
    }
}
