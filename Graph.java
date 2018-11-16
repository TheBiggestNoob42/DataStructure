import java.util.ArrayList;

public class Graph<E> {
    class Edges<E> {
        Node<E> A, B;

        public Edges(Node<E> a, Node<E> b) {
            A = a;
            B = b;
        }
    }

    class Node<E> {
        E object;
        public Node(E object) {
            this.object = object;
        }
    }

}
