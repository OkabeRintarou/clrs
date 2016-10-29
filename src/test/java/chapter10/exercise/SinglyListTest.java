package chapter10.exercise;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class SinglyListTest extends TestCase {

    private SinglyList<Integer> list;

    @Before
    public void setUp(){
        list = new SinglyList<Integer>();
    }

    @Test
    public void testSinglyList(){
        for(int i = 0; i < 100;i++){
            list.insert(i);
        }

        list.delete(0);
        for(int i = 1; i < 100;i++){
            list.delete(0);
        }
        assertTrue(list.isEmpty());
    }

    @Test
    public void testReverse(){
        list.reverse();
        list.append(1);
        list.reverse();
        assertEquals(1,(int)list.front());
        for(int i = 2;i <= 100;i++){
            list.insert(i);
        }
        list.reverse();
        for(int i = 0; i < 100;i++){
            assertEquals(i + 1,(int)list.get(i));
        }

        for(int i = 2; i <= 10;i++){
            list = new SinglyList<Integer>();
            for(int j = 1; j <= i;j++){
                list.insert(j);
            }
            list.reverse();
            for(int j = 0;j < i;j++){
                assertEquals(j + 1,(int)list.get(j));
            }
        }
    }
}
