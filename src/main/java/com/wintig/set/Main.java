package com.wintig.set;

import java.util.ArrayList;

/**
 * @ClassName Main
 * @Despriction TODO
 * @Author shitian
 * @Create 2018-08-20 下午9:50
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            BSTSet<String> set2 = new BSTSet<>();
            for (String word : words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }


    }

}
