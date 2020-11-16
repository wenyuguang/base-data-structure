package com.jony.linear;

import java.util.Iterator;

/**
 * 队列，先进先出
 */
public class Queue<T> implements Iterable{

    private Node<T> head;
    private Node<T> last;
    private int size;

    public Queue() {
        this.head = new Node<T>(null, null);
        this.last = null;
        this.size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public T dequeue(){
        if (isEmpty()){
            return null;
        }
        Node<T> oldFirst = head.next;
        head.next = oldFirst.next;
        size --;
        if (isEmpty()){
            last = null;
        }
        return oldFirst.data;

    }

    public void enqueue(T t){
        if (last == null){
            last = new Node<>(null, t);
            head.next = last;
        }else {
            Node<T> oldLast = last;
            last = new Node<>(null, t);
            oldLast.next = last;
        }
        size ++;
    }

    @Override
    public Iterator iterator() {
        return new QIterator();
    }

    private class QIterator implements  Iterator{

        private Node n;

        public QIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.data;
        }
    }

    private class Node<T>{
        public Node<T> next;
        public T data;

        public Node(Node<T> next, T data) {
            this.next = next;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Queue<String> stringQueue = new Queue<>();
        stringQueue.enqueue("1234567");
        stringQueue.enqueue("this is a test");

        for (Object o : stringQueue) {
            System.out.println(o);
        }
    }
}
