package stacksandqueues;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stacksandqueues.inclass.InClassQueue;
import stacksandqueues.inclass.InClassStack;

public class TestStack {
    final boolean doInClassTests = true;

    @Test
    public void isEmptyTest() {
        doEmptyTest(new SimpleStack<Integer>(true) );
        doEmptyTest(new SimpleStack<Integer>(false) );
        doEmptyTest(new DynamicArrayStack<Integer>() );
        if(doInClassTests)
            doEmptyTest(new InClassStack<>());
    }
    private void doEmptyTest(PureStack<Integer> s) {
        Assertions.assertTrue(s.isEmpty());
        s.push(5);
        Assertions.assertFalse(s.isEmpty());
        Assertions.assertEquals(5, s.peek().intValue());
        Assertions.assertFalse(s.isEmpty());
        Assertions.assertEquals(5, s.pop().intValue());
        Assertions.assertTrue(s.isEmpty());
    }

    @Test
    public void peekTest() {
        doPeekTest(new SimpleStack<Integer>(true) );
        doPeekTest(new SimpleStack<Integer>(false) );
        doPeekTest(new DynamicArrayStack<Integer>() );
        if(doInClassTests)
            doPeekTest(new InClassStack<>());
    }
    private void doPeekTest(PureStack<Integer> s) {
        Assertions.assertNull(s.peek());
        s.push(5);
        Assertions.assertEquals(5, s.peek().intValue());
        s.push(7);
        Assertions.assertEquals(7, s.peek().intValue());
        s.push(9);
        Assertions.assertEquals(9, s.peek().intValue());
        Assertions.assertEquals(9, s.pop().intValue());
        Assertions.assertEquals(7, s.peek().intValue());
        Assertions.assertEquals(7, s.pop().intValue());
        Assertions.assertEquals(5, s.peek().intValue());
        Assertions.assertEquals(5, s.pop().intValue());
        Assertions.assertNull(s.peek());
        Assertions.assertNull(s.pop());
    }

    @Test
    public void popTest() {
        doPopTest(new SimpleStack<Integer>(true) );
        doPopTest(new SimpleStack<Integer>(false) );
        doPopTest(new DynamicArrayStack<Integer>() );
        if(doInClassTests)
            doPopTest(new InClassStack<>());
    }
    private void doPopTest(PureStack<Integer> s) {
        Assertions.assertNull(s.pop());
        Assertions.assertEquals(3, s.push(new Integer(3)).intValue());
        Assertions.assertEquals(5, s.push(new Integer(5)).intValue());
        Assertions.assertEquals(7, s.push(7).intValue());
        Assertions.assertEquals(7, s.pop().intValue());
        Assertions.assertEquals(5, s.pop().intValue());
        Assertions.assertEquals(3, s.pop().intValue());
        Assertions.assertNull(s.pop());
    }

    @Test
    public void pushTest() {
        doPushTest(new SimpleStack<Integer>(false) );
        doPushTest(new SimpleStack<Integer>(true) );
        doPushTest(new DynamicArrayStack<Integer>() );
        if(doInClassTests)
            doPushTest(new InClassStack<>());
    }
    private void doPushTest(PureStack<Integer> s) {
        Assertions.assertNull(s.peek());
        Assertions.assertNull(s.pop());
        Assertions.assertEquals(3, s.push(new Integer(3)).intValue());
        Assertions.assertEquals(3, s.peek().intValue());
        Assertions.assertEquals(5, s.push(new Integer(5)).intValue());
        Assertions.assertEquals(5, s.peek().intValue());
        Assertions.assertEquals(7, s.push(7).intValue());
        Assertions.assertEquals(7, s.peek().intValue());
        Assertions.assertEquals(7, s.pop().intValue());
        Assertions.assertEquals(5, s.pop().intValue());
        Assertions.assertEquals(3, s.pop().intValue());
        Assertions.assertNull(s.peek());
        Assertions.assertNull(s.pop());
    }


    @Test
    public void postFixTest() {
        String[][] eval = {{"4", "7", "*"}, {"3", "4", "7", "*", "2", "/", "+"}};

        int[] results = new int[]{28, 17};

        for (int i = 0; i < results.length; i++) {
            int retVal = postFixEval(eval[i]);
            Assertions.assertEquals(retVal, results[i]);
        }
    }


    @Test
    public void palindromeTest() {
        String[] testWords =
                {"abcdefg", "wow", "mom",
                        "1234321", "12 344!!321",
                        "A man, a plan, a canal. Panama!",
                        "Amen, Icy Cinema", // title for below verse, also a palindrome...
                        "Amen, I can! I stop elastic ire To see La Dolce Vita." +
                                "Covet?  I moisten nose, Sonnets I omit, evocative clod! Ale? Esoteric?" +
                                "It's ale! Pots in a cinema!",
                        "why would this be a palindrome - it isn't!"};
        boolean[] results =
                {false, true, true,
                        true, true,
                        true,
                        true,
                        true,
                        false};

        for (int i = 0; i < testWords.length; i++) {
            String w = testWords[i];
            w = w.replaceAll("[ !\\?\\.,']", "")
                    .toLowerCase();
            boolean result = results[i];

            SimpleStack<Character> s = new SimpleStack<>();
            String outString = "";
            for (char c : w.toCharArray()) {
                s.push(c);
            }
            while (!s.isEmpty()) {
                char c = s.pop();
                outString += Character.toString(c);
            }
            if (result) {
                Assertions.assertEquals(outString, w);
            } else {
                Assertions.assertNotEquals(outString, w);
            }
        }
    }


    @Test
    public void performanceTest() {
        doPerfTest(new SimpleStack<>(true), "LL");
        doPerfTest(new SimpleStack<>(false), "AL");
        doPerfTest(new DynamicArrayStack<>(), "DA");
        if(doInClassTests)
            doPerfTest(new InClassStack<>(), "ICQ");
    }

    private void doPerfTest(PureStack<Integer> s, String tag) {
        int testSize = 100000;
        int batchSize = 50;

        long startTime = System.nanoTime();
        for (int i = 0; i < testSize; i++) {
            for (int j = 0; j < batchSize; j++) {
                Assertions.assertEquals(j, s.push(new Integer(j)));
            }
            for (int j = 0; j < batchSize; j++) {
                Assertions.assertEquals(batchSize-1, s.peek());
            }
            for (int j = 0; j < batchSize; j++) {
                Assertions.assertEquals(batchSize-j-1, s.pop());
            }
        }
        long stopTime = System.nanoTime();
        System.out.println("Stacks: "+tag+" Time (ms): " + (stopTime - startTime) / 1000000.0);
    }

    private int postFixEval(String[] sa) {
        SimpleStack<String> stack = new SimpleStack<>();
        for (String s : sa) {
            switch (s) {
                case "+":
                    stack.push(String.valueOf(Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop())));
                    break;
                case "-":
                    int subtrahend = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(Integer.parseInt(stack.pop()) - subtrahend));
                    break;
                case "/":
                    int divisor = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(Integer.parseInt(stack.pop()) / divisor));
                    break;
                case "*":
                    stack.push(String.valueOf(Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop())));
                    break;
                default:
                    stack.push(s);
                    break;
            }
        }
        return Integer.parseInt(stack.pop());
    }


}
