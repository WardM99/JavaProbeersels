package com.mycompany.app.queue;

public interface QueueInterface<T> {
    void enqueue(T value);

    T dequeue();

    T peek();
}
