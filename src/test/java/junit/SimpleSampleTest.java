package junit;

import gherkin.lexer.Ca;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SimpleSampleTest {

    @Test
    public void simpleStringTest() {
        String testString = "CodersJava";
        assertTrue(testString.startsWith("Code"));
    }

    @Test
    public void simpleTestList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        assertEquals(4, list.size());
        assertEquals(list.get(1), Integer.valueOf(2));
        assertEquals(list.get(3), Integer.valueOf(4));
    }

    @Test
    public void popsutyTest() {
        assertEquals("5 nie jest rowne 2*2, a Ziemia nie jest plaska",5, 2*2);
    }

    @Test
    public void mykZDokladnoscia() {
        //assertEquals(3.33, 10.0/3.0, 0);
        assertEquals(3.33, 10.0/3.0, 0.01);
    }

    @Test
    public void assertSameIsTricky() {
        Cat catA = new Cat("Burek");
        Cat catB = new Cat("Burek");

        assertSame(catA, catB);
    }
}

class Cat {

    String name;

    public Cat(String name) {
        this.name = name;
    }
}