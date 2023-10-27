package com.mycompany.app.queue;

public interface DoubleEndedQueueInterface<T> {
    public void pushBack(T value);

    public void pushFrond(T value);

    public T popBack();

    public T popFront();

    public T peekBack();

    public T peekFront();
}
