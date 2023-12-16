/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 * @author mj
 *
 */
class MyDLLTests {
	private MyDLL<Integer> list;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		list = new MyDLL<>();
	}

	/**
	 * Test method for {@link utilities.MyDLL#MyDLL()}.
	 */
	@Test
    void testMyDLL() {
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

	/**
	 * Test method for {@link utilities.MyDLL#size()}.
	 */
	@Test
    void testSize() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
        list.add(2);
        assertEquals(2, list.size());
    }

	/**
	 * Test method for {@link utilities.MyDLL#clear()}.
	 */
	@Test
	   void testClear() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
    void testAddIntE() {
        list.add(0, 1);
        assertEquals(1, list.get(0));
        list.add(0, 2);
        assertEquals(2, list.get(0));
        assertEquals(1, list.get(1));
        list.add(2, 3);
        assertEquals(3, list.get(2));
    }

	/**
	 * Test method for {@link utilities.MyDLL#add(java.lang.Object)}.
	 */
	@Test
    void testAddE() {
        assertTrue(list.add(1));
        assertEquals(1, list.get(0));
        assertTrue(list.add(2));
        assertEquals(2, list.get(1));
    }

	/**
	 * Test method for {@link utilities.MyDLL#addAll(adt.ListADT)}.
	 */
	@Test
    void testAddAll() {
        MyDLL<Integer> otherList = new MyDLL<>();
        otherList.add(1);
        otherList.add(2);

        assertTrue(list.addAll(otherList));
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

	/**
	 * Test method for {@link utilities.MyDLL#get(int)}.
	 */
	@Test
    void testGet() {
        list.add(1);
        list.add(2);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
    void testRemoveInt() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(2, list.remove(1));
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
    void testRemoveE() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(Integer.valueOf(2), list.remove(Integer.valueOf(2)));
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
    void testSet() {
        list.add(1);
        list.add(2);

        assertEquals(1, list.set(0, 3));
        assertEquals(3, list.get(0));
        assertEquals(2, list.get(1));
    }

	/**
	 * Test method for {@link utilities.MyDLL#isEmpty()}.
	 */
	@Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
    void testContains() {
        list.add(1);
        list.add(2);

        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertFalse(list.contains(3));
    }

	/**
	 * Test method for {@link utilities.MyDLL#toArray(E[])}.
	 */
	@Test
    void testToArrayEArray() {
        list.add(1);
        list.add(2);

        Integer[] array = new Integer[2];
        array = list.toArray(array);

        assertArrayEquals(new Integer[]{1, 2}, array);
    }

	/**
	 * Test method for {@link utilities.MyDLL#toArray()}.
	 */
	@Test
    void testToArray() {
        list.add(1);
        list.add(2);

        Object[] array = list.toArray();

        assertArrayEquals(new Object[]{1, 2}, array);
    }


	/**
	 * Test method for {@link utilities.MyDLL#iterator()}.
	 */
	@Test
    void testIterator() {
        list.add(1);
        list.add(2);
        Iterator<Integer> it = list.iterator();
        assertTrue(it.hasNext(), "Iterator should have next element");
        assertEquals(Integer.valueOf(1), it.next(), "First element should be 1");
        assertTrue(it.hasNext(), "Iterator should have next element");
        assertEquals(Integer.valueOf(2), it.next(), "Second element should be 2");
        assertFalse(it.hasNext(), "Iterator should not have more elements");
    }

}
