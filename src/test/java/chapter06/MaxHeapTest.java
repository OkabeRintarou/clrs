package chapter06;

import common.ArrayUtil;
import common.EmptyException;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxHeapTest extends TestCase {
    @Test
    public void testMaximum(){
        MaxHeap maxHeap = new MaxHeap(new Integer[]{3,4,2,1,9,8,7,14,10,16});
        assertEquals(16,maxHeap.maximum());
        for(int i = 0;i < 1000;i++){
            List<Integer> arr = ArrayUtil.genRandomIntArray(i + 1);
            int max = arr.get(0);
            for(int j = 1;j < arr.size();j++){
                if(arr.get(j) > max)max = arr.get(j);
            }
            maxHeap = new MaxHeap(arr);
            assertEquals(max,maxHeap.maximum());
        }
        maxHeap = new MaxHeap(new Integer[]{});
        try{
            maxHeap.maximum();
            assertFalse(true);
        }catch(Exception e){
        }
    }

    @Test
    public void testInsert(){
        MaxHeap maxHeap = new MaxHeap(new Integer[]{3,4,2,1,9,8,7,14,10,16});
        for(int i = 17;i < 1000;i++){
            maxHeap.insert(i);
            assertEquals(i,maxHeap.maximum());
        }
        for(int i = -1;i >= -100;i--){
            maxHeap.insert(i);
            assertEquals(999,maxHeap.maximum());
        }

    }

    @Test
    public void testDecreaseKey(){
        MaxHeap maxHeap = new MaxHeap(new Integer[]{3,4,2,1,9,8,7,14,10,16});
        maxHeap.increaseKey(9,100);
        assertEquals(100,maxHeap.maximum());
    }

    @Test
    public void testExtractMax(){
        for(int i = 0;i < 1000;i++){
            List<Integer> arr = ArrayUtil.genRandomIntArray(i + 1);
            Integer[] arr2 = new Integer[arr.size()];
            for(int j = 0;j < arr.size();j++){
                arr2[j] = new Integer(arr.get(j));
            }
            MaxHeap maxHeap = new MaxHeap(arr);
            Arrays.sort(arr2, Collections.<Integer>reverseOrder());
            for(int j = 0;j < arr2.length;j++){
                int max = maxHeap.extractMax();
                if(!arr2[j].equals(max)){
                    assertFalse(true);
                }
            }
            try{
                maxHeap.extractMax();
                assertFalse(true);
            }catch(EmptyException e){

            }
        }
    }

}
