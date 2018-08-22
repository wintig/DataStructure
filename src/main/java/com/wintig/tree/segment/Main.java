package com.wintig.tree.segment;

/**
 * @ClassName Main
 * @Despriction test segment tree
 * @Author shitian
 * @Create 2018-08-22 下午11:46
 */
public class Main {

    public static void main(String[] args) {

        Integer[] nums = {-2, 0, 3, -5, 2, -1};

        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);

        //System.out.println(segmentTree.toString());
        System.out.println(segmentTree.query(0, nums.length - 1));
    }

}
