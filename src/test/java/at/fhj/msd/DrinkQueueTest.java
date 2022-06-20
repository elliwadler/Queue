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
        drinkQueue2 = new DrinkQueue(0);
    }
    @Test
    public void drinkQueueTest1(){
        Assertions.assertEquals(true, drinkQueue.offer(simpleDrink));
    }
    @Test
    public void drinkQueueTest2(){
        Assertions.assertEquals(false, drinkQueue2.offer(simpleDrink));
    }
    @Test
    public void drinkQueueTest3(){
        Assertions.assertEquals(drinkQueue.peek(), drinkQueue.poll());
    }
    @Test
    public void drinkQueueTest4(){
        Assertions.assertEquals(drinkQueue2.peek(), drinkQueue2.poll());
    }
    @Test
    public void drinkQueueTest5(){
        Assertions.assertEquals(null, drinkQueue2.poll());
    }

}
