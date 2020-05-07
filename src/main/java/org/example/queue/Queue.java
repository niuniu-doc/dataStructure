package org.example.queue;

public interface Queue<E> {
    E dequeue() throws Exception;
    E getFront() throws Exception;
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
}
