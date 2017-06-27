package chapter06;

import common.ArrayUtil;
import common.EmptyException;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MinHeapTest extends TestCase {

    @Test
    public void testMinimal(){
        MinHeap minHeap = new MinHeap(new Integer[]{3,4,2,1,9,8,7,14,10,16});
        assertEquals(1,minHeap.minimal());
        for(int i = 0;i < 1000;i++){
            List<Integer> arr = ArrayUtil.genRandomIntArray(i + 1);
            int min = arr.get(0);
            for(int j = 1;j < arr.size();j++){
                if(arr.get(j) < min)min = arr.get(j);
            }
            minHeap = new MinHeap(arr);
            assertEquals(min,minHeap.minimal());
        }
        minHeap = new MinHeap(new Integer[]{});
        try{
            minHeap.minimal();
            assertFalse(true);
        }catch(Exception e){
        }
    }

    @Test
    public void testInsert(){
        MinHeap minHeap = new MinHeap(new Integer[]{3,4,2,1,9,8,7,14,10,16});
        for(int i = 17;i < 1000;i++){
            minHeap.insert(i);
            assertEquals(1,minHeap.minimal());
        }
        for(int i = -1;i >= -100;i--){
            minHeap.insert(i);
            assertEquals(i,minHeap.minimal());
        }

    }

    @Test
    public void testDecreaseKey(){
        MinHeap minHeap = new MinHeap(new Integer[]{3,4,2,1,9,8,7,14,10,16});
        minHeap.decreaseKey(9,-100);
        assertEquals(-100,minHeap.minimal());
    }

    @Test
    public void testExtractMin(){
        for(int i = 0;i < 1000;i++){
            List<Integer> arr = ArrayUtil.genRandomIntArray(i + 1);
            Integer[] arr2 = new Integer[arr.size()];
            for(int j = 0;j < arr.size();j++){
                arr2[j] = new Integer(arr.get(j));
            }
            MinHeap minHeap = new MinHeap(arr);
            Arrays.sort(arr2);
            for(int j = 0;j < arr2.length;j++){
                int min = minHeap.extractMin();
                if(!arr2[j].equals(min)){
                    assertFalse(true);
                }
            }
            try{
                minHeap.extractMin();
                assertFalse(true);
            }catch(EmptyException e){

            }
        }
    }

}
