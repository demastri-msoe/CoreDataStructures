package stacksandqueues;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stacksandqueues.inclass.InClassQueue;

import java.util.NoSuchElementException;

public class TestQueue {
    final boolean doInClassTests = true;

    @Test
    public void offerTest() {
        doOfferTest(new SimpleQueue<>(false));
        doOfferTest(new SimpleQueue<>(true));
        doOfferTest(new CircularQueue<>());
        if(doInClassTests)
            doOfferTest(new InClassQueue<>());
    }
    @Test
    public void peekTest() {
        doPeekTest(new SimpleQueue<>(false));
        doPeekTest(new SimpleQueue<>(true));
        doPeekTest(new CircularQueue<>());
        if(doInClassTests)
            doPeekTest(new InClassQueue<>());
    }
    @Test
    public void pollTest() {
        doPollTest(new SimpleQueue<>(false));
        doPollTest(new SimpleQueue<>(true));
        doPollTest(new CircularQueue<>());
        if(doInClassTests)
            doPollTest(new InClassQueue<>());
    }
    @Test
    public void elementTest() {
        doElementTest(new SimpleQueue<>(false));
        doElementTest(new SimpleQueue<>(true));
        doElementTest(new CircularQueue<>());
        if(doInClassTests)
            doElementTest(new InClassQueue<>());
    }
    @Test
    public void removeTest() {
        doRemoveTest(new SimpleQueue<>(false));
        doRemoveTest(new SimpleQueue<>(true));
        doRemoveTest(new CircularQueue<>());
        if(doInClassTests)
            doRemoveTest(new InClassQueue<>());
    }

    @Test
    public void performanceTest() {
        doPerfTest(new SimpleQueue<>(true), "LL");
        doPerfTest(new SimpleQueue<>(false), "AL");
        doPerfTest(new CircularQueue<>(), "CQ");
        if(doInClassTests)
            doPerfTest(new InClassQueue<>(), "ICQ");
    }


    public void doOfferTest(PureQueue<Integer> s) {
        Assertions.assertNull(s.peek());
        Assertions.assertNull(s.poll());
        Assertions.assertTrue(s.offer(new Integer(3)));
        Assertions.assertEquals(3, s.peek().intValue());
        Assertions.assertTrue(s.offer(new Integer(5)));
        Assertions.assertEquals(3, s.peek().intValue());
        Assertions.assertTrue(s.offer(new Integer(7)));
        Assertions.assertEquals(3, s.peek().intValue());
        Assertions.assertEquals(3, s.poll().intValue());
        Assertions.assertEquals(5, s.peek().intValue());
        Assertions.assertEquals(5, s.poll().intValue());
        Assertions.assertEquals(7, s.peek().intValue());
        Assertions.assertEquals(7, s.poll().intValue());
        Assertions.assertNull(s.peek());
        Assertions.assertNull(s.poll());
    }

    public void doPeekTest(PureQueue<Integer> s) {
        Assertions.assertNull(s.peek());
        s.offer(5);
        Assertions.assertEquals(5, s.peek().intValue());
        s.offer(7);
        Assertions.assertEquals(5, s.peek().intValue());
        s.offer(9);
        Assertions.assertEquals(5, s.peek().intValue());
        Assertions.assertEquals(5, s.poll().intValue());
        Assertions.assertEquals(7, s.peek().intValue());
        Assertions.assertEquals(7, s.poll().intValue());
        Assertions.assertEquals(9, s.peek().intValue());
        Assertions.assertEquals(9, s.poll().intValue());
        Assertions.assertNull(s.peek());
        Assertions.assertNull(s.poll());
    }

    public void doPollTest(PureQueue<Integer> s) {
        Assertions.assertNull(s.peek());
        Assertions.assertNull(s.poll());
        Assertions.assertTrue(s.offer(new Integer(3)));
        Assertions.assertEquals(3, s.peek().intValue());
        Assertions.assertTrue(s.offer(new Integer(5)));
        Assertions.assertEquals(3, s.peek().intValue());
        Assertions.assertTrue(s.offer(new Integer(7)));
        Assertions.assertEquals(3, s.peek().intValue());
        Assertions.assertEquals(3, s.poll().intValue());
        Assertions.assertEquals(5, s.peek().intValue());
        Assertions.assertEquals(5, s.poll().intValue());
        Assertions.assertEquals(7, s.peek().intValue());
        Assertions.assertEquals(7, s.poll().intValue());
        Assertions.assertNull(s.peek());
        Assertions.assertNull(s.poll());
    }

    public void doElementTest(PureQueue<Integer> s) {
        Assertions.assertNull(s.peek());
        Assertions.assertThrows(NoSuchElementException.class, () -> s.element());
        Assertions.assertTrue(s.offer(new Integer(3)));
        Assertions.assertEquals(3, s.element().intValue());
        Assertions.assertTrue(s.offer(new Integer(5)));
        Assertions.assertEquals(3, s.element().intValue());
        Assertions.assertTrue(s.offer(new Integer(7)));
        Assertions.assertEquals(3, s.element().intValue());
        Assertions.assertEquals(3, s.poll().intValue());
        Assertions.assertEquals(5, s.element().intValue());
        Assertions.assertEquals(5, s.poll().intValue());
        Assertions.assertEquals(7, s.element().intValue());
        Assertions.assertEquals(7, s.poll().intValue());
        Assertions.assertNull(s.peek());
        Assertions.assertThrows(NoSuchElementException.class, () -> s.element());
    }

    public void doRemoveTest(PureQueue<Integer> s) {
        Assertions.assertNull(s.poll());
        Assertions.assertThrows(NoSuchElementException.class, () -> s.remove());
        Assertions.assertNull(s.peek());
        Assertions.assertThrows(NoSuchElementException.class, () -> s.element());
        Assertions.assertTrue(s.offer(new Integer(3)));
        Assertions.assertEquals(3, s.element().intValue());
        Assertions.assertTrue(s.offer(new Integer(5)));
        Assertions.assertEquals(3, s.element().intValue());
        Assertions.assertTrue(s.offer(new Integer(7)));
        Assertions.assertEquals(3, s.element().intValue());
        Assertions.assertEquals(3, s.remove().intValue());
        Assertions.assertEquals(5, s.element().intValue());
        Assertions.assertEquals(5, s.remove().intValue());
        Assertions.assertEquals(7, s.element().intValue());
        Assertions.assertEquals(7, s.remove().intValue());
        Assertions.assertNull(s.poll());
        Assertions.assertThrows(NoSuchElementException.class, () -> s.remove());
        Assertions.assertNull(s.peek());
        Assertions.assertThrows(NoSuchElementException.class, () -> s.element());
    }

    private void doPerfTest(PureQueue<Integer> queue, String tag) {
        int testSize = 100;
        int batchSize = 106;

        long startTime = System.nanoTime();
        for( int i=0; i<testSize; i++) {
            for( int j=0; j<batchSize; j++) {
                Assertions.assertTrue(queue.offer(new Integer(j)));
            }
            for( int j=0; j<batchSize; j++) {
                Assertions.assertEquals(0, queue.peek());
            }
            for( int j=0; j<batchSize; j++) {
                Assertions.assertEquals(j, queue.poll());
            }
        }
        long stopTime = System.nanoTime();
        System.out.println("Queues: "+tag+" Time (ms): "+(stopTime-startTime)/1000000.0);

    }


}
