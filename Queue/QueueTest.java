package linkedListOperations;

/**
 * Created by abhijeetkedari on 3/9/17.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueTest {

    @Test
    public void testGetSize(){
        Queue que = new Queue();
        assertEquals(0,que.getSize());
        que.enqueue(5);
        assertEquals(1,que.getSize());
    }

    @Test
    public void testEnqueue(){
        Queue que = new Queue();
        que.enqueue(5);
        que.enqueue(10);
        assertEquals(5,que.peek());
    }
    
    @Test
    public void testDqueue(){
        Queue que = new Queue();
        que.enqueue(5);
        que.enqueue(10);
        que.dqueue();
        assertEquals(1,que.getSize());
    }

}
