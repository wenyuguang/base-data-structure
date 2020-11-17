package com.jony.symbol;

import java.util.Iterator;

/**
 * 有序符号表
 * @param <K>
 * @param <V>
 */
public class OrderSymbolTable<K extends Comparable<K>, V> {

    private Node head;
    private int size;

    public OrderSymbolTable() {
        this.head = new Node(null, null, null);
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void delete(K key){
        Node<K, V> n = head;
        while (n.next != null){
            if (n.key.equals(key)){
                n.next = n.next.next;
                size --;
                return;
            }
            n = n.next;
        }
    }

    public V get(K key){
        Node<K, V> n = head;
        while (n.next != null){
            if (n.key.equals(key)){
                return n.value;
            }
            n = n.next;
        }
        return null;
    }

    public void put(K key, V value){
        Node<K, V> currentNode = head.next;
        Node<K, V> pre = head;
        // key与当前节点相等，替换value
        if (currentNode != null && key.compareTo(currentNode.key) == 0){
            currentNode.value = value;
            return;
        }
        // 循环比大小，直到key符合条件退出循环
        while (currentNode != null && key.compareTo(currentNode.key) > 0){
            pre = currentNode;
            currentNode = currentNode.next;
        }
        Node<K, V> newNode = new Node<>(currentNode, key, value);
        pre.next = newNode;
        size ++;
    }


    private class Node<K, V>{

        public Node<K, V> next;
        public K key;
        public V value;

        public Node(Node<K, V> next, K key, V value) {
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }
    private static class Student{

    }
    public static void main(String[] args) {
        OrderSymbolTable<String, Student> stringStudentOrderSymbolTable = new OrderSymbolTable<String, Student>();
    }
}
