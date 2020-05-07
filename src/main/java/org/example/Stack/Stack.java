package org.example.Stack;

public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop() throws Exception; // 弹出栈顶元素
    E peek() throws Exception; // 查看栈顶元素
}
