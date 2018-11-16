import java.util.Arrays;
import java.util.Scanner;

public class RegressionTester {
    public static void main(String... args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter in the number of pts ===>> ");
        int numbOfPts = input.nextInt();
        System.out.println();

        double[][] pts = new double[2][numbOfPts];

        for(int i = 0; i < numbOfPts; i++) {
            System.out.print("Enter in the point ===>> ");
            pts[0][i] = input.nextDouble();
            pts[1][i] = input.nextDouble();
            System.out.println();
        }

        Line line = new Line(pts);
        line.compute();
        System.out.println(line);

        System.out.println();
        Polynomial poly = new Polynomial(pts, 2);
        poly.compute();
        System.out.println(Arrays.deepToString(poly.coefficients));
    }

}
