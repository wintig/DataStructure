package com.wintig.tree.bst;

import java.util.ArrayList;
import java.util.Random;

/**
 * @ClassName Main
 * @Despriction 测试BST
 * @Author shitian
 * @Create 2018-08-19 下午4:18
 */
public class Main {

    public static void main(String[] args) {
//
        BST<Integer> bst = new BST<Integer>();
//        int[] nums = {5, 3, 6, 8, 4, 2};
//
//        for (int num : nums) {
//            bst.add(num);
//        }

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
//
//        bst.preOrder();
//        System.out.println("=================");
//        bst.inOrder();
//        System.out.println("=================");
//        bst.postOrder();

//        bst.preOrder();
//        System.out.println("=======");
//        bst.preOrderNR();

//        bst.levelOrder();

        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums = new ArrayList<>();

        while (!bst.isEmpty()) {
            nums.add(bst.removeMin());
        }

        System.out.println(nums);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                throw new IllegalArgumentException("error");
            }
        }

        System.out.println("removeMin test completed.");
    }

}
