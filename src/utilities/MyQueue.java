package utilities;

import adt.QueueADT;
import exceptions.EmptyQueueException;

public class MyQueue<E> implements QueueADT<E> {

    private MyDLL<E> list;
	@SuppressWarnings("unused")
	private int capacity;

    public MyQueue() {
        list = new MyDLL<>();
    }
    
    public MyQueue(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative.");
        }
        this.capacity = capacity;
        list = new MyDLL<>();
        // Note: Currently, the capacity does not affect MyDLL,
        // but you can use it in the future if you modify MyDLL or MyQueue.
    }

    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot enqueue null elements.");
        }
        list.add(toAdd); // Add to the end of the list
    }

    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Cannot dequeue from an empty queue.");
        }
        return list.remove(0); // Remove from the front of the list
    }

    @Override
    public E peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Cannot peek into an empty queue.");
        }
        return list.get(0); // Get the first element
    }

    @Override
    public void dequeueAll() {
        list.clear(); // Clear the list
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty(); // Check if the list is empty
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator(); // MyDLL has an iterator() method
    }

    @Override
    public boolean equals(QueueADT<E> that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        MyQueue<E> otherQueue = (MyQueue<E>) that;
        return this.list.equals(otherQueue.list); // Assuming MyDLL has a proper equals method
    }


    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return list.toArray(holder);
    }

    @Override
    public boolean isFull() {
        // If there's no fixed size, this could always return false.
        // Adjust based on your specific implementation requirements.
        return false;
    }

    @Override
    public int size() {
        return list.size(); // Return the size of the list
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        // Assuming MyDLL has a method to iterate over elements
        StringBuilder sb = new StringBuilder("[");
        Iterator<E> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
    
    // Additional methods as required by your QueueADT interface.
}

