import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import shop.Item;
import shop.Order;
import archive.ItemPurchaseArchiveEntry;
import archive.PurchasesArchive;
import shop.ShoppingCart;

public class PurchasesArchiveTestPart2 {

    private PurchasesArchive purchasesArchive;
    private HashMap<Integer, ItemPurchaseArchiveEntry> itemArchive;
    private ArrayList<Order> orderArchive;
    private Order firstOrder, secondOrder, thirdOrder;
    private Item item1, item2;

    @Before
    public void configure() {
        itemArchive = new HashMap<>();
        orderArchive = new ArrayList<>();
        purchasesArchive = new PurchasesArchive(itemArchive, orderArchive);
        item1 = new Item(1006, "TestItem1", 5867, "CategoryForTestItem1");
        item2 = new Item(876, "TestItem2", 576, "CategoryForTestItem2");


        firstOrder = new Order(new ShoppingCart(), "Novakova Maria", "Praha1", 1);
        secondOrder = new Order(new ShoppingCart(), "Novak Daiel", "Praha2", 1);
        thirdOrder = new Order(new ShoppingCart(), "Petr Novotny", "Praha4", 1);

    }

    @Test
    public void putOrderToPurchasesArchiveTest() {
        firstOrder.getItems().add(item1);
        secondOrder.getItems().add(item2);
        thirdOrder.getItems().add(item1);


        purchasesArchive.putOrderToPurchasesArchive(firstOrder);
        purchasesArchive.putOrderToPurchasesArchive(secondOrder);
        purchasesArchive.putOrderToPurchasesArchive(thirdOrder);

        assertEquals(3, purchasesArchive.orderArchive.size());
        assertEquals(2, purchasesArchive.itemPurchaseArchive.size());

    }
        @Test
        public void howManyItemsHasBeenSoldTest() {
            firstOrder.getItems().add(item1);
            secondOrder.getItems().add(item2);
            thirdOrder.getItems().add(item1);


            purchasesArchive.putOrderToPurchasesArchive(firstOrder);
            purchasesArchive.putOrderToPurchasesArchive(secondOrder);
            purchasesArchive.putOrderToPurchasesArchive(thirdOrder);
            assertEquals(2, purchasesArchive.itemPurchaseArchive.get(item1.getID()).getCountHowManyTimesHasBeenSold());
            assertEquals(1, purchasesArchive.itemPurchaseArchive.get(item2.getID()).getCountHowManyTimesHasBeenSold());
        }

    }