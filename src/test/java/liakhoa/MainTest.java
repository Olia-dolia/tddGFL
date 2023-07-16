package liakhoa;

import org.assertj.core.data.Offset;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MainTest {

    public final static double EPS = 1e-6;

    Main main;

    @BeforeMethod
    public void setUp() {
        main = new Main();
    }

    @Test(dataProvider = "data", dataProviderClass = StaticDataProvider.class)
    public void testFunction(double x, double expected) {
        double actual = main.function(x);
        assertThat(actual).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataSteps")
    public void testSteps(double start, double end, double step, int expected) {
        int actual = main.steps(start, end, step);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataFillX")
    public void testFillX(int index, double expected) {
        double start = 0.2;
        double end = 2.8;
        double step = 0.002;
        double[] x = main.fillX(start, end, step);
        assertThat(x[index]).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataFillY")
    public void testFillY(int index, double expected) {
        double start = 0.2;
        double end = 2.8;
        double step = 0.002;
        double[] x = main.fillX(start, end, step);
        double[] y = main.fillY(x);
        assertThat(y[index]).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataMaxXElement")
    public void testMaxXElement(int expected){
        double start = 0.2;
        double end = 2.8;
        double step = 0.002;
        double[] x = main.fillX(start, end, step);
        int indexMaxElement = main.maxElement(x);
        assertThat(indexMaxElement).isEqualTo(expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataMaxYElement")
    public void testMaxYElement(int expected){
        double start = 0.2;
        double end = 2.8;
        double step = 0.002;
        double[] x = main.fillX(start, end, step);
        double[] y = main.fillY(x);
        int indexMaxElement = main.maxElement(y);
        assertThat(indexMaxElement).isEqualTo(expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataMinXElement")
    public void testMinElement(int expected){
        double start = 0.2;
        double end = 2.8;
        double step = 0.002;
        double[] x = main.fillX(start, end, step);
        int indexMinElement = main.minElement(x);
        assertThat(indexMinElement).isEqualTo(expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataMinYElement")
    public void testMinYElement(int expected){
        double start = 0.2;
        double end = 2.8;
        double step = 0.002;
        double[] x = main.fillX(start, end, step);
        double[] y = main.fillY(x);
        int indexMaxElement = main.minElement(y);
        assertThat(indexMaxElement).isEqualTo(expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataForSumX")
    public void testSumX(double expected){
        double start = 0.2;
        double end = 2.8;
        double step = 0.002;
        double[] x = main.fillX(start, end, step);
        double actualSum = main.sum(x);
        assertThat(actualSum).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataForSumY")
    public void testSumY(double expected){
        double start = 0.2;
        double end = 2.8;
        double step = 0.002;
        double[] x = main.fillX(start, end, step);
        double[] y = main.fillY(x);
        double actualSum = main.sum(y);
        assertThat(actualSum).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataForAvgX")
    public void testAvgX(double expected){
        double start = 0.2;
        double end = 2.8;
        double step = 0.002;
        double[] x = main.fillX(start, end, step);
        double actualSum = main.average(x);
        assertThat(actualSum).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataForAvgY")
    public void testAvgY(double expected){
        double start = 0.2;
        double end = 2.8;
        double step = 0.002;
        double[] x = main.fillX(start, end, step);
        double[] y = main.fillY(x);
        double actualSum = main.average(y);
        assertThat(actualSum).isCloseTo(expected, Offset.offset(EPS));
    }
}