package chapter06;

import common.EmptyException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MaxHeap implements Iterable<Integer>{
    private List<Integer> arr;
    private int size;

    public MaxHeap(Integer[] elems){
        assert(elems != null);
        arr = new ArrayList<Integer>();
        for(int i = 0;i < elems.length;i++){
            arr.add(elems[i]);
        }
        size = elems.length;
        buildHeap();
    }

    public MaxHeap(){
        arr = new ArrayList<Integer>();
        size = arr.size();
        buildHeap();
    }

    public MaxHeap(List<Integer> elems){
        arr = elems;
        size = elems.size();
        buildHeap();
    }

    public int maximum(){
        if(arr.size() > 0){
            return arr.get(0);
        }
        throw new EmptyException();
    }

    public void insert(int elem){
        size++;
        arr.add(Integer.MIN_VALUE);
        increaseKey(size - 1,elem);
    }

    public void increaseKey(int i,int key){
        if(i < 0 || i >= arr.size()){
            throw new IllegalArgumentException("Invalid index");
        }
        if(key < arr.get(i)){
            throw new IllegalArgumentException("new key is larger than current key");
        }
        arr.set(i,key);
        while(i > 0 && arr.get(parent(i)) < arr.get(i)){
            int tmp= arr.get(i);
            arr.set(i,arr.get(parent(i)));
            arr.set(parent(i),tmp);
            i = parent(i);
        }
    }

    public int extractMax(){
        if(arr.size() <= 0){
            throw new EmptyException();
        }
        int min = arr.get(0);
        arr.set(0,arr.get(arr.size() - 1));
        arr.remove(arr.size() - 1);
        size--;
        if(size > 0){
            heapify(0);
        }
        return min;
    }


    private void buildHeap(){
        for(int i = parent(arr.size() - 1);i >= 0;i--){
            heapify(i);
        }
    }

    private void heapify(int i){
        assert(i >= 0 && i < size);

        int left,right,largest;

        for(;;){
            left = lchild(i);
            right = rchild(i);
            largest = -1;
            if(left < size && arr.get(left) > arr.get(i)){
                largest = left;
            }else{
                largest = i;
            }
            if(right < size && arr.get(right) > arr.get(largest)){
                largest = right;
            }
            if(largest == i)break;

            int tmp = arr.get(i);
            arr.set(i,arr.get(largest));
            arr.set(largest,tmp);

            i = largest;
        }
    }

    public void sort(){
        for(int i = arr.size() - 1;i > 0;i--){
            int tmp = arr.get(0);
            arr.set(0,arr.get(i));
            arr.set(i,tmp);
            size--;
            heapify(0);
        }
        size = arr.size();
    }

    public Iterator<Integer> iterator(){
        return arr.iterator();
    }

    private int parent(int i){
        return (i + 1) / 2 - 1;
    }

    private int lchild(int i){
        return (i << 1) + 1;
    }

    private int rchild(int i){
        return (i << 1) + 2;
    }
}
