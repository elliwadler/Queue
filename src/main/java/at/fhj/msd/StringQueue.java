package at.fhj.msd;

import at.fhj.msd.IQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// there's some Bugs included, try to debug the code and fix the Bugs
// there are different Bugs, wrong implementation, typos, ...
// write Test-Cases (read Queue Interface for understanding methods) and use Debugging possibilies of your IDE
/**
 * Class represents a queue of Strings
 */
public class StringQueue implements IQueue {

  private List<String> elements = new ArrayList<String>();
  private int maxSize = 5;

  public StringQueue(int maxsize) {
    //1st Error - variable 'maxSize' typing error
    maxSize = maxsize;
  }
  /**
   * adds Element to queue
   *
   * @param obj
   * @return true if element can be added to queue, false if queue is full
   */
  @Override
  public boolean offer(String obj) {
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
  public String poll() {
    String element = peek();

    //2nd Error - '==' makes no sense
    if (elements.size() != 0) {
      elements.remove(0);
    }

    return element;
  }
  /**
   * delete first Element in queue
   *
   * @return element if deletion was successful, otherwise Exception
   */
  @Override
  public String remove() {
    String element = poll();
    //3rd Error - 'element = ""';
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }

  /**
   * get first element
   *
   * @return first element in queue, if queue empty null
   */
  @Override
  public String peek() {
    String element;
    if (elements.size() > 0)
      element = elements.get(0);
    else
      element = null;

    return element;
  }

  /**
   * get first element
   *
   * @return first element in queue, if queue empty throw Exception
   */
  @Override
  public String element() {
    String element = peek();
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }

}

