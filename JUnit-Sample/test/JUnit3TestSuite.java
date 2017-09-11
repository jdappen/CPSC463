/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author bigmanlaptop
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({UtilsJUnit4Test.class, VectorsJUnit3Test.class, VectorsJUnit4Test.class, UtilsJUnit3Test.class})
public class JUnit3TestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
