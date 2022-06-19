package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DrinkQueue implements IDrinkQueue{

    private List<Drink> elements = new ArrayList<>();
    private int maxSize = 5;

    @Override
    public boolean offer(Drink obj)
    {
        return false;
    }

    @Override
    public Drink poll()
    {
        return null;
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
