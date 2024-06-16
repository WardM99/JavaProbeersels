package com.mycompany.app.queue;

import java.util.EmptyStackException;

public interface DoubleEndedQueueInterface<T> {
    void pushBack(T value);

    void pushFront(T value);

    T popBack() throws EmptyStackException;

    T popFront() throws EmptyStackException;

    T peekBack();

    T peekFront();
}
