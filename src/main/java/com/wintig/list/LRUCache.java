package com.wintig.list;

import java.util.LinkedHashMap;

/**
 * @Description 需求：当缓存数据达到 N 之后需要淘汰掉最近最少使用的数据。
 * @Author wintig
 * @Create 2019-01-05 下午2:58
 */
public class LRUCache {

    private static LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>(5, 0.75f, true);


    public static void main(String[] args) {

        linkedHashMap.put("1", "111");
        linkedHashMap.put("2", "222");
        linkedHashMap.put("3", "333");
        linkedHashMap.put("4", "444");
        linkedHashMap.put("5", "555");

        linkedHashMap.get("2");



        System.out.println(linkedHashMap.toString());

    }

}
