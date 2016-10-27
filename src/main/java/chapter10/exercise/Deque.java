package chapter10.exercise;

import common.OverFlowException;
import common.UnderFlowException;

public class Deque<T> {
    private int capacity;
    private int size;
    private int head;
    private int tail;
    private Object[] elems;

    public Deque(int capacity){
        this.capacity = capacity;
        size = 0;
        if(capacity == 1){
            head = tail = 0;
        }
        else if(capacity == 2){
            head = 0;
            tail = 1;
        }
        else{
            head = capacity / 2;
            tail = inc(head);
        }
        elems = new Object[capacity];
    }

    public void pushFront(T elem){
        if(isFull()){
            throw new OverFlowException();
        }
        elems[head] = elem;
        head = dec(head);
        ++size;
    }

    public void pushBack(T elem){
        if(isFull()){
            throw new OverFlowException();
        }
        elems[tail] = elem;
        tail = inc(tail);
        ++size;
    }

    public void popFront(){
        if(isEmpty()){
            throw new UnderFlowException();
        }
        head = inc(head);
        --size;
    }

    public void popBack(){
        if(isEmpty()){
            throw new UnderFlowException();
        }
        tail = dec(tail);
        --size;
    }

    public T front(){
        return (T)elems[inc(head)];
    }

    public T back(){
        return (T)elems[dec(tail)];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public int size(){
        return size;
    }

    private int inc(int i){
        return (i + 1) % capacity;
    }

    private int dec(int i){
        i--;
        if(i < 0){
            i = capacity - 1;
        }
        return i;
    }
}
