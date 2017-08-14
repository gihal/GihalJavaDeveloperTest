/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineshop.services;

import onlineshop.entities.Product;
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
public class ProductServiceTest {

    private ProductService productService;

    public ProductServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        productService = new ProductService();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getProduct method, of class ProductService.
     */
    @Test
    public void testGetProduct() {
        System.out.println("getProduct");
        Product expResult = productService.getAllProducts().get(0);//get the first element
        long productId = expResult.getId();
        Product result = productService.getProduct(productId);
    }

    /**
     * Test of updateProduct method, of class ProductService.
     */
    @Test
    public void testUpdateProduct() {
        System.out.println("updateProduct");
        Product product = productService.getAllProducts().get(0);//get the first element
        int initialnumberOfItems = product.getAvailableItems();
        product.setAvailableItems(initialnumberOfItems + 6);
        productService.updateProduct(product);
        assertEquals(initialnumberOfItems + 6, product.getAvailableItems());
        assertNotEquals(initialnumberOfItems, product.getAvailableItems());
    }

}
