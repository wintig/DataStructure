package com.wintig.list;

/**
 * @Description
 * @Author wintig
 * @Create 2019-01-23 下午9:14
 */
public class UnsafeLazyInitialization {

    private  static LinkedList instance;

    public static LinkedList getInstance() {

        if (instance == null)  {
            instance = new LinkedList();       // TAG
        }

        return instance;
    }


}
