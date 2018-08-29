package com.wintig.tree.trie;

import java.util.TreeMap;

/**
 * @ClassName Trie
 * @Despriction 字典树
 * @Author shitian
 * @Create 2018-08-26 下午4:04
 */
public class Trie {

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    // Trie有多少个单词
    public int size() {
        return size;
    }

    private class Node {

        private boolean isWord;
        private TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    //向Trie中添加一个新的单词
    public void add(String word) {

        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next.get(c) == null) {
                current.next.put(c, new Node());
            }
            current = current.next.get(c);
        }

        if (!current.isWord) {
            current.isWord = true;
            size ++;
        }
    }

    //查询单词
    public boolean contains(String word) {

        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next.get(c) == null) {
                return false;
            }
            current = current.next.get(c);
        }

        return current.isWord;
    }

    //查询是否在Trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix) {

        Node current = root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (current.next.get(c) == null) {
                return false;
            }
            current = current.next.get(c);
        }
        return true;
    }

}
