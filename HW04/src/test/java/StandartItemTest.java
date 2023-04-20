import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import shop.StandardItem;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


public class StandartItemTest {
    int id = 2;
    String name = "Item name";
    float price = 20.176f;
    String category = "Item category";
    int loyaltyPoints = 10;

    StandardItem item = new StandardItem(id, name, price, category, loyaltyPoints);
    @Test
    public void constructorTest(){

        assertEquals(id, item.getID());
        assertEquals(name, item.getName());
        assertEquals(price, item.getPrice(),0.0001 );
        assertEquals(category, item.getCategory());
        assertEquals(loyaltyPoints, item.getLoyaltyPoints());
    }

    @Test
    public void copyTest(){
        StandardItem copy = item.copy();
        assertEquals(item.getID(), copy.getID());
        assertEquals(item.getName(), copy.getName());
        assertEquals(item.getPrice(), copy.getPrice(), 0.0001);
        assertEquals(item.getCategory(), copy.getCategory());
        assertEquals(item.getLoyaltyPoints(), copy.getLoyaltyPoints());
    }


    @RunWith(Parameterized.class)
    public static class StandardItemTest {
        private StandardItem item;
        private Object comparationItem;
        private boolean expectedResult;

        public StandardItemTest(StandardItem item, Object comparationItem, boolean expectedResult) {
            this.item = item;
            this.comparationItem = comparationItem;
            this.expectedResult = expectedResult;
        }
        @Parameterized.Parameters(name = "{index}: {0} and {1} should be {2}")
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    { new StandardItem(1, "item1", 29,"Item1Category", 5), new StandardItem(1, "item1", 29,"Item1Category", 5), true},
                    { new StandardItem(2, "item2", 30,"Item2Category", 6), new StandardItem(3, "item3", 30,"Item3Category", 6), false }
//
            });
        }

        @Test
        public void testEqualsFunction() {
            assertEquals(expectedResult, comparationItem.equals(item));
        }

    }


}
