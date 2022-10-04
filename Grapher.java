
/**
 * @author Chris Nippert
 * @version 1.0
 * 
 * Grapher Class
 * Used to graph Rectangles on a 2D plane
 */
import java.util.ArrayList;
import javax.swing.*;

public class Grapher {

    private static final int SIZE_MULTIPLIER = 10;

    class GraphPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();

        public GraphPanel(ArrayList<Rectangle> rectangles) {
            this.rectangles = rectangles;
        }

        public void addRectangle(Rectangle r) {
            rectangles.add(r);
        }

        public void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);
            for (Rectangle r : rectangles) {
                g.drawRect(r.A.x * SIZE_MULTIPLIER, r.A.y * SIZE_MULTIPLIER,
                        r.C.x * SIZE_MULTIPLIER - r.A.x * SIZE_MULTIPLIER,
                        r.C.y * SIZE_MULTIPLIER - r.A.y * SIZE_MULTIPLIER);
            }
        }
    }

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();

    public Grapher(Rectangle... rectangles) {
        for (Rectangle r : rectangles) {
            this.rectangles.add(r);
        }
    }

    public void drawGraph() {
        JFrame frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GraphPanel(rectangles));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Yep, it works like this
        Rectangle r1 = new Rectangle(0, 0, 25, 25);
        Rectangle r2 = new Rectangle(10, 10, 25, 25);
        Rectangle r3 = new Rectangle(10, 10, 25, 25);
        Rectangle r4 = new Rectangle(5, 10, 12, 52);
        Rectangle r5 = new Rectangle(10, 5, 12, 23);
        Grapher g = new Grapher(r1, r2, r3, r4, r5);
        g.drawGraph();
    }
}