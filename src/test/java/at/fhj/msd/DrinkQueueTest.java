package at.fhj.msd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class DrinkQueueTest {
    private SimpleDrink simpleDrink;
    private DrinkQueue drinkQueue;

    @BeforeEach
    public void setup(){
        simpleDrink = new SimpleDrink("Test", new Liquid("TestLiquid",0.5,12));
        drinkQueue = new DrinkQueue(1);
    }

    /**
     * Add new Drink to queue
     * @result drink will be added and true returned
     */
    @Test
    public void addElementToEmptyQueue(){
        Assertions.assertTrue(drinkQueue.offer(simpleDrink));
    }

    /**
     * Add new Drink to full queue
     * @result drink will not be added and false returned
     */
    @Test
    public void addElementToFullQueue(){
        drinkQueue.offer(simpleDrink);
        Assertions.assertFalse(drinkQueue.offer(simpleDrink));
    }

    /**
     * Fetch drink from empty queue
     * @result null is returned, queue is empty
     */
    @Test
    public void peekIsNullForEmptyQueue(){
        Assertions.assertNull(drinkQueue.peek());
    }

    /**
     * Delete drink from empty queue
     * @result nothing will happen, null is returned
     */
    @Test
    public void pollIsNullForEmptyQueue(){
        Assertions.assertNull(drinkQueue.peek());
    }

    /**
     * Delete drink from queue
     * @result element will be removed and returned
     */
    @Test
    public void pollFetchedCorrectElement(){
        drinkQueue.offer(simpleDrink);
        Drink pollResult = drinkQueue.poll();

        Assertions.assertEquals(simpleDrink, pollResult);
    }

    /**
     * Delete drink from empty queue
     * @result nothing will happen, null is returned
     */
    @Test
    public void removeFromEmptyQueue(){
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> drinkQueue.remove());
    }

    /**
     * Delete drink from queue
     * @result element will be removed and returned
     */
    @Test
    public void removeElementFromQueue(){
        drinkQueue.offer(simpleDrink);
        Drink pollResult = drinkQueue.remove();

        Assertions.assertEquals(simpleDrink, pollResult);
    }

    /**
     * Fetch drink from queue
     * @result element will stay in queue and will be returned
     */
    @Test
    public void peekFetchCorrectElement()
    {
        drinkQueue.offer(simpleDrink);
        Drink peekResult1 = drinkQueue.peek();
        Drink peekResult2 = drinkQueue.peek();

        Assertions.assertEquals(simpleDrink, peekResult1);
        Assertions.assertEquals(peekResult1, peekResult2);
    }

    /**
     * fetch element from empty queue
     * @result no element in queue, so exception will be returned
     */
    @Test
    public void getElementFromEmptyQueue(){
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> drinkQueue.element());
    }

    /**
     * Fetch element from queue
     * @result element will be fetched and returned
     */
    @Test
    public void getElementFromQueue(){
        drinkQueue.offer(simpleDrink);
        Drink pollResult = drinkQueue.element();

        Assertions.assertEquals(simpleDrink, pollResult);
    }
}
