package utilities;

import adt.StackADT;
import exceptions.EmptyStackException;

@SuppressWarnings("serial")
public class MyStack<E> implements StackADT<E> {
    
    private MyArrayList<E> stackList;

    public MyStack() {
        stackList = new MyArrayList<>();
    }

    @Override
    public void push(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null elements to the stack.");
        }
        stackList.add(toAdd);
    }

    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackList.remove(stackList.size() - 1);
    }

    @Override
    public E peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackList.get(stackList.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    @Override
    public int size() {
        return stackList.size();
    }

    @Override
    public void clear() {
        stackList.clear();
    }

    @Override
    public Object[] toArray() {
        return stackList.toArray();
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        if (holder == null) {
            throw new NullPointerException("Holder array cannot be null.");
        }
        if (holder.length < size()) {
            // If holder is too small, allocate a new array of the same runtime type as holder
            holder = (E[])java.lang.reflect.Array.newInstance(holder.getClass().getComponentType(), size());
        }
        for (int i = 0; i < size(); i++) {
            holder[i] = stackList.get(i);
        }
        if (holder.length > size()) {
            holder[size()] = null; // Set element immediately following the end of the collection to null
        }
        return holder;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("Search element cannot be null.");
        }
        return stackList.contains(toFind);
    }

    @Override
    public int search(E toFind) {
        for (int i = stackList.size() - 1; i >= 0; i--) {
            if (stackList.get(i).equals(toFind)) {
                return stackList.size() - i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return stackList.iterator();
    }

    @Override
    public boolean equals(StackADT<E> that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        MyStack<E> otherStack = (MyStack<E>) that;
        return this.stackList.equals(otherStack.stackList);
    }
}
