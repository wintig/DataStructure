package com.wintig.map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V>  {


    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    //返回插入新节点后二叉树的根
    private Node add(Node node, K key, V value) {

        if (node == null) {
            size ++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else // key.compareTo(node.key) == 0
            node.value = value;

        return node;
    }

    @Override
    public V remove(K key) {

        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
        }

        return null;
    }

    //删除以node为根的二分搜索树中值为k的节点，删除后返回二分搜索树的根
    private Node remove(Node node, K key) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else { // key == node.key

            //待删除左子树为null
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            //待删除右子数为null
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            //左右子数均不为null，找到比待删除节点大的最小节点，既待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);    //这一步已经进行了size--;
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }

    }

    private Node minimum(Node node) {

        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    //删除以node为根的二分搜索树中的最小节点
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "不存在");
        }

        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else // if key.compareTo(node.keu) > 0
            return getNode(node.right, key);
    }

    private Node root;
    private int size;

    private class  Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

}
