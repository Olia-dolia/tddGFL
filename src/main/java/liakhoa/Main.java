package liakhoa;

//variant 5

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {

    private final double A = 2.3;
    private final double EPS = 1e-6;

    public double function(double x) {
        if (x <= 0.3 + EPS) {
            return 1.5 * x * Math.cos(x) * Math.cos(x);
        }

        if (x > 2.3 + EPS) {
            return 3 * A * Math.tan(x);
        }
        return Math.pow((x - 2), 2) * 6 * A;
    }

    public int steps(double start, double end, double step) {
        return (int) (Math.round((end - start) / step) + 1);
    }

    public double[] fillX(double start, double end, double step) {
        return IntStream.range(0, steps(start, end, step)).mapToDouble(i -> start + i * step).toArray();
    }

    public double[] fillY(double[] x) {
        return DoubleStream.of(x).map(this::function).toArray();
    }

    public int maxElement(double[] x) {
        double element = DoubleStream.of(x).max().getAsDouble();
        int count = -1;
        for (double i : x) {
            count++;
            if (element == i) return count;
        }
        return 0;
    }

    public int minElement(double[] x) {
        double element = DoubleStream.of(x).min().getAsDouble();
        int count = -1;
        for (double i : x) {
            count++;
            if (element == i) return count;
        }
        return 0;
    }

    public double sum(double[] x) {
        return DoubleStream.of(x).sum();
    }

    public double average(double[] x) {
        return DoubleStream.of(x).average().getAsDouble();
    }
}
