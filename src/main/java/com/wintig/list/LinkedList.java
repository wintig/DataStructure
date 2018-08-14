package com.wintig.list;



/**
 * @author shitian
 * @create 2018-08-13 下午10:33
 */
public class LinkedList<E> {

    /**
     * 因为插入元素的时候，需要把上一个节点的next指向插入节点
     * 为了防止待插入节点位置为头的这种情况，所以设置一个虚拟节点
     */
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    //获取连表中的元素个数
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

//        Node node = new Node(e);
//        node.next = prev.next;
//        prev.next = node;

        //同上
        prev.next = new Node(e, prev.next);

        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e){
        add(size, e);
    }

    public E get(int index) {

        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node cur = dummyHead.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = dummyHead.next;
        for(int i = 0 ; i < index ; i ++)
            cur = cur.next;
        cur.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e){

        Node cur = dummyHead.next;

        while (cur != null){

            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) {

        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node prev = dummyHead;
        for(int i = 0 ; i < index ; i ++) {
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;

        return retNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }


    private class Node {

        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0 ; i < 5 ; i ++) {
            linkedList.addFirst(i);
            System.out.println(linkedList.toString());
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
