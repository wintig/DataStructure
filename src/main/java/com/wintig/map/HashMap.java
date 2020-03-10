package com.wintig.map;

public class HashMap {

    /**
     * hashmap如何解决hash冲突？
     * 当put操作的时候，计算key的hashcode，如果存在相同的hashcode并且key不同的话就说明产生了hash冲突
     * 这时候就可以采用链地址法，我们将冲突元素的数据采用一个类似查找表的数据结构关联起来，这个查找表可以采用链表或者Tree。
     * jdk1.7之前全部采用链表作为查找表，这就会造成如果产生hash冲突的元素很多，那么读取的时间复杂度就会退化成o(n)。
     *
     * 所以jdk1.8之后的hashmap采用链表+红黑树，当发现产生hash冲突的元素达到一定阈值，此时的链表将升级为红黑树
     * 用来解决因为hash冲突产过大而造成的读写效率降低。
     *
     * hashmap的数组长度为什么要保证是2的幂？
     * HashMap的长度为2的幂次方的原因是为了减少Hash碰撞，尽量使Hash算法的结果均匀分布。
     *
     */

}
