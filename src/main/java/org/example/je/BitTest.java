package org.example.je;

import java.util.Arrays;

public class BitTest {
    static int a=0;
    static {
        a = 1;
//        b = b + 1;
    }
    static int b = 0;
    public static void main(String[] args) {
//        int a;
//        System.out.println(a);
//        System.out.println(b);
//        A ab = new B();
//       ab = new B();
    }
    public int getBit(int[] arr, int index) {
        int arrIndex = index / 32;
        int pos = index % 32;
        long flag = 1;
        flag = flag << pos;
        if ((arr[arrIndex] & flag) != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 将第index位设置为1
     * @param arr
     * @param index
     */
    public void setBit(int[] arr, int index) {
        int arrIndex = index / 32;
        int pos = index % 32;
        long flag = 1;
        flag = flag << pos;

        arr[arrIndex] |= arr[arrIndex] | flag;
        System.out.println(arr);
    }
}
