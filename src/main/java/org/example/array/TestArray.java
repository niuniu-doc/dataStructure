package org.example.array;

public class TestArray {
    public static int[] data; // 定义数组、保存数据
    public static int n; // 数组长度
    public static int count; // 数组中元素的个数(实际包含元素数量)

    /**
     * 构造方法、初始化数组
     */
    public TestArray(int capacity) {
        n = capacity;
        data = new int[capacity];
        count = 0; // 最初没有元素、所以定义为 0;
    }

    /**
     * 按照索引下标查找
     */
    public int find(int index) {
        if (index <0 || index > count) {
           return -1;
        }

        return data[index];
    }

    /**
     * 数据插入
     */
    public boolean insert(int index, int val) {
        // check index
        if (index < 0 || index > n) {
            System.out.println("data position is error.");
            return false;
        }

        // data is full.
        if (count == n) {
            System.out.println("data is full");
            return false;
        }

        for (int i = count; i > index; --i) {
            data[i] = data[i-1];
        }
        data[index] = val;
        ++count;

        return true;
    }

    /**
     * 根据索引、删除删除
     */
    public boolean remove(int index) {
        if (index < 0 || index > count) return false;

        for (int i = index + 1; i < count; i++) {
            data[i-1] = data[i];
        }
        count--;

        return true;
    }

    /**
     * 打印所有数据
     */
    public static void printAll () {
        for (int i = 0; i <= count; i++) {
            System.out.println("i: " + i + ", val :" + data[i]);
        }

    }

    public static void main(String[] args) {
        TestArray testArray = new TestArray(5);
        testArray.insert(1, 1);
        testArray.insert(2, 2);
        testArray.insert(3, 3);
        printAll();
        testArray.remove(2);
        System.out.println("-----------------");
        printAll();
    }


}
