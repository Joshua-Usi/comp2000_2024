import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
        Main window = new Main();
    }

    class Canvas extends JPanel {
        public Canvas() {
            setPreferredSize(new Dimension(720, 720));
        }

        public void paint(Graphics g) {
            final int CELL_SIZE = 35;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    g.drawRect(10 + i * CELL_SIZE, 10 + j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
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
