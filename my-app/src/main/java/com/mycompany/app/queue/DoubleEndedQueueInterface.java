package com.mycompany.app.queue;

import java.util.EmptyStackException;

public interface DoubleEndedQueueInterface<T> {
    public void pushBack(T value);

    public void pushFront(T value);

    public T popBack() throws EmptyStackException;

    public T popFront() throws EmptyStackException;

    public T peekBack();

    public T peekFront();
}
