package org.example.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TestMap {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(null);

        Object hashSet = set.clone();
        System.out.println(set.equals(hashSet));

        System.out.println(set.contains(null));
        System.out.println(set.remove(4));
        System.out.println(set.remove(null));
        System.out.println(set);
        System.out.println((HashSet)hashSet);
        set.add("5");
        System.out.println(set);
        System.out.println(hashSet);
        System.out.println(set.equals(hashSet));

    }

}
