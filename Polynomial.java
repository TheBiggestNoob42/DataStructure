public class Polynomial {
    private double[] x, y;
    double[][] coefficients;
    int pow;

    public Polynomial(double[][] array, int power) {
        x = new double[array[0].length];
        y = new double[array[1].length];
        for(int i = 0; i < x.length; i++) {
            x[i] = array[0][i];
        }
        for(int i = 0; i < y.length; i++) {
            y[i] = array[1][i];
        }

        coefficients = new double[pow + 1][1];
        pow = power;
    }

    public void compute() {
        double[][] a = new double[pow + 1][pow + 1];
        for(int i = 0; i < pow + 1; i++) {
            for(int j = 0; j < pow + 1; j++) {
                a[i][j] = sumx( i + j );
            }
        }
        a = invert(a);

        double[][] b = new double[pow + 1][1];
        for(int i = 0; i < pow + 1; i++) {
            b[i][0] = sumxy(i);
        }

        coefficients = multiplyMatrices(a, b, a.length, a[0].length, b[0].length);
    }

    private double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix, int r1, int c1, int c2) {
        double[][] product = new double[r1][c2];
        for(int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        return product;
    }

    private double sumx(int a) {
        double sum = 0;
        for(double add: x) {
            sum += Math.pow(add, a);
        }
        return sum;
    }

    private double sumxy(int a) {
        double sum = 0;
        for(int i = 0; i < x.length; i++) {
            sum += Math.pow(x[i], a) * y[i];
        }
        return sum;
    }

    public static double[][] invert(double a[][])
    {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i)
            b[i][i] = 1;

        // Transform the matrix into an upper triangle
        gaussian(a, index);

        // Update the matrix b[i][j] with the ratios stored
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i]*b[index[i]][k];

        // Perform backward substitutions
        for (int i=0; i<n; ++i) {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k) {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

    public static void gaussian(double a[][], int index[]) {
        int n = index.length;
        double c[] = new double[n];

        // Initialize the index
        for (int i = 0; i < n; ++i)
            index[i] = i;

        // Find the rescaling factors, one from each row
        for (int i = 0; i < n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            double pi1 = 0;
            for (int i = j; i < n; ++i) {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < n; ++i) {
                double pj = a[index[i]][j] / a[index[j]][j];

                // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l = j + 1; l < n; ++l)
                    a[index[i]][l] -= pj * a[index[j]][l];
            }
        }
    }
}
