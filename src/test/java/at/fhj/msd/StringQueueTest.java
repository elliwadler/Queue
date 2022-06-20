package at.fhj.msd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class StringQueueTest
{
    private String simpleString;
    private StringQueue StringQueue;

    @BeforeEach
    public void setup(){
        simpleString = "testString";
        StringQueue = new StringQueue(1);
    }

    /**
     * Add new String to queue
     * @result String will be added and true returned
     */
    @Test
    public void addElementToEmptyQueue(){
        Assertions.assertTrue(StringQueue.offer(simpleString));
    }

    /**
     * Add new String to full queue
     * @result String will not be added and false returned
     */
    @Test
    public void addElementToFullQueue(){
        StringQueue.offer(simpleString);
        Assertions.assertFalse(StringQueue.offer(simpleString));
    }

    /**
     * Fetch String from empty queue
     * @result null is returned, queue is empty
     */
    @Test
    public void peekIsNullForEmptyQueue(){
        Assertions.assertNull(StringQueue.peek());
    }

    /**
     * Delete String from empty queue
     * @result nothing will happen, null is returned
     */
    @Test
    public void pollIsNullForEmptyQueue(){
        Assertions.assertNull(StringQueue.peek());
    }

    /**
     * Delete String from queue
     * @result element will be removed and returned
     */
    @Test
    public void pollFetchedCorrectElement(){
        StringQueue.offer(simpleString);
        String pollResult = StringQueue.poll();

        Assertions.assertEquals(simpleString, pollResult);
    }

    /**
     * Delete String from empty queue
     * @result nothing will happen, null is returned
     */
    @Test
    public void removeFromEmptyQueue(){
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> StringQueue.remove());
    }

    /**
     * Delete String from queue
     * @result element will be removed and returned
     */
    @Test
    public void removeElementFromQueue(){
        StringQueue.offer(simpleString);
        String pollResult = StringQueue.remove();

        Assertions.assertEquals(simpleString, pollResult);
    }

    /**
     * Fetch String from queue
     * @result element will stay in queue and will be returned
     */
    @Test
    public void peekFetchCorrectElement()
    {
        StringQueue.offer(simpleString);
        String peekResult1 = StringQueue.peek();
        String peekResult2 = StringQueue.peek();

        Assertions.assertEquals(simpleString, peekResult1);
        Assertions.assertEquals(peekResult1, peekResult2);
    }

    /**
     * fetch element from empty queue
     * @result no element in queue, so exception will be returned
     */
    @Test
    public void getElementFromEmptyQueue(){
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> StringQueue.element());
    }

    /**
     * Fetch element from queue
     * @result element will be fetched and returned
     */
    @Test
    public void getElementFromQueue(){
        StringQueue.offer(simpleString);
        String pollResult = StringQueue.element();

        Assertions.assertEquals(simpleString, pollResult);
    }
}
