package com.wintig.map;

import java.util.HashMap;
import java.util.UUID;

public class HashMap死循环证明 {


    public static void main(String[] args) {

        final HashMap<String, String> map = new HashMap<>(2);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                            System.out.println("1");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
