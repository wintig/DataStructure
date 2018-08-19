package com.wintig.tree.bst;

/**
 * @ClassName Main
 * @Despriction 测试BST
 * @Author shitian
 * @Create 2018-08-19 下午4:18
 */
public class Main {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<Integer>();
        int[] nums = {5, 3, 6, 8, 4, 2};

        for (int num : nums) {
            bst.add(num);
        }

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

        bst.levelOrder();
    }

}
