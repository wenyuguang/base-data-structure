package com.jony.linear;

import java.util.Iterator;

/**
 * 双向链表
 */
public class TwoWayLinkedList<T> implements Iterable<T>{

    // 头结点
    private Node<T> head;
    // 尾结点
    private Node<T> last;
    // 元素大小
    private int size;

    public TwoWayLinkedList() {
        this.head = new Node<>(null, null, null);
        this.last = null;
        this.size = 0;
    }

    public void clear(){
        this.head = new Node<>(null, null, null);
        this.last = null;
        this.size = 0;
    }

    public int length(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void insert(T t){
        if (last == null){
            last = new Node(head, null, t);
            head.next = last;
        }else {
            Node<T> oldLast = this.last;
            Node newNode = new Node(oldLast, null, t);
            oldLast.next = newNode;
            last = newNode;
        }
        size ++;
    }

    public T insert(int i, T t){
        Node pre = head;
        for (int j = 0; j < i; j++) {
            pre = pre.next;
        }
        Node<T> currentNode = pre.next;
        Node<T> newNode = new Node<T>(pre, currentNode, t);
        currentNode.pre = newNode;
        pre.next = newNode;
        size ++;
        return currentNode.data;
    }

    public T get(int i) {
        Node<T> currentNode = head.next;
        for (int j = 0; j < i; j++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    public int indexOf(T t){
        Node<T> head = this.head;
        int i = 0;
        while ((head = head.next) != null){
            i ++;
            if (t.equals(head.data)){
                return i;
            }
        }
        return -1;
    }

    public T remove(int i){
        Node<T> tmp = this.head;
        for (int j = 0; j < i; j++) {
            tmp = tmp.next;
        }
        // 索引i的位置节点
        Node<T> currentNode = tmp.next;
        // 索引i下一个节点
        Node<T> next = currentNode.next;
        tmp.next = next;
        next.pre = tmp;
        size --;

        return currentNode.data;

    }

    public T getLast(){
        if (last == null){
            return null;
        }
        return last.data;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class TIterator implements Iterator{

        private Node<T> n;

        public TIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return head.next != null;
        }

        @Override
        public Object next() {
            return n.next.data;
        }
    }
    /**
     * 双向链表节点
     * @param <T>
     */
    private static class Node<T>{

        public Node<T> pre;
        public Node<T> next;
        public T data;

        public Node(Node<T> pre, Node<T> next, T data) {
            this.pre = pre;
            this.next = next;
            this.data = data;
        }
    }
}
