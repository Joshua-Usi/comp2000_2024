import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

class Stage {
    Grid grid;
    ArrayList<Actor> actors;

    Stage(Grid grid, ArrayList<Actor> actors) {
        this.grid = grid;
        this.actors = actors;
    }

    void paint(Graphics g, Point mousePosition) {
        grid.paint(g, mousePosition);
        g.translate(grid.offsetX, grid.offsetY);
        for (Actor actor : actors) {
            actor.paint(g);
        }
        g.translate(-grid.offsetX, -grid.offsetY);
    }
}