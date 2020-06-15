package org.example.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 3};
        sort(a);
        int[] b = {1};
        sort(b);
    }

    public static void sort(int[] a) {
        /**
         * 选择排序, 每次只处理一个元素, 遍历后边的元素, 找到其中最小的元素, 放到合适的位置上
         * 会进行n次元素交换
         * N²/2 次比较
         */
        if (a == null) return;

        int N = a.length;
        for (int i=0; i<N; i++) {
            int min = i; // 假设当前元素是最小元素
            for (int j=i;j<N; j++) {
                // 从后边的元素中选择最小的, 放在min的位置
                if (CommonSort.less(a[j], a[min])) min = j;
            }
            CommonSort.exch(a, i, min);
        }

        System.out.println("after sorted : " + Arrays.toString(a));
    }
}
