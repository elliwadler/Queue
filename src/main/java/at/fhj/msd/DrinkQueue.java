package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DrinkQueue implements IDrinkQueue{

    private List<Drink> elements = new ArrayList<>();
    private int maxSize = 5;

    public DrinkQueue(int maxsize) {
        maxSize = maxsize;
    }

    /**
     * adds Element to queue
     *
     * @param obj
     * @return true if element can be added to queue, false if queue is full
     */
    @Override
    public boolean offer(Drink obj) {
        if (elements.size() != maxSize)
            elements.add(obj);
        else
            return false;

        return true;
    }

    /**
     * delete first Element in queue
     *
     * @return element if deletion was successful, otherwise null
     */
    @Override
    public Drink poll() {
        Drink element = peek();

        if (elements.size() != 0) {
            elements.remove(0);
        }

        return element;
    }

    @Override
    public Drink remove()
    {
        Drink element = poll();
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }

    @Override
    public Drink peek()
    {
        Drink element;
        if (elements.size() > 0)
            element = elements.get(0);
        else
            element = null;

        return element;
    }

    @Override
    public Drink element()
    {
        Drink element = peek();
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }
}
