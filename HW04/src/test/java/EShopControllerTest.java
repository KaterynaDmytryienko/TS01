import shop.*;
import storage.NoItemInStorage;
import storage.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EShopControllerTest {

    private ShoppingCart cart;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Item[] storageItems;

    @BeforeEach
    public void setUp() {
        storageItems = new Item[]{
                new StandardItem(1, "Dancing Panda v.2", 5000, "GADGETS", 5),
                new StandardItem(2, "Dancing Panda v.3 with USB port", 6000, "GADGETS", 10),
                new StandardItem(3, "Screwdriver", 200, "TOOLS", 5),
                new DiscountedItem(4, "Star Wars Jedi buzzer", 500, "GADGETS", 30, "1.8.2013", "1.12.2013"),
                new DiscountedItem(5, "Angry bird cup", 300, "GADGETS", 20, "1.9.2013", "1.12.2013"),
                new DiscountedItem(6, "Soft toy Angry bird (size 40cm)", 800, "GADGETS", 10, "1.8.2013", "1.12.2013")
        };

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void purchaseShoppingCartEmptyTest() throws NoItemInStorage {
        String customerName = "Libuse Novakova";
        String customerAddress = "Kosmonautu 25, Praha 8";
        String expectedOutput = "Error: shopping cart is empty";
        cart = new ShoppingCart();

        EShopController.startEShop();
        EShopController.purchaseShoppingCart(cart, customerName, customerAddress);

        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    public void purchaseShoppingCartTest() {
        String customerName = "Libuse Novakova";
        String customerAddress = "Kosmonautu 25, Praha 8";
        String expectedOutput = "Error: shopping cart is empty";
        cart = new ShoppingCart();
        cart.addItem(storageItems[0]);
        cart.addItem(storageItems[1]);
        cart.addItem(storageItems[2]);
        cart.addItem(storageItems[4]);
        cart.addItem(storageItems[5]);
    }

    @Test
    public void storageContainingTest() {
        String exceptedOutput = "STORAGE IS CURRENTLY CONTAINING:\n" +
                "STOCK OF ITEM:  Item   ID 1   NAME Dancing Panda v.2   CATEGORY GADGETS   PRICE 5000.0" +
                "   LOYALTY POINTS 5    PIECES IN STORAGE: 10\n" +
                "STOCK OF ITEM:  Item   ID 2   NAME Dancing Panda v.3 with USB port   CATEGORY GADGETS   PRICE 6000.0" +
                "   LOYALTY POINTS 10    PIECES IN STORAGE: 10\nSTOCK OF ITEM:  Item   ID 3   NAME Screwdriver" +
                "   CATEGORY TOOLS   PRICE 200.0   LOYALTY POINTS 5    PIECES IN STORAGE: 4\n" +
                "STOCK OF ITEM:  Item   ID 4   NAME Star Wars Jedi buzzer   CATEGORY GADGETS   ORIGINAL PRICE 500.0" +
                "    DISCOUNTED PRICE 35000.0  DISCOUNT FROM Thu Aug 01 00:00:00 CEST 2013" +
                "    DISCOUNT TO Sun Dec 01 00:00:00 CET 2013    PIECES IN STORAGE: 5\n" +
                "STOCK OF ITEM:  Item   ID 5   NAME Angry bird cup   CATEGORY GADGETS   ORIGINAL PRICE 300.0" +
                "    DISCOUNTED PRICE 24000.0  DISCOUNT FROM Sun Sep 01 00:00:00 CEST 2013    DISCOUNT TO Sun Dec" +
                " 01 00:00:00 CET 2013    PIECES IN STORAGE: 10\n" +
                "STOCK OF ITEM:  Item   ID 6   NAME Soft toy Angry bird (size 40cm)   CATEGORY GADGETS   ORIGINAL PRICE" +
                " 800.0    DISCOUNTED PRICE 72000.0  DISCOUNT FROM Thu Aug 01 00:00:00 CEST 2013    DISCOUNT TO Sun Dec" +
                " 01 00:00:00 CET 2013    PIECES IN STORAGE: 2";

        Storage storage = new Storage();
        int[] itemCount = {10,10,4,5,10,2};

        for (int i = 0; i < storageItems.length; i++) {
            storage.insertItems(storageItems[i], itemCount[i]);
        }
        storage.printListOfStoredItems();


        assertEquals(exceptedOutput, outContent.toString().trim());
    }

    @Test
    public void itemRemovalTest(){
        cart = new ShoppingCart();
        Item item = new Item(0,"Item1", 100, "CategoryForItem1");

        cart.addItem(item);
        cart.removeItem(0);

        assertEquals(0, cart.getItemsCount());
    }
}