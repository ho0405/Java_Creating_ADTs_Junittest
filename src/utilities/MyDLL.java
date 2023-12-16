package utilities;

import java.util.NoSuchElementException;

import adt.ListADT;

public class MyDLL<E> implements ListADT<E> {

    private Node<E> head; // Reference to the first node of the list
    private Node<E> tail; // Reference to the last node of the list
    private int size; // Number of elements in the list

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public MyDLL() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) throw new NullPointerException();
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        if (index == size) {
            linkLast(toAdd);
        } else {
            Node<E> succ = (index == size) ? null : node(index);
            Node<E> pred = (succ != null) ? succ.prev : tail;
            Node<E> newNode = new Node<>(toAdd, pred, succ);
            if (succ == null) {
                tail = newNode;
            } else {
                succ.prev = newNode;
            }
            if (pred == null) {
                head = newNode;
            } else {
                pred.next = newNode;
            }
            size++;
        }
        return true;
    }
    
    /**
     * Returns the (non-null) Node at the specified element index.
     */
    private Node<E> node(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        // If the index is less than half the size, start from the head (beginning of the list).
        if (index < (size / 2)) {
            Node<E> x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            // If the index is greater than half the size, start from the tail (end of the list).
            Node<E> x = tail;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    
    private void linkLast(E toAdd) {
        Node<E> l = tail;
        Node<E> newNode = new Node<>(toAdd, l, null);
        tail = newNode;
        if (l == null)
            head = newNode;
        else
            l.next = newNode;
        size++;
    }
    
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null elements to the list.");
        }
        linkLast(toAdd);
        return true;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null list to the list.");
        }

        boolean modified = false;
        Iterator<? extends E> itr = toAdd.iterator();
        while (itr.hasNext()) {
            E e = itr.next();
            linkLast(e);
            modified = true;
        }
        return modified;
    }


    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return node(index).element;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> x = node(index);
        return unlink(x);
    }

    private E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.element;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.element = null;
        size--;
        return element;
    }


    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) {
            throw new NullPointerException("Cannot remove null elements from the list.");
        }
        
        for (Node<E> x = head; x != null; x = x.next) {
            if (toRemove.equals(x.element)) {
                return unlink(x);
            }
        }
        
        return null; // If the element is not found, return null or throw an exception as per your requirements.
    }


    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) {
            throw new NullPointerException("Cannot set null elements in the list.");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        Node<E> x = node(index);
        E oldVal = x.element;
        x.element = toChange;
        return oldVal;
    }


    @Override
    public boolean isEmpty() {
        return size == 0; // or equivalently, head == null;
    }


    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("Cannot search for null elements in the list.");
        }
        for (Node<E> x = head; x != null; x = x.next) {
            if (toFind.equals(x.element)) {
                return true;
            }
        }
        return false;
    }


    @SuppressWarnings("unchecked")
	@Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("Provided array cannot be null.");
        }

        if (toHold.length < size) {
            toHold = (E[])java.lang.reflect.Array.newInstance(
                    toHold.getClass().getComponentType(), size);
        }

        int i = 0;
        for (Node<E> x = head; x != null; x = x.next) {
            toHold[i++] = x.element;
        }

        if (toHold.length > size) {
            toHold[size] = null;
        }

        return toHold;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        MyDLL<?> other = (MyDLL<?>) obj;

        if (this.size != other.size) return false;

        Node<E> currentA = this.head;
        Node<?> currentB = other.head;

        while (currentA != null && currentB != null) {
            if (!currentA.element.equals(currentB.element)) {
                return false;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return true;
    }


    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = head; x != null; x = x.next) {
            result[i++] = x.element;
        }
        return result;
    }


	@Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> nextNode = head;

            @Override
            public boolean hasNext() {
                return nextNode != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E element = nextNode.element;
                nextNode = nextNode.next;
                return element;
            }
        };
	}
	
	
}
