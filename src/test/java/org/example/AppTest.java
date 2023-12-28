package org.example;


import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    @Test(testName = "verify 1 is 1 its true", description = "this test for verify 1 is 1")
    public void testApp() {
        assertEquals(1, 1);
    }

    @Test(testName = "verify 1 is 2 its false", description = "this test for verify 1 is 1")
    public void shouldReturnFalse() {
        assertEquals(1, 1);
    }

}
//    extends TestCase
//{
//    /**
//     * Create the test case
//     *
//     * @param testName name of the test case
//     */
//    public AppTest( String testName )
//    {
//        super( testName );
//    }
//
//    /**
//     * @return the suite of tests being tested
//     */
//    public static Test suite()
//    {
//        return new TestSuite( AppTest.class );
//    }
//
//    /**
//     * Rigourous Test :-)
//     */
//    public void testApp()
//    {
//        assertTrue( true );
//    }
//}
