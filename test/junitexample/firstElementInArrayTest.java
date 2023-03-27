package junitexample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class firstElementInArrayTest {

    @Test
    public void basicSearchTest() {
        FindFirstElementInArray myObj = new FindFirstElementInArray();

        List<String> myList = new ArrayList<>();
        myList.add("abc");
        myList.add("def");
        myList.add("ghi");

        String outString = myObj.findEltInArray( myList, "abc");
        Assertions.assertNotNull(outString);

        String someString = (new String("a")+new String("b")+new String("c"));

        outString = myObj.findEltInArray( myList, someString);
        Assertions.assertNotNull(outString);
    }

    @Test    public void elementNotInArray() {
        Assertions.fail();
    }

    @Test
    public void elementFirstInArray() {
        Assertions.fail();
    }

    @Test
    public void elementLastInArray() {
        Assertions.fail();
    }

    @Test
    public void arrayEmptyTest() {
        Assertions.fail();
    }

    @Test
    public void arrayHasOneElementTest() {
        Assertions.fail();
    }
}
