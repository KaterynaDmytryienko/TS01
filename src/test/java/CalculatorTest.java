import hw2.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    @Test
    public void addTestAdd5to5Result10(){
        int result = calculator.add(5,5);
        Assertions.assertEquals(10, result);
    }

    @Test
    public void subtractTestSubtract3from105Result7(){
        int result = calculator.subtract(10, 3);
        Assertions.assertEquals(7, result);
    }

    @Test
    public void multiplyTestMultiply3to3Result9(){
        int result = calculator.multiply(3, 3);
        Assertions.assertEquals(9, result);
    }

   @Test
    public void divisionTestDivide10by2Result5(){
        int result = calculator.divide(10, 2);
        Assertions.assertEquals(5, result);
    }


    @Test
    public void divisionByZeroError(){
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(10, 0));
    }
}
