package com.wintig.stack;

/**
 * @author shitian
 * @create 2018-08-06 上午1:50
 */
public class ArrayStackTest {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack.toString());
        }

        stack.pop();
        System.out.println(stack.toString());
    }

}
