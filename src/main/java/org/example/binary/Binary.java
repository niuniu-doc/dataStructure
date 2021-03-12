package org.example.binary;

public class Binary {
    public static void main(String[] args) {
        int x = 22, n = 3;
        // 11110
        System.out.println("22: " + Integer.toBinaryString(x));
        System.out.println("-22: " + Integer.toBinaryString(-x));
        System.out.println("30: " + Integer.toBinaryString(30));
        System.out.println("-30: " + Integer.toBinaryString(-30));
//        clearLowest(x, n);
        getN(x, n);
        getNMi(x, n);
        getNMi(30, n);
//        setBit1(x, n);
//        setBit0(x, n);
//        clearNBit(x, n);
//        clearN20Bit(x, n);
    }

    /**
     * 将x的最右边n位清零
     */
    private static void clearLowest(int x, int n) {
        int tmp = ~0<<n; // ~0:11111111111111111111111111111111, ~0<<n: 11111111111111111111111111111000
        int t = x&tmp;
        System.out.println("~0: " + Integer.toBinaryString(~0));
        System.out.println("~0<<n: " + Integer.toBinaryString(tmp));
        System.out.println("t: " + Integer.toBinaryString(t));
    }

    /**
     * 获取x的第n位的值
     */
    private static void getN(int x, int n) {
        int tmp = x>>n; // 10110 -> 10
        int res = tmp&1; // 10 & 1 -> 0
        System.out.println("x>>n: " + Integer.toBinaryString(tmp));
        System.out.println("getN: " + Integer.toBinaryString(res));
    }

    /**
     * 获取x的第n位的幂值
     * 若第n位为0, 则为0, 否则为 2ⁿ
     */
    private static void getNMi(int x, int n) {
        int tmp = 1<<n; // 1000
        int res = tmp&x; // 01000 & 10110 -> 0000; 01000&11110 -> 01000
        System.out.println("1<<n: " + Integer.toBinaryString(tmp));
        System.out.println("getNMi: " + Integer.toBinaryString(res));
    }

    /**
     * 将第n位置为1
     */
    private static void setBit1(int x, int n) {
        int tmp = 1<<n; // 1000
        int res = tmp|x; // 1000 | 10110 -> 11110
        System.out.println("1<<n: " + Integer.toBinaryString(tmp));
        System.out.println("setBit: " + Integer.toBinaryString(res));
        System.out.println("setBit: " + Integer.toBinaryString(x|(1<<n)));
    }

    /**
     * 将第n为置为0
     */
    private static void setBit0(int x, int n) {
        int tmp = 1<<n; // 1000
        int res = x&(~tmp); // 10110 | 11111111111111111111111111110111 -> 10110
        System.out.println("1<<n: " + Integer.toBinaryString(tmp));
        System.out.println("~x: " + Integer.toBinaryString(~tmp));
        System.out.println("setBit: " + Integer.toBinaryString(res));
        System.out.println("setBit: " + Integer.toBinaryString(x&(~(1<<n))));
    }

    /**
     * 将最高位至第n位(含)置清0
     */
    private static void clearNBit(int x, int n) {
        int tmp = 1<<n; // 1000
        int t = tmp-1; // 111
        int res = x&t; // 10110 | 00000000000000000000000000000111 -> 00110
        System.out.println("1<<n: " + Integer.toBinaryString(tmp));
        System.out.println("t: " + Integer.toBinaryString(t));
        System.out.println("clearNBit: " + Integer.toBinaryString(res));
        System.out.println("clearNBit: " + Integer.toBinaryString(x&((1<<n)-1)));
    }

    /**
     * 将第n位至第0位(含)清0
     */
    private static void clearN20Bit(int x, int n) {
        int tmp = 1<<(n+1); // 10000
        int t = tmp-1; // 1111
        int res = x&(~t); // 11111111111111111111111111110000 & 10110 -> 10000
        System.out.println("1<<(n+1): " + Integer.toBinaryString(tmp));
        System.out.println("t: " + Integer.toBinaryString(t));
        System.out.println("~t: " + Integer.toBinaryString(~t));
        System.out.println("clearN20Bit: " + Integer.toBinaryString(res));
        System.out.println("clearN20Bit: " + Integer.toBinaryString(x&(~((1<<(n+1))-1))));
    }

}





