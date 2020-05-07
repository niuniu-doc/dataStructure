package org.example.Stack;

import org.example.queue.ArrayQueue;
import org.example.queue.LoopQueue;
import org.example.queue.Queue;

import java.util.Random;

public class StackTest {
    private static double testStack(Stack<Integer> stack, int opcount){
        long startTime = System.nanoTime();

        Random random= new Random();
        for (int i = 0 ; i < opcount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0 ; i < opcount; i++) {
            try {
                stack.pop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
//        ArrayStack<Integer> stack = new ArrayStack<>();
//
//        for(int i = 1; i <= 5; i++) {
//            stack.push(i);
//        }
//
//        System.out.println(stack.toString());

        int opcount = 10000000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opcount);
        System.out.println("arrayStack, time: " + time1 + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opcount); // linkedList 有newNode的操作, arrayStack 有扩容的操作
        System.out.println("linkedListStack, time: " + time2 + " s");

    }
}
