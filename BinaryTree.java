public class BinaryTree<E extends Comparable<E>>{
    class Node<E extends Comparable<E>> {
        E obj;
        Node<E> right, left;
        public Node(E o) {
            obj = o;
            right = null;
            left = null;
        }

        public void add(E o) {
            int direction = obj.compareTo(o);
            if(direction > 0) {
                if(right == null)
                    right = new Node<>(o);
                else {
                    right.add(o);
                }
            } else if(direction < 0) {
                if(left == null)
                    left = new Node<>(o);
                else {
                    left.add(o);
                }
            }
        }

        public String toString() {
            String str = obj.toString() + " ";
            if(left != null)
                str += left.toString() + "L ";
            if(right != null)
                str += right.toString() + "R ";
            return str;
        }
    }

    Node<E> head;

    public BinaryTree() {
        head = null;
    }

    public void add(E obj) {
        if(head == null)
            head = new Node<>(obj);
        else
            head.add(obj);
    }

    public String toString() {
        return head.toString();
    }

}
