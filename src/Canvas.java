import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

class Canvas extends JPanel {
    public Stage stage;

    public Canvas() {
        setPreferredSize(new Dimension(720, 720));

        ArrayList<Cell> cells = new ArrayList<>();
        final int CELL_WIDTH = 35;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                cells.add(new Cell(j * CELL_WIDTH, i * CELL_WIDTH, CELL_WIDTH));
            }
        }
        Grid grid = new Grid(10, 10, cells);

        ArrayList<Actor> actors = new ArrayList<>();
        actors.add(new Cat(0, 0, 35));
        actors.add(new Dog(70, 0, 35));
        actors.add(new Bird(140, 0, 35));

        stage = new Stage(grid, actors);
    }

    public void paint(Graphics g) {
        Point mp = getMousePosition();
        mp = (mp == null) ? new Point(-1, -1) : mp;
        stage.paint(g, mp);
    }
}