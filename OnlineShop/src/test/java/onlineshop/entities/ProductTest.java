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
public class ProductTest {

    private Product product;
    private final long id = 1;
    private final String name = "Test";
    private final String description = "Test product description";
    private final int availableItems = 10;

    public ProductTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        product = new Product(id, name, description, availableItems);        
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Product.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        assertEquals(id, product.getId());
    }


    /**
     * Test of getName method, of class Product.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        assertEquals(name, product.getName());
    }

    /**
     * Test of testSetName method, of class Product.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetNameNull() {
        System.out.println("test setName with empty null");
        Product instance = new Product();
        instance.setName(null);
    }

    /**
     * Test of testSetName method, of class Product.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetNameEmpty() {
        System.out.println("test setName with empty String");
        Product instance = new Product();
        instance.setName("");
    }

    /**
     * Test of getAvailableItems method, of class Product.
     */
    @Test
    public void testGetAvailableItems() {
        System.out.println("getAvailableItems");
        assertEquals(availableItems, product.getAvailableItems());
    }

    /**
     * Test of setAvailableItems method, of class Product.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetAvailableItemsNegative() {
        System.out.println("test setAvailableItems with a negative number");
        Product instance = new Product();
        instance.setAvailableItems(-1);
    }


    /**
     * Test of getDescription method, of class Product.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        assertEquals(description, product.getDescription());
    }

    /**
     * Test of setDescription method, of class Product.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDescriptionNull() {
        System.out.println("test setDescription with null");
        Product instance = new Product();
        instance.setDescription(null);
    }

    /**
     * Test of setDescription method, of class Product.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDescriptionEmpty() {
        System.out.println("test setDescription with empty");
        Product instance = new Product();
        instance.setDescription("");
    }

}
