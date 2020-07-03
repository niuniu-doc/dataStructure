package org.example.myTest.array;

public class MovingAverage {
    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));

        System.out.println();
        System.out.println(1);
        System.out.println((1+10)/2);
        System.out.println((1+10+3)/3);
        System.out.println((10+3+5)/3);
    }
    private MyCircularQueue2 data;
    private int size=0; //当前元素个数
    private double res=0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        data = new MyCircularQueue2(size);
    }

    public int next(int val) {
        if (this.size >= data.getSize()) {
            int front = data.Front();
            res -= front;
            data.deQueue();
            size--;
        }
        data.enQueue(val);
        size++;
        res += val;

        return (int)(res/size);
    }
}
