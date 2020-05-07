package org.example.queue;

import java.util.Random;

public class TestQueue {
    private static double testQueue(Queue<Integer> q, int opcount) throws Exception{
        long startTime = System.nanoTime();

        Random random= new Random();
        for (int i = 0 ; i < opcount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0 ; i < opcount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) throws Exception{
        int opcount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opcount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opcount);
        System.out.println("ArrayQueue, time: " + time2 + " s");
    }

}
