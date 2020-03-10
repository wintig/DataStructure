package com.wintig.map;




public class ConcurrentHashMap1丶8<K, V> {

    /**
     * JDK 1.7的ConcurrentHashMap解决了并发问题，并且理论支持N个Segment多次数的并发，但依然存在HashMap再1.7版本中的问题就是遍历链表效率太低
     * 结构上JDK1.8中抛弃了原有的segment分段锁，采用的CAS + synchronized来保证并发安全
     */


    static class Node<K,V> implements java.util.Map.Entry<K,V> {
        final int hash;
        final K key;
        volatile V val;
        volatile Node<K,V> next;

        Node(int hash, K key, V val, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.val = val;
            this.next = next;
        }

        public final K getKey()       { return key; }
        public final V getValue()     { return val; }
        public final int hashCode()   { return key.hashCode() ^ val.hashCode(); }
        public final String toString(){ return key + "=" + val; }
        public final V setValue(V value) {
            throw new UnsupportedOperationException();
        }

        public final boolean equals(Object o) {
            Object k, v, u; java.util.Map.Entry<?,?> e;
            return ((o instanceof java.util.Map.Entry) &&
                    (k = (e = (java.util.Map.Entry<?,?>)o).getKey()) != null &&
                    (v = e.getValue()) != null &&
                    (k == key || k.equals(key)) &&
                    (v == (u = val) || v.equals(u)));
        }

        /**
         * Virtualized support for map.get(); overridden in subclasses.
         */
        Node<K,V> find(int h, Object k) {
            Node<K,V> e = this;
            if (k != null) {
                do {
                    K ek;
                    if (e.hash == h &&
                            ((ek = e.key) == k || (ek != null && k.equals(ek))))
                        return e;
                } while ((e = e.next) != null);
            }
            return null;
        }
    }

}
