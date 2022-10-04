/**
 * @author Chris Nippert
 * @version 1.0
 * 
 *          Rectangle Class
 */
public class Rectangle {
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public Point A, B, C, D;

    public Rectangle(int x, int y, int w, int l) {
        A = new Point(x, y);
        B = new Point(x + w, y);
        C = new Point(x + w, y + l);
        D = new Point(x, y + l);
    }

    @Override
    public String toString() {
        return "Rectangle [A=" + A + ", B=" + B + ", C=" + C + ", D=" + D + "]";
    }
}
