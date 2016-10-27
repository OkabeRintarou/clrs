package chapter10.exercise;

import common.OverFlowException;
import common.UnderFlowException;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class DequeTest extends TestCase {
    private Deque<Integer> queue;
    private Deque<String> oneElemQueue;
    private Deque<Integer> twoElemQueue;
    private Deque<Integer> threeElemQueue;

    @Before
    public void setUp(){
        queue = new Deque<Integer>(6);
        oneElemQueue = new Deque<String>(1);
        twoElemQueue = new Deque<Integer>(2);
        threeElemQueue = new Deque<Integer>(3);
    }

    @Test
    public void testOne(){
        oneElemQueue.pushFront("pushFront");
        try{
            oneElemQueue.pushFront("pushFront");
        }
        catch(OverFlowException e){
        }
        try{
            oneElemQueue.pushBack("pushBack");
        }
        catch(OverFlowException e){
        }

        oneElemQueue.popFront();
        assertTrue(oneElemQueue.isEmpty());

        oneElemQueue.pushFront("pushFront");
        oneElemQueue.popBack();
        assertTrue(oneElemQueue.isEmpty());

        oneElemQueue.pushBack("pushBack");
        try{
            oneElemQueue.pushFront("pushFront");
        }
        catch(OverFlowException e){
        }
        try{
            oneElemQueue.pushBack("pushBack");
        }
        catch(OverFlowException e){
        }
        oneElemQueue.popBack();
        assertTrue(oneElemQueue.isEmpty());
        try{
            oneElemQueue.popFront();
        }
        catch(UnderFlowException e){

        }

        oneElemQueue.pushBack("pushBack");
        oneElemQueue.popFront();
        assertTrue(oneElemQueue.isEmpty());
    }

    @Test
    public void testTwo(){
        twoElemQueue.pushFront(1);
        twoElemQueue.pushBack(2);
        assertEquals(1,(int)twoElemQueue.front());
        assertEquals(2,(int)twoElemQueue.back());
        twoElemQueue.popFront();
        assertEquals(2,(int)twoElemQueue.front());
        assertEquals(2,(int)twoElemQueue.back());
        twoElemQueue.pushFront(1);
        twoElemQueue.popBack();
        assertEquals(1,(int)twoElemQueue.front());
        assertEquals(1,(int)twoElemQueue.back());
        twoElemQueue.pushFront(1);
        assertTrue(twoElemQueue.isFull());
        twoElemQueue.popBack();twoElemQueue.popFront();
        assertTrue(twoElemQueue.isEmpty());
    }

    @Test
    public void testThree(){
        assertTrue(threeElemQueue.isEmpty());
        for(int i = 0; i < 3;i++){
            threeElemQueue.pushFront(i);
        }
        try{
            threeElemQueue.pushFront(4);
        }
        catch(OverFlowException e){

        }
        assertEquals(2,(int)threeElemQueue.front());
        assertEquals(0,(int)threeElemQueue.back());
        threeElemQueue.popFront();
        assertEquals(1,(int)threeElemQueue.front());
        assertEquals(0,(int)threeElemQueue.back());
        threeElemQueue.pushBack(2);
        assertEquals(1,(int)threeElemQueue.front());
        assertEquals(2,(int)threeElemQueue.back());

    }

    @Test
    public void testPopBack(){
        for(int i = 0; i < 3;i++){
            queue.pushFront(i);
        }
        for(int i = 3;i < 6;i++){
            queue.pushBack(i);
        }
        assertEquals(2,(int)queue.front());
        assertEquals(5,(int)queue.back());
        queue.popBack();
        assertEquals(2,(int)queue.front());
        assertEquals(4,(int)queue.back());
        queue.popBack();
        assertEquals(2,(int)queue.front());
        assertEquals(3,(int)queue.back());
        queue.popBack();
        assertEquals(2,(int)queue.front());
        assertEquals(0,(int)queue.back());
        queue.popBack();
        assertEquals(2,(int)queue.front());
        assertEquals(1,(int)queue.back());
        queue.popBack();
        assertEquals(2,(int)queue.front());
        assertEquals(2,(int)queue.back());
        queue.popBack();
        assertTrue(queue.isEmpty());
        try{
            queue.popBack();
        }
        catch(UnderFlowException e){

        }
    }

    @Test
    public void testPopFront(){
        for(int i = 0; i < 3;i++){
            queue.pushFront(i);
        }
        for(int i = 3;i < 6;i++){
            queue.pushBack(i);
        }
        assertEquals(2,(int)queue.front());
        assertEquals(5,(int)queue.back());
        queue.popFront();
        assertEquals(1,(int)queue.front());
        assertEquals(5,(int)queue.back());
        queue.popFront();
        assertEquals(0,(int)queue.front());
        assertEquals(5,(int)queue.back());
        queue.popFront();
        assertEquals(3,(int)queue.front());
        assertEquals(5,(int)queue.back());
        queue.popFront();
        assertEquals(4,(int)queue.front());
        assertEquals(5,(int)queue.back());
        queue.popFront();
        assertEquals(5,(int)queue.front());
        assertEquals(5,(int)queue.back());
        queue.popBack();
        assertTrue(queue.isEmpty());
        try{
            queue.popBack();
        }
        catch(UnderFlowException e){

        }
    }

    @Test
    public void testPop(){
        for(int i = 0; i < 3;i++){
            queue.pushFront(i);
        }
        for(int i = 3;i < 6;i++){
            queue.pushBack(i);
        }
        queue.popFront();
        assertEquals(1,(int)queue.front());
        assertEquals(5,(int)queue.back());
        queue.popBack();
        assertEquals(1,(int)queue.front());
        assertEquals(4,(int)queue.back());
        queue.popFront();
        assertEquals(0,(int)queue.front());
        assertEquals(4,(int)queue.back());
        queue.popBack();
        assertEquals(0,(int)queue.front());
        assertEquals(3,(int)queue.back());
        queue.popBack();
        assertEquals(0,(int)queue.front());
        assertEquals(0,(int)queue.back());
        assertTrue(queue.size() == 1);
    }
}
