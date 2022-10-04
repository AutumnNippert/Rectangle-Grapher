package hw3;
import java.security.SecureRandom;

public class CollisionChecker {
    /**
     * generate random rectangle
     * @param bound_w upper bound for x value
     * @param bound_l lower bound for y value
     * @param w width
     * @param l height
     * @return random rectangle
     */
    static Rectangle generateRandomRect(int bound_w, int bound_l, int w, int l)
    {
        SecureRandom random = new SecureRandom();
        int x = random.nextInt(bound_w);
        int y = random.nextInt(bound_l);
        return new Rectangle(x, y, w, l);
    }

    /**
     *
     * @param w width of rectangle T
     * @param l length of rectangle T
     * @param wA width of rectangle A
     * @param lA length of rectangle A
     * @param wB width of rectangle B
     * @param lB length of rectangle B
     */
    static void solve(int w , int l, int wA, int lA, int wB, int lB)
    {
        Rectangle T = new Rectangle(0, 0, w, l);

        Rectangle A = generateRandomRect(w, l, wA, lA);
        Rectangle B = generateRandomRect(w, l, wB, lB);
        int count = 0;
        while(A.isCollision(B) || B.isCollision(A) || !A.isInside(B) || !B.isInside(A))
        {
            A = generateRandomRect(w, l, wA, lA);
            B = generateRandomRect(w, l, wB, lB);
            count++;

            if(count % 1000 == 0) {
                System.out.println("Tried " + count + " times");
                System.out.println(A);
                System.out.println(B);
            }

            if(count > 100000)
            {
                System.out.println("No solution found");
                return;
            }
        }

        // Rectangle A = generateRandomRect(w, l, wA, lA);
        // while(!T.isInside(A)) {
        //     A = generateRandomRect(w, l, wA, lA);
        // }
        
        // Rectangle B = generateRandomRect(w, l, wB, lB);
        // while(A.isCollision(B) || !T.isInside(B)) {
        //     B = generateRandomRect(w, l, wB, lB);
        // }
        
        System.out.println("Rectangle T: " + T);
        System.out.println("Rectangle A: " + A);
        System.out.println("Rectangle B: " + B);

        Grapher g = new Grapher(T, A, B);
        g.drawGraph();
    }

    public static void main(String[] args) {
        // parameter setup
        int w , l, wA, lA, wB, lB;
        w = l = 25;
        wA = lA = 8;
        wB = lB = 6;
        solve(w , l, wA, lA, wB, lB);

    }
}
