package com.mycompany.app.stack;

import java.util.EmptyStackException;

public interface StackInterface<T> {
    public void push(T value);

    public T pop() throws EmptyStackException;
    
    public T peek();
}
