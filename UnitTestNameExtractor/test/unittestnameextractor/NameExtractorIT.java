/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittestnameextractor;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bigmanlaptop
 */
public class NameExtractorIT {
    
    public NameExtractorIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of ExtractWords method, of class NameExtractor.
     */
    @Test
    public void Test2() {
        NameExtractor testObj = new NameExtractor();
        testObj.setFullName("John Brown");
        testObj.ParseName();
        
        assertEquals("", testObj.getTitle());
        assertEquals("John", testObj.getFirstName());
        assertEquals("", testObj.getMiddleName());
        assertEquals("Brown", testObj.getLastName());
        assertEquals("", testObj.getSuffix());
        testObj.setFullName("Mr. John Brown");

        
        assertEquals("Mr.", testObj.getTitle());
        assertEquals("John", testObj.getFirstName());
        assertEquals("", testObj.getMiddleName());
        assertEquals("Brown", testObj.getLastName());
        assertEquals("", testObj.getSuffix());
        
        testObj.setFullName("John Brown, PhD");
        assertEquals("John", testObj.getFirstName());
        assertEquals("Brown", testObj.getLastName());
        assertEquals("PhD", testObj.getSuffix());
        
        fail("The test case is a prototype.");
    }
    
}
