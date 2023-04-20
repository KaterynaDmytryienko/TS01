import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertEquals;

import shop.Item;
import storage.ItemStock;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ItemStockDecreaseTest {
    private ItemStock itemStock;
    private int initialNumber;
    private int manipulationNumber;
    private int expectedNumber;

    public ItemStockDecreaseTest(int initialNumber, int manipulationNumber, int expectedNumber) {
        this.initialNumber = initialNumber;
        this.manipulationNumber = manipulationNumber;
        this.expectedNumber = expectedNumber;

        Item item = new Item(1, "Item1", 12, "Item1Category");
        this.itemStock = new ItemStock(item);
        itemStock.IncreaseItemCount(initialNumber);
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 6, 5, 1 },
                { 20, 4, 16 },
                { 5, 5, 0 },
                { 0, 3, -3 },
                { 0, 0, 0 }
        });
    }

    @Test
    public void DecreaseItemCountTest() {
        itemStock.decreaseItemCount(manipulationNumber);
        assertEquals(expectedNumber, itemStock.getCount());
    }
}
