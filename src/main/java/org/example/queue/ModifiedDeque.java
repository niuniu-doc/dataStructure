package org.example.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 使用addFirst / addLast 改写queue代码
 */
public class ModifiedDeque {
    /**
     * 输出结果:
     * ====== before modified begin =======
     * c
     * [c, b, a]
     * c
     * b
     * a
     * []
     *
     * ====== before modified end =======
     * ====== after modified begin =======
     * c
     * [c, b, a]
     * c
     * b
     * a
     * []
     * ====== after modified end =======
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("====== before modified begin =======");

        beforeModified();

        System.out.println("====== before modified end =======");

        System.out.println("====== after modified begin =======");

        afterModified();

        System.out.println("====== after modified end =======");

    }

    /**
     * 原始代码实现
     */
    static void beforeModified() {
        Deque<String> deque = new LinkedList<>();
        deque.push("a");
        deque.push("b");
        deque.push("c");

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }

        System.out.println(deque);

        System.out.println();
    }

    /**
     * 修改后的实现
     */
    static void afterModified() {

        Deque<String> deque = new LinkedList<>();
        /**
         * addFirst 相当于队列push的作用, addLast 相当于栈的push
         * peekFirst 相当于栈的pop, peekLast相当于队列的pop
         * 所以、dequeue相当于 queue + stack
         */
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }

        System.out.println(deque);
    }
}
