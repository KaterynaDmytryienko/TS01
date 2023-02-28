import cz.fel.cvut.ts1.dmytrkat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class dmytrkatTest {
    @Test
    public void FactorialTest() {
        Assertions.assertEquals(2, dmytrkat.factorialRecursive(2));
        Assertions.assertEquals(120,dmytrkat.factorialIterative(5));
    }

}
