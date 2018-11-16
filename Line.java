public class Line {
    private double[] x, y;
    double m, b;

    public Line(double[][] array) {
        x = new double[array[0].length];
        y = new double[array[1].length];
        for(int i = 0; i < x.length; i++) {
            x[i] = array[0][i];
        }
        for(int i = 0; i < y.length; i++) {
            y[i] = array[1][i];
        }
    }

    public void compute() {
        int length = x.length;
        double[] x2 = new double[length];
        double[] xy = new double[length];

        for(int i = 0; i < length; i++) {
            x2[i] = x[i] * x[i];
            xy[i] = x[i] * y[i];
        }

        double sumx = 0, sumy = 0, sumx2 = 0, sumxy = 0;
        for(int i = 0; i < length; i++) {
            sumx  += x[i];
            sumy  += y[i];
            sumx2 += x2[i];
            sumxy += xy[i];
        }

        m = (length * sumxy) - (sumx * sumy);
        m /= (length * sumx2) - (sumx * sumx);

        b = (sumy - m * sumx) / length;
    }

    public double slope() {
        return m;
    }

    public double y_intercept() {
        return b;
    }

    public String toString() {
        return "y = " + m + "x + " + b;
    }
}


