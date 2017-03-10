package linkedListOperations;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by abhijeetkedari on 3/9/17.
 */
public class LinkedListTest {

    @Test
    public void testIsEmpty(){
        LinkedList list = new LinkedList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testSize(){
        LinkedList list = new LinkedList();
        list.add(5);
        assertEquals(1,list.getSize());
    }

    @Test
    public void testAdd(){
        LinkedList list = new LinkedList();
        list.add(5);
        assertEquals(5,list.getLast());
    }

    @Test
    public void testRemoveLast(){
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(7);
        list.removeLast();
        assertEquals(5,list.getLast());
    }

    @Test
    public void testRemoveHead(){
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(7);
        list.removeHead();
        assertEquals(7,list.getHead());
    }

    @Test
    public void testGetElementAtPosition(){
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(7);
        list.add(9);
        assertEquals(7,list.getElementAtPosition(2));
    }

}
