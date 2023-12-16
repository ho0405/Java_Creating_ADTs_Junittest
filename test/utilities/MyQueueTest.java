/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.EmptyQueueException;

/**
 * @author mj
 *
 */
class MyQueueTest {
	
	private MyQueue<Integer> queue;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// Initialize the queue before each test
		queue = new MyQueue<>();
	}

	/**
	 * Test method for {@link utilities.MyQueue#MyQueue(int)}.
	 */
	@Test
    void testMyQueueInt() {
        int initialCapacity = 10;
        MyQueue<Integer> queueWithCapacity = new MyQueue<>(initialCapacity);
        assertNotNull(queueWithCapacity, "Queue with specified capacity should be created");
        assertTrue(queueWithCapacity.isEmpty(), "Newly created queue should be empty");
        assertEquals(0, queueWithCapacity.size(), "Size of newly created queue should be 0");
        // Since capacity does not currently limit the size, further testing of this aspect is not necessary
    }

	/**
	 * Test method for {@link utilities.MyQueue#MyQueue()}.
	 */
	@Test
    void testMyQueue() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

	/**
	 * Test method for {@link utilities.MyQueue#enqueue(java.lang.Object)}.
	 */
	@Test
    void testEnqueue() {
        assertTrue(queue.isEmpty());

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Check size and peek
        assertEquals(3, queue.size());
        assertEquals(1, queue.peek());
    }

	/**
	 * Test method for {@link utilities.MyQueue#dequeue()}.
	 */
	@Test
    void testDequeue() {
        assertTrue(queue.isEmpty());
        assertThrows(EmptyQueueException.class, () -> queue.dequeue());

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);

        // Dequeue elements
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());

        assertTrue(queue.isEmpty());
        assertThrows(EmptyQueueException.class, () -> queue.dequeue());
    }

	/**
	 * Test method for {@link utilities.MyQueue#peek()}.
	 */
	@Test
    void testPeek() {
        assertTrue(queue.isEmpty());
        assertThrows(EmptyQueueException.class, () -> queue.peek());

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);

        // Peek
        assertEquals(1, queue.peek());
    }

	/**
	 * Test method for {@link utilities.MyQueue#equals(utilities.QueueADT)}.
	 */
	@Test
	void testEqualsQueueADTOfE() {
	    MyQueue<Integer> otherQueue = new MyQueue<>();
	    assertTrue(queue.equals(otherQueue));

	    queue.enqueue(1);
	    otherQueue.enqueue(1);

	    assertTrue(queue.equals(otherQueue));

	    otherQueue.enqueue(2);
	    queue.enqueue(2);

	    assertTrue(queue.equals(otherQueue));

	    otherQueue.enqueue(3);
	    assertFalse(queue.equals(otherQueue));
	}


	/**
	 * Test method for {@link utilities.MyQueue#iterator()}.
	 */
	@Test
    void testIterator() {
        assertTrue(queue.isEmpty());

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Use iterator to iterate through elements
        Iterator<Integer> iterator = queue.iterator();

        // Check the iterator has the correct elements in order
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());

        // Ensure that the original queue is not modified
        assertEquals(3, queue.size());
        assertEquals(1, queue.peek());
    }

	/**
	 * Test method for {@link utilities.MyQueue#toArray()}.
	 */
	
    @Test
    void testEquals() {
        MyQueue<Integer> otherQueue = new MyQueue<>();

        assertTrue(queue.equals(otherQueue));

        // Enqueue elements to both queues
        queue.enqueue(1);
        queue.enqueue(2);
        otherQueue.enqueue(1);
        otherQueue.enqueue(2);

        assertTrue(queue.equals(otherQueue));

        // Enqueue one more element to otherQueue
        otherQueue.enqueue(3);

        // Check if the underlying lists are equal
        assertFalse(queue.equals(otherQueue));
    }
    
	@Test
    void testToArray() {
        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Object[] array = queue.toArray();

        assertEquals(3, array.length);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
    }

	/**
	 * Test method for {@link utilities.MyQueue#toArray(E[])}.
	 */
	@Test
    void testToArrayEArray() {
        assertTrue(queue.isEmpty());

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Create an array with size 3
        Integer[] array = new Integer[3];

        // Call toArray(E[]) and check the returned array
        assertArrayEquals(new Integer[]{1, 2, 3}, queue.toArray(array));

        // Ensure that the original queue is not modified
        assertEquals(3, queue.size());
        assertEquals(1, queue.peek());
    }

	/**
	 * Test method for {@link utilities.MyQueue#isFull()}.
	 */
	@Test
    void testIsFull() {
        // MyQueue does not have a fixed size, so isFull() should always return false.
        assertFalse(queue.isFull());
    }

	/**
	 * Test method for {@link utilities.MyQueue#size()}.
	 */
	@Test
    void testSize() {
        assertEquals(0, queue.size());

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(2, queue.size());

        // Dequeue elements
        queue.dequeue();

        assertEquals(1, queue.size());
    }

	/**
	 * Test method for {@link utilities.MyQueue#isEmpty()}.
	 */
	@Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty());

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);

        assertFalse(queue.isEmpty());

        // Dequeue elements
        queue.dequeue();
        queue.dequeue();

        assertTrue(queue.isEmpty());
    }

	/**
	 * Test method for {@link utilities.MyQueue#clear()}.
	 */
	@Test
    void testClear() {
        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);

        assertFalse(queue.isEmpty());

        // Clear the queue
        queue.clear();

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

	/**
	 * Test method for {@link utilities.MyQueue#dequeueAll()}.
	 */
	@Test
    void testDequeueAll() {
        assertTrue(queue.isEmpty());

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Dequeue all elements
        queue.dequeueAll();

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

	/**
	 * Test method for {@link utilities.MyQueue#toString()}.
	 */
	@Test
    void testToString() {
        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals("[1, 2, 3]", queue.toString());
    }

}
