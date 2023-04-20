import archive.PurchasesArchive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import shop.Item;
import shop.Order;
import shop.StandardItem;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import archive.ItemPurchaseArchiveEntry;


public class PurchasesArchiveTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream outOrigin = System.out;
    private final PrintStream errOrigin = System.err;
    private StandardItem mockedItem;
    private Order mockedOrder;
    private ItemPurchaseArchiveEntry mockedItemPurchaseArchiveEntry;
    private HashMap<Integer, ItemPurchaseArchiveEntry> itemArchive;
    private ArrayList<Order> orderArchive;


    @BeforeEach
    public void configure() {

        mockedItem = Mockito.mock(StandardItem.class);
        Mockito.when(mockedItem.getID()).thenReturn(1);

        mockedOrder = Mockito.mock(Order.class);
        ArrayList<Item> items = new ArrayList<>();
        items.add(mockedItem);
        Mockito.when(mockedOrder.getItems()).thenReturn(items);


        mockedItemPurchaseArchiveEntry = Mockito.mock(ItemPurchaseArchiveEntry.class);
        Mockito.when(mockedItemPurchaseArchiveEntry.getCountHowManyTimesHasBeenSold()).thenReturn(1);


        itemArchive = new HashMap<>();
        itemArchive.put(1, mockedItemPurchaseArchiveEntry);
        orderArchive = new ArrayList<>();
        orderArchive.add(mockedOrder);
    }

    @Test
    public void printItemPurchaseStatisticsTest() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        Mockito.when(mockedItemPurchaseArchiveEntry.toString()).thenReturn("TextForTesting");
        itemArchive.put(1, mockedItemPurchaseArchiveEntry);
        PurchasesArchive purchasesArchive = new PurchasesArchive(itemArchive, null);
        String expected = "ITEM PURCHASE STATISTICS:" + System.lineSeparator() + "TextForTesting" + System.lineSeparator();
        purchasesArchive.printItemPurchaseStatistics();

        assertEquals(expected, outContent.toString());

        System.setErr(errOrigin);
    }

}



