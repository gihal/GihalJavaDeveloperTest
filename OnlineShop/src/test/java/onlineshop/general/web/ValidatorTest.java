/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineshop.general.web;

import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author gihal
 */
public class ValidatorTest extends Mockito{
    HttpServletRequest request;
    public ValidatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        request = mock(HttpServletRequest.class);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getLong method, of class Validator.
     */
    @Test
    public void testGetLong() {
        System.out.println("getLong");
        String parameter = "param";
        long value = 15L;
        when(request.getParameter(parameter)).thenReturn("15");
        Validator validator = new Validator(request);
        long result = validator.parameter(parameter).getLong();
        assertEquals(value, result);
        result = validator.parameter(parameter).optional().getLong();
        assertEquals(value, result);
        assertNull(validator.parameter("newparam").optional().getLong()); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetLongWithInvalidNumer() {
        System.out.println("getLong");
        String parameter = "param";        
        when(request.getParameter(parameter)).thenReturn("invalid long");
        Validator validator = new Validator(request);
        long result = validator.parameter(parameter).getLong();        
    }

    /**
     * Test of getString method, of class Validator.
     */
    @Test
    public void testGetString() {
        System.out.println("getString");
        String parameter = "param";
        String value = "test";
        when(request.getParameter(parameter)).thenReturn(value);
        Validator validator = new Validator(request);
        String result = validator.parameter(parameter).getString();        
        assertEquals(value, result); 
        result = validator.parameter(parameter).optional().getString(); 
        assertEquals(value, result);
        assertNull(validator.parameter("newparam").optional().getString());  
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetStringNotOptiona() {
        System.out.println("getString");
        Validator validator = new Validator(request);        
        assertNull(validator.parameter("param").getString());  
    }
    
}
