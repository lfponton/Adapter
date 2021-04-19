package stringqueue;

import java.util.ArrayList;

public class Queue implements StringQueue
{
  private int capacity;
  private ArrayList<String> queue;

  public Queue(int capacity)
  {
    queue = new ArrayList<>(capacity);
  }

  public String toString()
  {
    String str = "{";

    int count = 0;
    for(String s : queue)
    {
      count++;
      System.out.println(count);
      if(count == queue.size())
      {
        str += s + "}";
      }
      else
      {
        str += s + ", ";
      }
    }
    return str;
  }

  @Override public void enqueue(String element)
  {
    if(element == null) throw new IllegalArgumentException("Cannot enqueue null");
    queue.add(element);
  }

  @Override public String dequeue()
  {
    if(queue.isEmpty()) throw new IllegalStateException("Queue is empty");
    return queue.remove(0);
  }

  @Override public String first()
  {
    if(queue.isEmpty()) throw new IllegalStateException("Queue is empty");
    return queue.get(0);
  }

  @Override public int size()
  {
    return queue.size();
  }

  @Override public boolean isEmpty()
  {
    return queue.isEmpty();
  }

  @Override public int indexOf(String element)
  {
    return queue.indexOf(element);
  }

  @Override public boolean contains(String element)
  {
    return queue.contains(element);
  }
}
