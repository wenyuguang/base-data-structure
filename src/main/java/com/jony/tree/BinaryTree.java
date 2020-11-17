package com.jony.tree;

import com.jony.linear.Queue;

/**
 * 二叉树
 */
public class BinaryTree<K extends Comparable<K>, V> {


    private Node root;
    private int size;

    public void put(K k, V v){
        root = put(root, k, v);

    }

    // 存数据，key小的在左子节点，大的在右子节点
    private Node put(Node node, K k, V v) {
        // 根节点不存在
        if (node == null){
            size ++;
            return new Node(null, null, k, v);
        }
        int cmp = k.compareTo(node.key);
        // k比root.key大，走右边节点
        if (cmp > 0){
            node.right = put(node.right, k, v);
        }else if (cmp < 0){
            node.left = put(node.left, k, v);
        }else {// key相等
            node.value = v;
        }

        return node;
    }
    // 获取k对应的值
    public V get(K k){
        return get(root, k);
    }

    public V get(Node node, K k) {
        if (node == null){
            return null;
        }
        int cmp = k.compareTo(node.key);
        // key比节点大，从右边结点寻找
        if (cmp > 0){
             return get(node.right, k);
        }else if (cmp < 0){
            return get(node.left, k);
        }else {
            return node.value;
        }
    }
    // 删除键k的值
    public void delete(K k){
        root = delete(root, k);
    }

    private Node delete(Node node, K k) {
        if (node == null){
            return null;
        }
        int cmp = k.compareTo(node.key);
        if (cmp > 0){
            node.right = delete(node.right, k);
        }else if (cmp < 0){
            node.left = delete(node.left, k);
        }else {
            // 新结点的key等于当前结点的key,当前x就是要删除的结点
            // 1.如果当前结点的右子树不存在，则直接返回当前结点的左子结点
            if (node.right == null){
                return node.left;
            }
            // 2.如果当前结点的左子树不存在，则直接返回当前结点的右子结点
            if (node.left == null){
                return node.right;
            }
            // 3.当前结点的左右子树都存在
            // 3.1找到右子树中小的结点
            Node n = node.right;
            while (n.left != null){
                n = n.left;
            }
            //3.2删除右子树中小的结点
            Node nodeR = node.right;
            while (nodeR.left != null){
                if (nodeR.left.left == null){
                    nodeR.left = null;
                }else {
                    nodeR = nodeR.left;
                }
            }
            // 3.3让被删除结点的左子树称为小结点n的左子树，让被删除结点的右子树称为小结点 n的右子树
            n.left = node.left;
            n.right = node.right;
            node = n;
            size --;
        }
        return node;
    }
    // 查找最小的key，最左子节点
    public K min(){
        return min(root).key;
    }

    private Node min(Node root) {
        if (root.left != null){
            return min(root.left);
        }else {
            return root;
        }
    }

    public K max(){
        return max(root).key;
    }

    private Node max(Node root) {
        if (root.right != null){
            return max(root.right);
        }else {
            return root;
        }
    }

    /**
     * 前序遍历 ---中左右
     * @return
     */
    public Queue<K> preErgodic(){
        Queue<K> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }

    private void preErgodic(Node node, Queue<K> keys) {
        if (node == null){
            return;
        }
        // 当前节点key放入
        keys.enqueue(node.key);
        // 遍历左边
        if (node.left != null){
            preErgodic(node.left, keys);
        }
        // 遍历右边
        if (node.right != null){
            preErgodic(node.right, keys);
        }
    }

    /**
     * 中序遍历---左中右
     * @return
     */
    public Queue<K> midErgodic(){
        Queue<K> keys = new Queue<>();
        midErgodic(root, keys);
        return keys;
    }

    private void midErgodic(Node node, Queue<K> keys) {
        if (node == null){
            return;
        }

        // 遍历左边
        if (node.left != null){
            midErgodic(node.left, keys);
        }
        // 当前节点key放入
        keys.enqueue(node.key);
        // 遍历右边
        if (node.right != null){
            midErgodic(node.right, keys);
        }
    }

    /**
     * 后序遍历---左右中
     * @return
     */
    public Queue<K> afterErgodic(){
        Queue<K> keys = new Queue<>();
        afterErgodic(root, keys);
        return keys;
    }

    private void afterErgodic(Node node, Queue<K> keys) {
        if (node == null){
            return;
        }
        // 遍历左边
        if (node.left != null){
            afterErgodic(node.left, keys);
        }
        // 遍历右边
        if (node.right != null){
            afterErgodic(node.right, keys);
        }
        // 当前节点key放入
        keys.enqueue(node.key);
    }
    // 层序遍历
    public Queue<K> layerErgodic(){
        Queue<K> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();
        nodes.enqueue(root);
        while (!nodes.isEmpty()){
            Node n = nodes.dequeue();
            // 存入当前节点
            keys.enqueue(n.key);
            // 当前节点左子节点存在存入
            if (n.left != null){
                nodes.enqueue(n.left);
            }
            // 当前节点右子节点存在存入
            if (n.right != null){
                nodes.enqueue(n.right);
            }
        }
        return keys;
    }
    // 最大深度
    public int maxDepth(){
        return maxDepth(root);
    }

    private int maxDepth(Node root) {
        if (root == null){
            return 0;
        }
        int maxLeft = 0;
        int maxRight = 0;
        int max = 0;
        // 递归左子节点
        if (root.left != null){
            maxLeft = maxDepth(root.left);
        }
        // 递归右子节点
        if (root.right != null){
            maxRight = maxDepth(root.right);
        }
        max = maxLeft > maxRight ? maxLeft + 1 : maxRight + 1;
        return max;
    }


    private class Node{

        public Node left;
        public Node right;
        public K key;
        public V value;

        public Node(Node left, Node right, K key, V value) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinaryTree<String, String> stringStringBinaryTree = new BinaryTree<>();
        stringStringBinaryTree.put("123", "1232132132132dasfadsfadsfds");
        stringStringBinaryTree.put("tree", "每个结点至多拥有两棵子树(即二叉树中不存在度大于2的结点)，并且，二叉树的子树有左右之分，其次序不能任意颠倒。\n" +
                "二叉树的性质\n" +
                "1.若二叉树的层次从0开始，则在二叉树的第i层至多有2^i个结点(i>=0)\n" +
                "2.高度为k的二叉树最多有2^(k+1) - 1个结点(k>=-1)(空树的高度为-1)\n" +
                "3.对任何一棵二叉树，如果其叶子结点(度为0)数为m, 度为2的结点数为n, 则m = n + 1\n" +
                "\n" +
                "来源：简书\n" +
                "著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。");
        System.out.println(stringStringBinaryTree.get("tree"));

    }
}
