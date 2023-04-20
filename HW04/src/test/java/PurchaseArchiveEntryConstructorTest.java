import static org.junit.Assert.assertEquals;
import archive.ItemPurchaseArchiveEntry;
import org.junit.Test;
import shop.Item;

public class PurchaseArchiveEntryConstructorTest {
    Item item = new Item(1, "TestItem1", 10, "CategoryForTestItem1");
    ItemPurchaseArchiveEntry purchaseArchiveEntry = new ItemPurchaseArchiveEntry(item);
    @Test
    public void testPurchaseArchiveEntryConstructor() {
        assertEquals(item, purchaseArchiveEntry.getRefItem());
    }
}