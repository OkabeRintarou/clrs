package chapter10.exercise;

import common.OverFlowException;
import common.UnderFlowException;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class SinglyList2StackTest extends TestCase {
    private SinglyList2Stack<String> stack;

    @Before
    public void setUp(){
        stack = new SinglyList2Stack<String>(10);
    }

    @Test
    public void testStack(){
        for(int i = 0; i < 10;i++){
            stack.push("hello" + i);
            assertTrue(stack.size() == i + 1);
        }
        assertEquals("hello9" ,stack.top());
        assertTrue(stack.size() == 10);
        try{
            stack.push("");
            assertTrue(false);
        }
        catch(OverFlowException e){

        }
        for(int i = 8;i >= 0;i--){
            stack.pop();
            assertEquals("hello" + i ,stack.top());
        }

        assertTrue(stack.size() == 1);
        try{
            stack.pop();
            stack.pop();
            assertTrue(false);
        }
        catch(UnderFlowException e){

        }
    }
}
