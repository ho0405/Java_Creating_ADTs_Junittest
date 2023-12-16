package utilities;

/**
 * Node class used in MyDLL (Doubly Linked List) implementation.
 *
 * @param <E> The type of element held in the linked list.
 */
public class MyDLLNode<E> {
    private E element;         // The element stored in the node
    private MyDLLNode<E> next; // Reference to the next node in the list
    private MyDLLNode<E> prev; // Reference to the previous node in the list

    /**
     * Constructor to create a new node.
     *
     * @param element The element to store in this node.
     * @param prev    Reference to the previous node in the list.
     * @param next    Reference to the next node in the list.
     */
    public MyDLLNode(E element, MyDLLNode<E> prev, MyDLLNode<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    /**
     * Returns the element stored in this node.
     *
     * @return The element stored in the node.
     */
    public E getElement() {
        return element;
    }

    /**
     * Sets the element stored in this node.
     *
     * @param element The element to be stored in the node.
     */
    public void setElement(E element) {
        this.element = element;
    }

    /**
     * Returns the next node in the list.
     *
     * @return The next node.
     */
    public MyDLLNode<E> getNext() {
        return next;
    }

    /**
     * Sets the next node in the list.
     *
     * @param next The node to be set as the next node.
     */
    public void setNext(MyDLLNode<E> next) {
        this.next = next;
    }

    /**
     * Returns the previous node in the list.
     *
     * @return The previous node.
     */
    public MyDLLNode<E> getPrev() {
        return prev;
    }

    /**
     * Sets the previous node in the list.
     *
     * @param prev The node to be set as the previous node.
     */
    public void setPrev(MyDLLNode<E> prev) {
        this.prev = prev;
    }
}
