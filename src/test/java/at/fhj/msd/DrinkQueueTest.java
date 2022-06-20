package at.fhj.msd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DrinkQueueTest {
    private SimpleDrink simpleDrink;
    private DrinkQueue drinkQueue;
    private DrinkQueue drinkQueue2;

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
    public void drinkQueueTest1(){
        Assertions.assertEquals(true, drinkQueue.offer(simpleDrink));
    }

    /**
     * Add new Drink to full queue
     * @result drink will not be added and false returned
     */
    @Test
    public void drinkQueueTest2(){
        drinkQueue.offer(simpleDrink);
        Assertions.assertEquals(false, drinkQueue.offer(simpleDrink));
    }

    /**
     * Delete drink from queue
     * @result drink will be deleted and returned
     */
    @Test
    public void drinkQueueTest3(){
        Assertions.assertEquals(drinkQueue.peek(), drinkQueue.poll());
    }

    /**
     * Delete drink from empty queue
     * @result null will be returned
     */
    @Test
    public void drinkQueueTest5(){
        drinkQueue.poll();
        Assertions.assertEquals(null, drinkQueue.poll());
    }

}
