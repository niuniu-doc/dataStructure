package org.example.logic;

import java.util.*;

public class TestController {
    public static void main(String[] args) {
//        Map<String, String> map = new TreeMap<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
        Map<String, String> map = new TreeMap<>(Collections.reverseOrder());
        Map<String, String> map1 = new TreeMap<>(Collections.<String>reverseOrder(String.CASE_INSENSITIVE_ORDER));
        map.put("a", "1");
        map.put("b", "2");
        map.put("T", "3");
        map.put("c", "4");

        System.out.println(map.entrySet());
        System.out.println(map.values());
        System.out.println(map.keySet());
        for (Map.Entry<String, String> kv : map.entrySet()) {
            System.out.println(kv.getKey() + ": " + kv.getValue());
        }
    }
}
