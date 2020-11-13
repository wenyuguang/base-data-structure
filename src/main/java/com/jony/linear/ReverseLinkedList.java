package com.jony.linear;

/**
 * 反转单链表
 */
public class ReverseLinkedList {

    // 递归到最里面会死循环？？？
    public static Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node tmp = head.next;
        // 递归压栈
        Node newHead = reverse(tmp);
        tmp.next = newHead;
        head.next = null;

        return newHead;
    }


    public static void main(String[] args) {
        Node node3 = new Node(null, 4);
        Node node2 = new Node(node3, 3);
        Node node1 = new Node(node2, 2);
        Node node = new Node(node1, 1);
        Node reverseNode = reverse(node);
        Node tmp = reverseNode;
        while (tmp.next != null){
            System.out.print(tmp.data + "->");
            tmp = tmp.next;
        }
    }


    private static class Node<T> {
        public Node next;
        public T data;

        public Node(Node next, T data) {
            this.next = next;
            this.data = data;
        }
    }
}
