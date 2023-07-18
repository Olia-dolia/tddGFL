package liakhoa;

//variant 5

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {

    private static final double A = 2.3;
    private static final double EPS = 1e-6;
    static double start = 0.2;
    static double end = 2.8;
    static double step = 0.002;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        double[] x = fillX(start, end, step);
        double[] y = fillY(x);

        printMinElement(getMinElement(x), getMinIndexElement(x),"x");
        printMaxElement(getMaxElement(x), getMaxIndexElement(x),"x");
        printMinElement(getMinElement(y), getMinIndexElement(y),"y");
        printMaxElement(getMaxElement(y), getMaxIndexElement(y),"y");

        double sumX = sum(x);
        printSum(sumX, "x");
        double sumY = sum(y);
        printSum(sumY, "y");

        double avgX = average(x);
        printAvg(avgX, "x");
        double avgY = average(y);
        printAvg(avgY, "y");

    }

    public double function(double x) {
        if (x <= 0.3 + EPS) {
            return 1.5 * x * Math.cos(x) * Math.cos(x);
        }

        if (x > 2.3 + EPS) {
            return 3 * A * Math.tan(x);
        }
        return Math.pow((x - 2), 2) * 6 * A;
    }

    public static int steps(double start, double end, double step) {
        return (int) (Math.round((end - start) / step) + 1);
    }

    public static double[] fillX(double start, double end, double step) {
        return IntStream.range(0, steps(start, end, step)).mapToDouble(i -> start + i * step).toArray();
    }

    public double[] fillY(double[] x) {
        return DoubleStream.of(x).map(this::function).toArray();
    }

    public static int getMaxIndexElement(double[] x) {
        double element = getMaxElement(x);
        int count = -1;
        for (double i : x) {
            count++;
            if (element == i) return count;
        }
        return 0;
    }

    public static int getMinIndexElement(double[] x) {
        double element = getMinElement(x);
        int count = -1;
        for (double i : x) {
            count++;
            if (element == i) return count;
        }
        return 0;
    }

    public static double getMinElement(double[] x){
        return DoubleStream.of(x).min().getAsDouble();
    }

    public static double getMaxElement(double[] x) {
        return DoubleStream.of(x).max().getAsDouble();
    }

    public static double sum(double[] x) {
        return DoubleStream.of(x).sum();
    }

    public static double average(double[] x) {
        return DoubleStream.of(x).average().getAsDouble();
    }

    public static void printMinElement(double min, int index, String par) {
        System.out.printf("Min element is: %f on position %d for %s \n", min, index, par);
    }

    public static void printMaxElement(double max, int index, String par) {
        System.out.printf("Max element is: %f on position %d for %s \n", max, index, par);
    }

    public static void printSum(double sum, String par) {
        System.out.printf("Sum is: %f for %s \n", sum, par);
    }

    public static void printAvg(double avg, String par) {
        System.out.printf("Avg is: %f for %s \n", avg, par);
    }
}
