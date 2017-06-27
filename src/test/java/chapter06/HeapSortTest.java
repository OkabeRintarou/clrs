package chapter06;

import common.ArrayUtil;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HeapSortTest extends TestCase {
    @Test
    public void testIncSort(){
        for(int i = 0;i < 1000;i++){
            List<Integer> lst = ArrayUtil.genRandomIntArray(i + 1);
            Integer[] elems1 = new Integer[lst.size()];
            Integer[] elems2 = new Integer[lst.size()];
            for(int j = 0;j < elems1.length;j++){
                elems1[j] = lst.get(j);
                elems2[j] = lst.get(j);
            }
            Arrays.sort(elems1);
            MaxHeap maxHeap = new MaxHeap(elems2);
            maxHeap.sort();
            int j = 0;
            Iterator<Integer> iter = maxHeap.iterator();
            while(iter.hasNext()){
                Integer elem = iter.next();
                if(!elem.equals(elems1[j++])){
                    assertFalse(true);
                }
            }
        }
    }

    @Test
    public void testDecSort(){
        for(int i = 0;i < 1000;i++){
            List<Integer> lst = ArrayUtil.genRandomIntArray(i + 1);
            Integer[] elems1 = new Integer[lst.size()];
            Integer[] elems2 = new Integer[lst.size()];
            for(int j = 0;j < elems1.length;j++){
                elems1[j] = lst.get(j);
                elems2[j] = lst.get(j);
            }
            Arrays.sort(elems1,Collections.<Integer>reverseOrder());
            MinHeap minHeap = new MinHeap(elems2);
            minHeap.sort();
            int j = 0;
            Iterator<Integer> iter = minHeap.iterator();
            while(iter.hasNext()){
                Integer elem = iter.next();
                if(!elem.equals(elems1[j++])){
                    assertFalse(true);
                }
            }
        }
    }
}
