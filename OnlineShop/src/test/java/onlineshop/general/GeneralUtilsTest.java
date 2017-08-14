package onlineshop.general;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author gihal
 */
public class GeneralUtilsTest {

    public GeneralUtilsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isNullOrBlank method, of class GeneralUtils.
     */
    @Test
    public void testIsNullOrBlank() {
        System.out.println("isNullOrBlank");
        assertTrue(GeneralUtils.isNullOrBlank(null));
        assertTrue(GeneralUtils.isNullOrBlank(""));
        assertTrue(GeneralUtils.isNullOrBlank("  "));
        assertFalse(GeneralUtils.isNullOrBlank("test"));
    }

    

}
