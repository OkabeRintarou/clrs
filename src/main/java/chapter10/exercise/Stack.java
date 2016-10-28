package chapter10.exercise;

import common.OverFlowException;
import common.UnderFlowException;

public class Stack<E> {
    private int capacity;
    private int top;
    private Object[] elems;

    public Stack(int capacity){
        this.capacity = capacity;
        top = 0;
        elems = new Object[capacity];
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public void push(E elem){
        if(top == capacity){
            throw new OverFlowException();
        }
        elems[top++] = elem;

    }

    public void pop(){
        if(isEmpty()){
            throw new UnderFlowException();
        }
        --top;
    }

    public E top(){
        if(isEmpty()){
            throw new UnderFlowException();
        }
        return (E)elems[top - 1];
    }

    public int size(){
        return top;
    }
}
