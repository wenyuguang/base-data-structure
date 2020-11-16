package com.jony.symbol;


/**
 * 符号表
 */
public class SymbolTable<K, V> {

    private Node<K, V> head;
    private int size;

    public SymbolTable() {
        this.head = new Node<>(null, null, null);
        this.size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    // 添加键值对，有重复key需要替换value
    public void put(K key,V value){
        Node n = head;
        // 替换重复的
        while (n.next != null){
            n = n.next;
            if (n.key.equals(key)){
                n.value = value;
                return;
            }
        }

        Node<K, V> oldHead = head.next;
        Node<K, V> newNode = new Node<>(oldHead, key, value);
        head.next = newNode;
        size ++;
    }
    public V get(K key){
        Node<K, V> n = head;
        while (n.next != null){
            n = n.next;
            if (n.key.equals(key)){
                return n.value;
            }
        }
        return null;
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

    public static void main(String[] args) {
        SymbolTable<String, String> stringStringSymbolTable = new SymbolTable<>();
        stringStringSymbolTable.put("1", "stringStringSymbolTable");
        stringStringSymbolTable.put("www", "Go语言的结构体（struct）和其他语言的类（class）有同等的地位，但Go语言放弃了包括继 承在内的大量面向对象特性，只保留了组合（composition）这个最基础的特性。 组合甚至不能算面向对象特性，因为在C语言这样的过程式编程语言中，也有结构体，也有组合。组合只是形成复合类型的基础。\n" +
                "\n" +
                "type Rect struct {\n" +
                "    x, y float64\n" +
                "    width, height float64\n" +
                "}");
        System.out.println(stringStringSymbolTable.get("www"));
        System.out.println(stringStringSymbolTable.get("1"));

    }
}
