package chapter10.exercise;

import common.OverFlowException;
import common.UnderFlowException;

public class SinglyList2Stack<E> {
    private SinglyList<E> list;
    private int capacity;

    public SinglyList2Stack(int c){
        list = new SinglyList<E>();
        capacity = c;
    }

    public void push(E elem){
        if(list.size() == capacity){
            throw new OverFlowException();
        }
        list.insert(elem);
    }

    public void pop(){
        if(isEmpty()){
            throw new UnderFlowException();
        }
        list.delete(0);
    }

    public E top(){
        return list.front();
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}
