package org.example.sort;

public class CommonSort {
    public static boolean less(int m, int n) {
        return m < n;
    }

    public static void exch(int[] a, int m, int n) {
        int tmp = a[m];
        a[m] = a[n];
        a[n] = tmp;
    }

    public static boolean isSorted(int[] a) {
        for (int i=1; i<a.length; i++) {
            if (a[i] > a[i-1]) return false;
        }
        return true;
    }
}
