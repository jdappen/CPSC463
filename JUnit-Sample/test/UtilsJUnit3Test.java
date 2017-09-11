/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.TestCase;
import sample.Utils;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author bigmanlaptop
 */
public class UtilsJUnit3Test extends TestCase {
    
    public UtilsJUnit3Test(String testName) {
        super(testName);
    }

    /**
     * Test of concatWords method, of class Utils.
     * @throws java.lang.Exception
     */
    @Override
protected void setUp() throws Exception {
    super.setUp();
    System.out.println("* UtilsJUnit3Test: setUp() method");
}

public void testHelloWorld() {
    System.out.println("* UtilsJUnitTest: test methhod 1 - testHelloWorld()");
    assertEquals("Hello, world!", Utils.concatWords("Hello", ", ", "world", "!"));
}


    /**
     * Test of computeFactorial method, of class Utils.
     * @throws java.lang.InterruptedException
     * @throws java.util.concurrent.TimeoutException
     */

public void testWithTimeout() throws InterruptedException, TimeoutException {
    System.out.println("* UtilsJUnit3Test: test method 2 - testWithTimeout()");
    final int factorialOf = 1 + (int) (30000 * Math.random());
    System.out.println("computing " + factorialOf + '!');

    Thread testThread;
        testThread = new Thread() {
            @Override
            public void run() {
                System.out.println(factorialOf + "! = " + Utils.computeFactorial(factorialOf));
            }

        };
            testThread.start();
            Thread.sleep(1000);
            testThread.interrupt();
            
            if (testThread.isInterrupted()) {
                throw new TimeoutException("the test took too long to complete");
            }
}

    /**
     * Test of normalizeWord method, of class Utils.
     */
public void DISABLED_testTemporarilyDisabled() throws Exception {
    System.out.println("* UtilsJUnit3Test: test method 4 - checkExpectedException()");
    assertEquals("Malm\u00f6", Utils.normalizeWord("Malmo\u0308"));
}
    
    public void testExpectedException() {
        System.out.println("* UtilsJUnit3Test: test method 3 - testExpectedException()");
    try {
        final int factorialOf = -5;
        System.out.println(factorialOf + "! = " + Utils.computeFactorial(factorialOf));
        fail("IllegalArgumentException was expected");
    } catch (IllegalArgumentException ex) {
    }
}
    
    @Override
protected void tearDown() throws Exception {
    super.tearDown();
    System.out.println("* UtilsJUnit3Test: tearDown() method");
}

}
