/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adt.StackADT;

/**
 * @author mj
 *
 */
class MyStackTests {
	
	private StackADT<Integer> stack;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		stack = new MyStack<>();
	}

	/**
	 * Test method for {@link utilities.MyStack#MyStack()}.
	 */
	@Test
    void testMyStack() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

	/**
	 * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
	 */
	@Test
    void testPush() {
        stack.push(1);
        stack.push(2);

        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
        assertEquals(2, stack.peek());
    }

	@Test
	void testPop() {
	    // Replace java.util.EmptyStackException with the appropriate custom exception class, like utilities.EmptyStackException
	    assertThrows(exceptions.EmptyStackException.class, () -> stack.pop());

	    stack.push(1);
	    stack.push(2);
	    assertEquals(2, stack.pop());
	    assertEquals(1, stack.size());
	}


	@Test
	void testPeek() {
	    // Replace java.util.EmptyStackException with the appropriate custom exception class, like utilities.EmptyStackException
	    assertThrows(exceptions.EmptyStackException.class, () -> stack.peek());

	    stack.push(1);
	    stack.push(2);
	    assertEquals(2, stack.peek());
	    assertEquals(2, stack.size());
	}

	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());

        stack.push(1);
        assertFalse(stack.isEmpty());
    }

	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
    void testSize() {
        assertEquals(0, stack.size());

        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());

        stack.pop();
        assertEquals(1, stack.size());
    }
	/**
	 * Test method for {@link utilities.MyStack#clear()}.
	 */
	@Test
    void testClear() {
        stack.push(1);
        stack.push(2);

        stack.clear();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

	/**
	 * Test method for {@link utilities.MyStack#toArray()}.
	 */
	@Test
    void testToArray() {
        stack.push(1);
        stack.push(2);

        Object[] array = stack.toArray();
        assertEquals(2, array.length);
        assertEquals(2, array[1]);
    }

	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
    void testToArrayEArray() {
        stack.push(1);
        stack.push(2);

        Integer[] array = new Integer[2];
        stack.toArray(array);
        assertEquals(2, array.length);
        assertEquals(2, array[1]);
    }

	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 */
	@Test
    void testContains() {
        stack.push(1);
        stack.push(2);

        assertTrue(stack.contains(1));
        assertFalse(stack.contains(3));
    }

	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
    void testSearch() {
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.search(1));
        assertEquals(1, stack.search(2));
        assertEquals(-1, stack.search(3));
    }

	/**
	 * Test method for {@link utilities.MyStack#iterator()}.
	 */
	@Test
	void testIterator() {
	    stack.push(1);
	    stack.push(2);

	    Iterator<Integer> it = stack.iterator();
	    assertTrue(it.hasNext(), "Iterator should have next element");
	    assertEquals(Integer.valueOf(1), it.next(), "First element should be 1");
	    assertTrue(it.hasNext(), "Iterator should have next element");
	    assertEquals(Integer.valueOf(2), it.next(), "Second element should be 2");
	    assertFalse(it.hasNext(), "Iterator should have no more elements");
	}



	/**
	 * Test method for {@link utilities.MyStack#equals(adt.StackADT)}.
	 */
	@Test
    void testEqualsStackADTOfE() {
        StackADT<Integer> otherStack = new MyStack<>();
        assertTrue(stack.equals(otherStack));

        stack.push(1);
        stack.push(2);
        otherStack.push(1);
        otherStack.push(2);

        assertTrue(stack.equals(otherStack));

        otherStack.pop();
        otherStack.push(3);

        assertFalse(stack.equals(otherStack));
    }

}
