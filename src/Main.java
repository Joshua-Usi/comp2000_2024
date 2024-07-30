import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

        public void paint(Graphics g) {
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

        public void paint(Graphics g) {
            g.translate(offsetX, offsetY);
            for (Cell c : cells) {
                c.paint(g);
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
            grid.paint(g);
        }
    }

    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.setVisible(true);
        this.pack();
    }
}
