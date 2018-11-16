import java.util.Scanner;

public class Stack__Tester
{
    public static void main(String... args) throws Exception
    {
        Stack obj = new Stack();
        obj.push(1);
        obj.push("2");
        obj.push(3.0);

        while(!obj.isEmpty())
        {
            System.out.println("The top of the stack is " +obj.pop() + ". The stack is " + (obj.isEmpty() ? "": "not ") + "empty.");
        }

        System.out.println();

        LinkedList newObj = new LinkedList();
        newObj.add(1);
        newObj.add("2");
        newObj.add(3.0);

        while(!newObj.isEmpty())
        {
            System.out.println("The first node is " + newObj.remove(newObj.size() - 1) + ". The list is " + (newObj.isEmpty() ? "": "not ") + "empty.");
        }

        System.out.println("The list has " + newObj.size() + " elements. The list is " + (newObj.isEmpty() ? "": "not ") + "empty.");

    }
}