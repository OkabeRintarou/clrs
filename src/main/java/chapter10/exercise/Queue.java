package chapter10.exercise;

import common.OverFlowException;
import common.UnderFlowException;

public class Queue<T> {
    private int capacity;
    private int size;
    private int head;
    private int tail;
    private Object[] elems;

    public Queue(int capacity){
        head = tail = 0;
        this.capacity = capacity;
        elems = new Object[capacity];
    }

    public T dequeue(){
        if(isEmpty()){
            throw new UnderFlowException();
        }
        T x = (T)elems[head];
        head = inc(head);
        --size;
        return x;
    }

    public void enqueue(T elem){
        if(isFull()){
            throw new OverFlowException();
        }
        elems[tail] = elem;
        tail = inc(tail);
        ++size;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public T front(){
        return (T)elems[head];
    }

    public T back(){
        return (T)elems[(head + size - 1) % capacity];
    }

    private int inc(int i){
        return (i + 1) % capacity;
    }
}
