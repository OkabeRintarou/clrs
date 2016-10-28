package chapter10.exercise;

import common.OverFlowException;
import common.UnderFlowException;

public class Queue2Stack<E> {
    private int capacity;
    private Queue<E> queue;
    private Queue<E> tmp;

    public Queue2Stack(int capacity){
        this.capacity = capacity;
        queue = new Queue<E>(capacity);
        tmp = new Queue<E>(capacity);
    }

    public void push(E elem){
        if(size() == capacity){
            throw new OverFlowException();
        }
        queue.enqueue(elem);
    }

    public void pop(){
        if(isEmpty()){
            throw new UnderFlowException();
        }
        if(queue.isEmpty()){
            reset();
            oneLeftMove();
            queue.dequeue();
        }
        else if(queue.size() == 1){
            queue.dequeue();
        }
        else{
            oneLeftMove();
            queue.dequeue();
        }

    }

    private void oneLeftMove(){
        while(!(queue.size() == 1)){
            tmp.enqueue(queue.front());
            queue.dequeue();
        }
    }

    private void reset(){
        while(!tmp.isEmpty()){
            queue.enqueue(tmp.front());
            tmp.dequeue();
        }
    }

    public E top(){
        if(queue.isEmpty()){
            return tmp.back();
        }
        return queue.back();
    }

    public int size(){
        return queue.size() + tmp.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }
}
