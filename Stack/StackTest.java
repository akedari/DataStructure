package linkedListOperations;

import org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by abhijeetkedari on 3/9/17.
 */
public class StackTest {

    @Test
    public void tesIsEmpty(){
        Stack st = new Stack();
        assertTrue(st.isEmpty());
        st.push(5);
        assertFalse(st.isEmpty());
    }

    @Test
    public void testPush(){
        Stack st = new Stack();
        st.push(5);
        assertEquals(5,st.peek());
    }

    @Test
    public void testPop(){
        Stack st = new Stack();
        st.push(5);
        st.push(8);
        st.push(9);
        st.push(88);
        st.pop();
        st.pop();
        assertEquals(8,st.peek());


    }



}
