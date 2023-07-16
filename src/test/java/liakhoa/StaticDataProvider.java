package liakhoa;

import org.testng.annotations.DataProvider;

public class StaticDataProvider {

    @DataProvider(name = "data")
    public static Object[][] createDataForFunction() {
        return new Object[][]{
                {0.3, 0.4107},
                {2.6, -4.151016},
                {1.0, 13.799999}
        };
    }

    @DataProvider(name = "dataSteps")
    public static Object[][] createDataForSteps() {
        return new Object[][]{
                {0.2, 2.8, 0.002, 1301}
        };
    }

    @DataProvider(name = "dataFillX")
    public static Object[][] dataFillX() {
        return new Object[][]{
                {50, 0.3},
                {1050, 2.3},
                {1300, 2.8}
        };
    }

    @DataProvider(name = "dataFillY")
    public static Object[][] dataFillY() {
        return new Object[][]{
                {50, 0.4107},
                {1050, 1.242000},
                {1300, -2.453155}
        };
    }

    @DataProvider(name = "dataMaxXElement")
    public static Object[][] dataMaxXElement() {
        return new Object[][]{
                {1300}
        };
    }

    @DataProvider(name = "dataMaxYElement")
    public static Object[][] dataMaxYElement() {
        return new Object[][]{
                {51}
        };
    }

    @DataProvider(name = "dataMinXElement")
    public static Object[][] dataMinXElement() {
        return new Object[][]{
                {0}
        };
    }

    @DataProvider(name = "dataMinYElement")
    public static Object[][] dataMinYElement() {
        return new Object[][]{
                {1051}
        };
    }

    @DataProvider(name = "dataForSumX")
    public static Object[][] dataForSumX() {
        return new Object[][]{
                {1951.5}
        };
    }

    @DataProvider(name = "dataForSumY")
    public static Object[][] dataForSumY() {
        return new Object[][]{
                {10167.677206}
        };
    }

    @DataProvider(name = "dataForAvgX")
    public static Object[][] dataForAvgX() {
        return new Object[][]{
                {1.5}
        };
    }

    @DataProvider(name = "dataForAvgY")
    public static Object[][] dataForAvgY() {
        return new Object[][]{
                {7.815278}
        };
    }
}
