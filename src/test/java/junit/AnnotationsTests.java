package junit;

import org.junit.*;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AnnotationsTests {

    private static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("setUpBeforeClass()");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("tearDownAfterClass()");
    }

    @Before
    public void setUp() {
        System.out.println("setUp()");
    }

    @After
    public void tearDown() {
        System.out.println("tearDown()");
    }

    @Test
    public void testOne() {
        System.out.println("testOne()");
    }

    @Test
    public void testTwo() {
        System.out.println("testTwo()");
    }

    @Ignore("Bedzie poprawiony po 20.03.2021 - zmiany czegostam.")
    @Test
    public void testThree() {
        System.out.println("testThree()");
    }

    //NoSuchElementException
    @Test
    public void testNoElement() {
        try{
            //szukamy elementu
            // elementu nie ma - pojawia NoSuchElementException
            throw new NoSuchElementException("");
        } catch (NoSuchElementException e) {
            // elementu nie ma - tego sie spodziewalismy
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoElement2() {
        throw new NoSuchElementException("");
    }
}
