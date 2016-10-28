package chapter10.exercise;

import common.OverFlowException;
import common.UnderFlowException;

public class Stack2Queue<E> {
    private Stack<E> st;
    private Stack<E> tmp;
    private int capacity;

    public Stack2Queue(int capacity){
        this.capacity = capacity;
        st = new Stack<E>(capacity);
        tmp = new Stack<E>(capacity);
    }
    public void enqueue(E elem){
        if(isFull()){
            throw new OverFlowException();
        }
        st.push(elem);
    }

    public void dequeue(){
        if(isEmpty()){
            throw new UnderFlowException();
        }
        if(tmp.isEmpty()){
            while(!st.isEmpty()){
                tmp.push(st.top());
                st.pop();
            }
        }
        tmp.pop();
    }

    public E front(){
        if(tmp.isEmpty()){
            while(!st.isEmpty()){
                tmp.push(st.top());
                st.pop();
            }
        }
        return tmp.top();
    }

    public E back(){
        if(st.isEmpty()){
            while(!tmp.isEmpty()){
                st.push(tmp.top());
                tmp.pop();
            }
        }
        return st.top();
    }

    public boolean isEmpty(){
        return st.size() + tmp.size() == 0;
    }

    public boolean isFull(){
        return st.size() + tmp.size() == capacity;
    }

    public int size(){
        return st.size() + tmp.size();
    }
}
