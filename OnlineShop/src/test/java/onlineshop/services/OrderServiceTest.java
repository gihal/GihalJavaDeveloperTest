/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineshop.services;

import java.util.List;
import onlineshop.entities.Order;
import onlineshop.entities.Product;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gihal
 */
public class OrderServiceTest {

    private OrderService orderService;
    private Product product;

    public OrderServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        orderService = new OrderService();
        product = new Product(1, "test product", "test description", 20);
    }

    @After
    public void tearDown() {
        List<Order> orders = orderService.getAllOrders();
        for (Order order : orders) {
            orderService.removeOrder(order.getId());
        }
    }

    /**
     * Test of getMatchingOrder method, of class OrderService.
     */
    @Test
    public void testGetMatchingOrder() {
        System.out.println("getMatchingOrder");
        Order order = new Order(1, product, 2);
        orderService.addOrder(order);
        assertEquals(order, orderService.getMatchingOrder(product.getId()));
        assertNull(orderService.getMatchingOrder(1000L)); // no product with id 1000
    }

    /**
     * Test of addOrder method, of class OrderService.
     */
    @Test
    public void testAddOrder() {
        System.out.println("addOrder");
        List<Order> result = orderService.getAllOrders();
        assertTrue(result.isEmpty());

        Order order = new Order(1, product, 2);
        orderService.addOrder(order);
        result.add(order);

        assertEquals(result, orderService.getAllOrders());

    }

    /**
     * Test of updateOrder method, of class OrderService.
     */
    @Test
    public void testUpdateOrder() {
        System.out.println("updateOrder");
        Order order = new Order(1, product, 2);
        orderService.addOrder(order);
        order.setQuantity(5);
        orderService.updateOrder(order);
        assertEquals(order.getQuantity(), orderService.getOrder(order.getId()).getQuantity());

    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateOrderDoesntExist() {
        System.out.println("updateOrder");
        Order order = new Order(1, product, 2);
        orderService.updateOrder(order);
    }

    /**
     * Test of removeOrder method, of class OrderService.
     */
    @Test
    public void testRemoveOrder() {
        System.out.println("removeOrder");
        Order order = new Order(1, product, 5);
        orderService.addOrder(order);
        assertFalse(orderService.getAllOrders().isEmpty());
        orderService.removeOrder(order.getId());
        assertTrue(orderService.getAllOrders().isEmpty());

    }

}
