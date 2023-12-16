package utilities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

class MyArrayListTests {

    private MyArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    void testMyArrayList() {
        assertNotNull(list, "List should be created");
    }

    @Test
    void testMyArrayListInt() {
        MyArrayList<Integer> customList = new MyArrayList<>(20);
        assertNotNull(customList, "List with custom capacity should be created");
    }

    @Test
    void testSize() {
        assertEquals(0, list.size(), "Newly created list should have size 0");
        list.add(1);
        assertEquals(1, list.size(), "Size should be 1 after adding an element");
    }

    @Test
    void testClear() {
        list.add(1);
        list.clear();
        assertEquals(0, list.size(), "List should be empty after clear");
    }

    @Test
    void testAddIntE() {
        list.add(0, 1);
        assertEquals(1, list.get(0), "Element should be added at index 0");
    }

    @Test
    void testAddE() {
        assertTrue(list.add(1), "Add should return true");
        assertEquals(1, list.get(0), "Element should be added");
    }

    @Test
    void testAddAll() {
        MyArrayList<Integer> anotherList = new MyArrayList<>();
        anotherList.add(1);
        anotherList.add(2);
        assertTrue(list.addAll(anotherList), "AddAll should return true");
        assertEquals(2, list.size(), "All elements should be added");
    }

    @Test
    void testGet() {
        list.add(1);
        assertEquals(1, list.get(0), "Get should return the correct element");
    }

    @Test
    void testRemoveInt() {
        list.add(1);
        assertEquals(1, list.remove(0), "Remove should return the removed element");
        assertEquals(0, list.size(), "Size should decrease after remove");
    }

    @Test
    void testRemoveE() {
        list.add(1);
        assertEquals(Integer.valueOf(1), list.remove(Integer.valueOf(1)), "Remove should return the removed element");
        assertEquals(0, list.size(), "List should be empty after remove");
    }

    @Test
    void testSet() {
        list.add(1);
        assertEquals(1, list.set(0, 2), "Set should return the old element");
        assertEquals(2, list.get(0), "Element should be changed");
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty(), "Newly created list should be empty");
        list.add(1);
        assertFalse(list.isEmpty(), "List should not be empty after add");
    }

    @Test
    void testContains() {
        assertFalse(list.contains(1), "Empty list should not contain element");
        list.add(1);
        assertTrue(list.contains(1), "List should contain the element");
    }

    @Test
    void testToArrayEArray() {
        list.add(1);
        list.add(2);
        Integer[] array = new Integer[2];
        array = list.toArray(array);
        assertArrayEquals(new Integer[]{1, 2}, array, "toArray should return correct array");
    }

    @Test
    void testToArray() {
        list.add(1); // Add an element to the list
        Object[] array = list.toArray(); // Convert list to an array
        assertEquals(1, array.length, "Array length should be 1");
        assertEquals(1, array[0], "First element of the array should be 1");
    }


    @Test
    void testIterator() {
        list.add(1);
        list.add(2);
        Iterator<Integer> it = list.iterator();
        assertTrue(it.hasNext(), "Iterator should have next");
        assertEquals(1, it.next(), "Iterator next should return first element");
        assertEquals(2, it.next(), "Iterator next should return second element");
        assertFalse(it.hasNext(), "Iterator should not have next after last element");
    }
}