package utilities;


import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import adt.ListADT;

public class MyArrayList<E> implements ListADT<E>
{

	private static final long serialVersionUID = 944121286122963383L;

	private final int INITIAL_CAPACITY = 10;
	
	private E[] array;
	private int size; 
	
	
	
	@SuppressWarnings("unchecked")
	public MyArrayList()
	{
		array = (E[]) new Object[INITIAL_CAPACITY];
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayList(int capacity)
	{
		array = (E[]) new Object[capacity];
	}
	
	@Override
	public int size() {
		
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		array = (E[]) new Object[INITIAL_CAPACITY];
		size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException();
		}
		if (toAdd == null)
		{
			throw new NullPointerException();
		}
		checkCapacity();
		//array[size] = toAdd;
		//shift to the right to make room for the insertion
		System.arraycopy(array, index, array, index + 1, size - index); // Shift right
	    array[index] = toAdd;
	    size++;
	    return true;
	}
	
	@SuppressWarnings("unchecked")
	private void checkCapacity() {
	    if (size == array.length) {
	        E[] newArray = (E[]) new Object[size * 2];
	        for (int i = 0; i < size; i++) {
	            newArray[i] = array[i];
	        }
	        array = newArray;
	    }
	}


	@Override
	public boolean add(E toAdd) throws NullPointerException {
		 if (toAdd == null)
		 {
			 throw new NullPointerException();
		 }
		 checkCapacity();
		 array[size++] = toAdd;
		 return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
	    if (toAdd == null) {
	        throw new NullPointerException();
	    }

	    Iterator<? extends E> it = toAdd.iterator();
	    while (it.hasNext()) {
	        add(it.next());
	    }

	    return true;
	}



	@Override
	public E get(int index) throws IndexOutOfBoundsException {
	    if (index < 0 || index >= size) {
	        throw new IndexOutOfBoundsException();
	    }
	    return array[index];
	}


	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
	    if (index < 0 || index >= size) {
	        throw new IndexOutOfBoundsException();
	    }
	    E removedElement = array[index];
	    for (int i = index; i < size - 1; i++) {
	        array[i] = array[i + 1];
	    }
	    array[size - 1] = null; 
	    size--;
	    return removedElement;
	}


	@Override
	public E remove(E toRemove) throws NullPointerException {
	    if (toRemove == null) {
	        throw new NullPointerException();
	    }
	    for (int i = 0; i < size; i++) {
	        if (toRemove.equals(array[i])) {
	            return remove(i);
	        }
	    }
	    return null;
	}


	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
	    if (index < 0 || index >= size) {
	        throw new IndexOutOfBoundsException();
	    }
	    if (toChange == null) {
	        throw new NullPointerException();
	    }
	    E oldElement = array[index];
	    array[index] = toChange;
	    return oldElement;
	}


	@Override
	public boolean isEmpty() {
	    return size == 0;
	}


	@Override
	public boolean contains(E toFind) throws NullPointerException {
	    if (toFind == null) {
	        throw new NullPointerException();
	    }
	    for (E element : array) {
	        if (toFind.equals(element)) {
	            return true;
	        }
	    }
	    return false;
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;

	    MyArrayList<?> that = (MyArrayList<?>) o;

	    if (this.size != that.size) return false;

	    for (int i = 0; i < this.size; i++) {
	        if (!this.array[i].equals(that.array[i])) {
	            return false;
	        }
	    }

	    return true;
	}
	

	public Object[] toArray()
	{
		//E[] toReturn = (E[]) (new Object[size]);
		E[] toReturn = (E[])(Array.newInstance(Object.class, size));
		/*for(int i = 0; i < size(); i++)
		{
			toReturn[i] = ((E)array[i]).
		}*/
		System.arraycopy(array, 0, toReturn, 0, size());
		return toReturn;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
	    if (holder == null) {
	        throw new NullPointerException("Holder array cannot be null.");
	    }
	    if (holder.length < size) {
	        holder = (E[])java.lang.reflect.Array.newInstance(holder.getClass().getComponentType(), size);
	    }
	    System.arraycopy(array, 0, holder, 0, size);
	    if (holder.length > size) {
	        holder[size] = null;
	    }
	    return holder;
	}

	

	@Override
	public Iterator<E> iterator() {
		return new ArrayBasedIterator();
	}
	
	private class ArrayBasedIterator implements Iterator<E>
	{
		//Attributes
		private E[] 		copyOfElements;
		private int 		pos;
		
		//Constructors
		@SuppressWarnings("unchecked")
		public ArrayBasedIterator()
		{
			copyOfElements = (E[]) (new Object[size()]);
			System.arraycopy(array, 0, copyOfElements, 0, copyOfElements.length);
		}
		
		/* (non-Javadoc)
		 * @see linearUtilities.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext()
		{
			return pos < copyOfElements.length;
		}
	
		/* (non-Javadoc)
		 * @see linearUtilities.Iterator#next()
		 */
		@Override
		public E next() throws NoSuchElementException
		{
			if (pos == copyOfElements.length)
			{
				throw new NoSuchElementException();
			}
			E toReturn = copyOfElements[pos];
			pos++;
			return toReturn;
			
		}
	}
}
