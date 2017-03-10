package linkedListOperations;

import org.junit.Assert.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by abhijeetkedari on 3/9/17.
 */
public class DLinkedListTest {

    @Test
    public void testIfEmpty(){
        DLinkedList list = new DLinkedList();
        assertEquals(true,list.isEmpty());
        list.add(1);
        assertEquals(false,list.isEmpty());
    }


    @Test
    public void testSize(){
        DLinkedList list = new DLinkedList();
        list.add(5);
        assertEquals(1,list.getSize());
    }

    @Test
    public void testGetHead(){
        DLinkedList list = new DLinkedList();
        list.add(5);
        assertEquals(5,list.getHead());
    }

    @Test
    public void testGetTail(){
        DLinkedList list = new DLinkedList();
        list.add(5);
        assertEquals(5,list.getTail());
    }

    @Test
    public void testGetElement(){
        DLinkedList list = new DLinkedList();
        list.add(5);
        list.add(6);
        list.add(7);
        assertEquals(6,list.getElement(2));
    }

    @Test
    public void testAddAtPosition(){
        DLinkedList list = new DLinkedList();
        list.add(5);
        list.add(6);
        list.add(7);
        list.addAtPosition(2,9);
        assertEquals(9,list.getElement(3));
    }




}
