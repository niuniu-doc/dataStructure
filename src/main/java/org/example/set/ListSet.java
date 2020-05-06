package org.example.set;

import org.example.linkedlist.DummyHeadLinekdList;

public class ListSet<E> implements Set<E> {
    private DummyHeadLinekdList<E> list;
    public ListSet() {
        list = new DummyHeadLinekdList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }
}
