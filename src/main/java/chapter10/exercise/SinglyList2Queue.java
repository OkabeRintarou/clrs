package chapter10.exercise;

import common.OverFlowException;
import common.UnderFlowException;

public class SinglyList2Queue<E> {
    private SinglyList<E> list;
    private int capacity;

    public SinglyList2Queue(int c){
        capacity = c;
        list = new SinglyList<E>();
    }

    public int size(){
        return list.size();
    }

    public void enqueue(E elem){
        if(isFull()){
            throw new OverFlowException();
        }
        list.append(elem);
    }

    public E dequeue(){
        if(isEmpty()){
            throw new UnderFlowException();
        }
        E first = list.front();
        list.delete(0);
        return first;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public boolean isFull(){
        return list.size() == capacity;
    }

    public E front(){
        return list.front();
    }

    public E back(){
        return list.get(list.size() - 1);
    }
}
