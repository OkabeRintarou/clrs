package chapter10.exercise;

import common.OverFlowException;
import common.UnderFlowException;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class SinglyList2QueueTest extends TestCase {
    private SinglyList2Queue<Integer> queue;

    @Before
    public void setUp(){
        queue = new SinglyList2Queue<Integer>(6);
    }

    @Test
    public void testEmpty(){
        assertTrue(queue.isEmpty());
        try{
            queue.dequeue();
        }
        catch(UnderFlowException e){
            // reach here
        }
    }

    @Test
    public void testFull(){
        for(int i = 0; i < 10;i++){
            if(i >= 6){
                try{
                    queue.enqueue(i);
                }
                catch(OverFlowException e){
                    // reach here
                }
            }
            else{
                queue.enqueue(i);
            }
        }
        assertTrue(queue.isFull());
        assertTrue(queue.size() == 6);
    }

    @Test
    public void testDequeueEnqueue(){
        queue.enqueue(1);
        queue.dequeue();
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        assertEquals(1,(int)queue.front());
        assertEquals(1,(int)queue.back());
        queue.enqueue(2);
        assertEquals(1,(int)queue.front());
        assertEquals(2,(int)queue.back());
        queue.enqueue(3);
        assertEquals(3,(int)queue.back());
        for(int i = 4;i <= 6;i++){
            queue.enqueue(i);
            assertEquals(i,(int)queue.back());
        }
        assertTrue(queue.isFull());
        try{
            queue.enqueue(10);
            assertTrue(false);
        }
        catch(OverFlowException e){
            // reach here
        }
        for(int i = 1; i <= 5;i++){
            assertEquals(i,(int)queue.front());
            queue.dequeue();
            assertEquals(i + 1,(int)queue.front());
        }
        queue.dequeue();
        assertTrue(queue.isEmpty());
        try{
            queue.dequeue();
            assertTrue(false);
        }
        catch(UnderFlowException e){
            // reach here
        }
    }
}
