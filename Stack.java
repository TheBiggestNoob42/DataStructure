import java.util.ArrayList;
/*
public class Stack<E>// extends
{
    private ArrayList<E> arrayList;

    public Stack()
    {
        arrayList = new ArrayList<>();
    }

    public void push(E obj)
    {
        arrayList.add(obj);
    }

    public E pop()
    {
        return arrayList.remove(arrayList.size() - 1);
    }

    public boolean isEmpty()
    {
        return arrayList.isEmpty();
    }

    public E peek()
    {
        return arrayList.get(arrayList.size() - 1);
    }
}
*/

public class Stack<E>// extends
{
    private LinkedList<E> linkedList;

    public Stack()
    {
        linkedList = new LinkedList<>();
    }

    public void push(E obj)
    {
        linkedList.add(obj);
    }

    public E pop() throws Exception
    {
        return linkedList.remove(0);
    }

    public boolean isEmpty()
    {
        return linkedList.isEmpty();
    }

    public E peek() throws Exception
    {
        return linkedList.get(0);
    }

    public int size() {
        return linkedList.size();
    }
}
