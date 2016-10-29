package chapter10.exercise;

import common.UnderFlowException;

public class SinglyList<E> {
    private class Node{
        E val;
        Node next;

        public Node(E v,Node n){
            val = v;
            next = n;
        }

        public Node(E v){
            this(v,null);
        }
    }

    private Node head;
    private int size;

    public SinglyList(){
        size = 0;
        head = null;
    }

    public void insert(E elem){
        Node n = new Node(elem,head);
        head = n;
        ++size;
    }

    public void append(E elem){
        Node n = new Node(elem);
        if(head == null){
            head = n;
            ++size;
            return;
        }
        Node x = head;
        while(x.next != null){
            x = x.next;
        }
        x.next = n;
        ++size;
    }

    public void delete(E elem){
        Node x = head;
        Node p = null;
        while(x != null){
            if(x.val == elem){
                break;
            }
            p = x;
            x = x.next;
        }

        if(p != null){
            p.next = x != null ? x.next : null;
            --size;
        }
    }

    public void delete(int i){
        if(isEmpty()){
            return;
        }
        if(size() == 0){
            head = null;
            return;
        }
        int c = 0;
        Node x = head;
        Node p = null;
        while(x != null){
            if(c == i){
                break;
            }
            p = x;
            x = x.next;
        }

        if(p != null){
            p.next = x != null ? x.next : null;
        }
        else{
            head = head.next;
        }
        --size;
    }

    public E front(){
        return head.val;
    }

    private Node lastNode(){
        return null;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E get(int i){
        Node x = head;
        int c = 0;
        while(x != null){
            if(c == i){
                return x.val;
            }
            x = x.next;
            ++c;
        }
        return null;
    }


    public boolean contains(E elem){
        Node x = head;
        while(x != null){
            if(x.equals(elem)){
                return true;
            }
            x = x.next;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void reverse(){
        if(head == null || size == 1){
            return;
        }

        Node p = head;
        Node x = head.next;
        while(x.next != null){
            Node n = x.next;
            x.next = p;
            p = x;
            x = n;
        }
        x.next = p;
        head = x;

    }
}
