package org.example.yunyun;

import java.util.HashMap;

public class Digui {
    public static HashMap<Integer,Integer> map = new HashMap<>();
    public static int f(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        if(map.containsKey(n)) {
            return map.get(n);
        }
        int re =  f(n-1) + f(n-2);
        map.put(n,re);
        return re;
    }

//    public static int f2(int n) {
//        if(n==1) return 1;
//        if(n==2) return 2;
//        while (n>0) {
//
//        }
//    }
//    public static void main(String[] args) {
//        System.out.println(f(4));
//    }
}
