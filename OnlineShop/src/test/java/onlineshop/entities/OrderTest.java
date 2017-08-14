/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineshop.entities;

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
public class OrderTest {

    private Order order;
    private long id;
    private int quantity;
    private Product productType;

    public OrderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        productType = new Product(1, "type", "test description", 10);
        order = new Order(id, productType, quantity);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Order.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        assertEquals(id, order.getId().longValue());
    }

    
    /**
     * Test of getPtrProduct method, of class Order.
     */
    @Test
    public void testGetPtrProduct() {
        System.out.println("getPtrProduct");
        assertEquals(productType.getId(), order.getPtrProduct());
    }

    /**
     * Test of setPtrProduct method, of class Order.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetPtrProductNull() {
        System.out.println("testSetPtrProductNull");
        Order instance = new Order();
        instance.setPtrProduct(null);
    }


    /**
     * Test of getQuantity method, of class Order.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        assertEquals(quantity, order.getQuantity());
    }

    /**
     * Test of setQuantity method, of class Order.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetQuantityNegative() {
        System.out.println("testSetQuantityNegative");
        Order instance = new Order();
        instance.setQuantity(-1);
    }

    /**
     * Test of setQuantity method, of class Order.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetQuantityZero() {
        System.out.println("testSetQuantityZero");
        Order instance = new Order();
        instance.setQuantity(0);
    }

}
