package com.wintig.tree.segment;

/**
 * @ClassName Merger
 * @Despriction 比较器
 * @Author shitian
 * @Create 2018-08-22 下午11:43
 */
public interface Merger<E> {

    /**
     * 合并两个元素
     */
    E merge(E a, E b);

}
