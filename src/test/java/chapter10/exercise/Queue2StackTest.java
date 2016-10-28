package chapter10.exercise;

import common.OverFlowException;
import common.UnderFlowException;
import junit.framework.TestCase;
import org.junit.Test;

public class Queue2StackTest extends TestCase {
    private Queue2Stack<String> stack = new Queue2Stack<String>(10);

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
                assertEquals(stack.top(),"hello" + i);
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
