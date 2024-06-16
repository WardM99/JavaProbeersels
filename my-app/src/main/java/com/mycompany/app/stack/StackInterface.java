package com.mycompany.app.stack;

import java.util.EmptyStackException;

public interface StackInterface<T> {
    void push(T value);

    T pop() throws EmptyStackException;
    
    T peek();
}
