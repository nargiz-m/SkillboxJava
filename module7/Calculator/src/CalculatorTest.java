import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest
{
    @Test
    public void getCircleSquareTest()
    {
        Calculator calculator = new Calculator();
        int actualSquare = (int) calculator.getCircleSquare(17.5);
        int expectedSquare = 962;
        Assert.assertEquals(expectedSquare, actualSquare);
    }

    @Test
    public void getRectangleSquareTest()
    {
        Calculator calculator = new Calculator();
        int actualSquare = calculator.getRectangleSquare(8, 6);
        int expectedSquare = 48;
        Assert.assertEquals(expectedSquare, actualSquare);
    }
}
