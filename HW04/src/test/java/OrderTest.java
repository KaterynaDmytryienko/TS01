import org.junit.Test;
import shop.Item;
import shop.Order;
import shop.ShoppingCart;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OrderTest {
    private ArrayList<Item> items;
    String customerName;
    String customerAddress;
    int state;

    @Test
    public void CartCustomerNameCustomerAddressStateConstructorTest(){
        ShoppingCart cart = new ShoppingCart(items);
        Order order = new Order(cart, customerName, customerAddress, state);
        ArrayList<Item> cartItems = null;
        if (cart != null) {
            cartItems = cart.getCartItems();
        }
        assertEquals(cartItems, order.getItems());
        assertEquals(customerName, order.getCustomerName());
        assertEquals(customerAddress, order.getCustomerAddress());
        assertEquals(state, order.getState());
    }

    @Test
    public void CartCustomerNameCustomerAddressConstructorTest(){
        ShoppingCart cart = new ShoppingCart(items);
        Order order = new Order(cart, customerName, customerAddress);
        ArrayList<Item> cartItems = null;
        if (cart != null) {
            cartItems = cart.getCartItems();
        }
        assertEquals(cartItems, order.getItems());
        assertEquals(customerName, order.getCustomerName());
        assertEquals(customerAddress, order.getCustomerAddress());
        assertEquals(state, order.getState());
    }
}
