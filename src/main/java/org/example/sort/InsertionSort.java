package org.example.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 3};
        sort(a);
        int[] b = {2, 3, 4, 1};
        sort(a);
    }
    public static void sort(int[] a) {
        if (a == null) return;
        if (a.length == 1) System.out.println(a);

        /**
         * 插入排序, 左侧都是已排序元素, 每次从右侧选择一个元素, 插入到合适的位置
         * 每次只与前一个元素比较, 若比前一个元素小, 则交换
         * 平均交换次数 N²/4, 最坏 N²/2, 最好 N-1
         * 比较次数与交换次数相同
         */
        int N = a.length;
        for (int i=1; i<N; i++) {
            for (int j = i; j > 0 && CommonSort.less(a[j], a[j-1]) ; j--) {
                CommonSort.exch(a, j, j-1);
            }
        }
        System.out.println("after sorted a is: " + Arrays.toString(a));
    }
}
