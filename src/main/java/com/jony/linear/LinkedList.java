package com.jony.linear;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 链表
 */
public class LinkedList<T> implements Iterable<T>{

    // 头节点
    private Node<T> head;
    // 链表大小
    private int size;

    public LinkedList() {
        this.head = new Node(null, null);
        this.size = 0;
    }

    public void clear(){
        this.head.next = null;
        this.head.data = null;
        this.size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int length(){
        return size;
    }
    public T get(int i){

        if (i < 0 || i >= size){
            throw new RuntimeException("位置不合法！");
        }
        Node<T> tmp = null;
        for (int j = 0; j < i; j++) {
            tmp = head.next;
        }
        return tmp.data;
    }
    public void insert(T t){
        Node newNode = new Node(t, null);
        Node<T> n = head;
        while (n.next != null){
            n = n.next;
        }
        n.next = newNode;
        size ++;
    }
    public void insert(int i,T t){
        if (i < 0 || i > size){
            throw new RuntimeException("位置不合法！");
        }
        Node<T> tmp = head;
        for (int j = 0; j < i; j++) {
            tmp = tmp.next;
        }
        // 位置i的节点

        Node iNode = tmp.next;
        Node<T> newNode = new Node<T>(t, iNode);
        tmp.next = newNode;
        size ++;
    }
    public T remove(int i){
        Node<T> tmp = head;
        if(tmp == null){
            return null;
        }
        for (int j = 0; j < i - 1; j++) {
            tmp = tmp.next;
        }
        Node<T> iNode = tmp.next;
        Node<T> nextTmp = tmp.next.next;
        tmp.next = nextTmp;
        size --;
        return iNode.data;
    }
    public int indexOf(T t){
        Node<T> tmp = head;
        for (int i = 0; i < size; i++) {
            if (tmp.data.equals(t)){
                return i;
            }
            tmp = tmp.next;
        }
        return -1;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }
    // 迭代器
    private class LIterator implements Iterator<T>{

        private Node<T> node;

        public LIterator() {
            this.node = head;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            node = node.next;
            return node.data;
        }
    }

    /**
     * 单链表节点
     */
    private static class Node<T> {
        // 元素
        public T data;
        // 下个节点指针
        public Node<T> next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public static void main(String[] args) {
            Node<Integer> one = new Node<>(1, null);
            Node<Integer> two = new Node<>(2, null);
            Node<Integer> three = new Node<>(3, null);

            one.next = two;
            two.next = three;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.insert(0,"张三");
        list.insert(1,"李四");
        list.insert(2,"王五");
        list.insert(3,"赵六");

        //测试length方法
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.length());
        System.out.println("-------------------");
        //测试get方法
        System.out.println(list.get(2));
        System.out.println("------------------------");
        //测试remove方法
        String remove = list.remove(1);
        System.out.println(remove);
        System.out.println(list.length());
        System.out.println("----------------");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
