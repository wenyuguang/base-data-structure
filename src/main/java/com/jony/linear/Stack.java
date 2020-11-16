package com.jony.linear;

import java.util.Iterator;
import java.util.List;

/**
 * 栈，先进后出(FILO)
 */
public class Stack<T> implements Iterable{

    private Node head;
    private int size;

    public Stack() {
        this.head = new Node(null, null);
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public T pop(){
        Node<T> oldNode = head.next;
        if(oldNode == null){
            return null;
        }
        head.next = head.next.next;
        size --;
        return oldNode.data;
    }
    public void push(T t){

        Node oldNode = head.next;
        Node<T> tNode = new Node<T>(oldNode, t);
        head.next = tNode;
        size ++;
    }

    @Override
    public Iterator iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        private Node<T> n;

        public SIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
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
        Stack<String> stack = new Stack<>();
        stack.push("2");
        System.out.println(stack.pop());

    }
}
