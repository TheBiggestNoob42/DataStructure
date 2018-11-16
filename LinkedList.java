
public class LinkedList<E> {

    //the head is the first node
    private Node<E> head;
    private int size;

    public LinkedList() {
        //when head is initialized there is no first nodes so head points to null
        head = null;
        size = 0;
    }

    public void add(E item) {
        Node<E> node_to_add = new Node<>(item, head);
        head = node_to_add;
        size++;
    }

    public E get(int index) throws Exception {

        if (index >= size || index < 0) {
            System.out.println(index + "\t" + size);
            throw new Exception("Index error");
        }
        Node<E> node = head;

        for(int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.item;
    }

    public E remove(int index) throws Exception {
        if(index >= size || index < 0)
            throw new Exception("Index error");

        if(size == 1)
        {
            E item = head.item;
            head = null;
            size--;
            return item;
        }



        Node<E> node = head;

        if(index == 0)
        {
            Node<E> newHead = head.next;
            E item = head.item;
            head = newHead;
            size--;
            return item;
        }
        /*
        * This for loop executes only when index is 2 or more
        * If the index is 1 then it already works as expected
        *
        * But if index is 0 the logic is different because the node to delete is the head
        * */
        for(int i = 0; i < index - 1; i++) {
            node = node.next;
        }

        Node<E> deletedNode = node.next;
        node.next = node.next.next;

        size--;
        return deletedNode.item;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
