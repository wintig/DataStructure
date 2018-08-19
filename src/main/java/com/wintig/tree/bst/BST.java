package com.wintig.tree.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author shitian
 * @create 2018-08-18 下午9:43
 */
public class BST<E extends Comparable<E>> {


    private Node root;

    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    //返回插入新节点后二叉树的根
    private Node add(Node node, E e) {

        if (node == null) {
            size ++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }

    }

    //前序遍历序列
    public void preOrder() {
        preOrder(root);
    }

    //以node为根的前序遍历
    private void preOrder(Node node) {

        if (node == null) {
            return;
        }

        System.out.println(node.e);

        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历序列
    public void inOrder() {
        inOrder(root);
    }

    //以node为根的前序遍历
    private void inOrder(Node node) {

        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //后序遍历序列
    public void postOrder() {
        postOrder(root);
    }

    //以node为根的前序遍历
    private void postOrder(Node node) {

        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //二分搜索树非递归前序遍历
    public void preOrderNR() {

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            Node current = stack.pop();
            System.out.println(current.e);

            if (current.right != null) {

                stack.push(current.right);
            }

            if (current.left != null) {

                stack.push(current.left);
            }
        }

    }

    //层序遍历
    public void levelOrder() {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.println(current.e);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

    }

    //寻找二分搜索树中最小的元素
    public E minimum() {

        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }

        return minimum(root).e;
    }

    private Node minimum(Node node) {

        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    //寻找二分搜索树中最小的元素
    public E maximum() {

        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }

        return maximum(root).e;
    }

    private Node maximum(Node node) {

        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }


    //删除最小节点
    public E removeMin() {

        E ret = minimum();
        root = removeMin(root);
    
        return ret;
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
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }

    private class Node{

        public E e;
        private Node left;
        private Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }


}
