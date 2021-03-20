package tdd;

import org.junit.Assert;
import org.junit.Test;

public class TddCalculatorTests {

    @Test
    public void TwoPlusTwo_EqualsFour()
    {
        TddCalculator calculator = new TddCalculator();
        int result = calculator.add(2, 2);
        // sprawdzamy
        Assert.assertEquals(4, result);
    }

    @Test
    public void FiveSubtractThree_EqualsTwo()
    {
        TddCalculator calculator = new TddCalculator();
        int result = calculator.subtract(5, 3);
        Assert.assertEquals(2, result);
    }
}
