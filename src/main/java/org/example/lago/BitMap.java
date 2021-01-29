package org.example.lago;

public class BitMap {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};
        int position = 35;
        setBit(array, position);
        System.out.println(getBit(array, position));
        clearBit(array, position);
        System.out.println(getBit(array, position));
    }

    public static void setBit(int[] array, int index) {
        int indexElement = index / 32;
        int position = index % 32;
        long flag = 1;
        flag = flag << position;
        array[indexElement] = (int) (array[indexElement] | flag);
        System.out.println(Integer.toBinaryString(array[indexElement]));
    }

    public static boolean getBit(int[] array, int index) {
        int indexElement = index / 32;
        int position = index % 32;
        long flag = 1;
        flag = flag << position;
        return (array[indexElement] & flag) != 0;
    }

    public static void clearBit(int[] array, int index) {
        int indexElement = index / 32;
        int position = index % 32;
        long flag = 1;
        flag = ~(flag << position);
        array[indexElement] = (int) (array[indexElement] & flag);
    }
}
