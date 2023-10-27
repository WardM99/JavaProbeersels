package com.mycompany.app.stack;

public interface StackInterface<T> {
    public void push(T value);

    public T pop();
    
    public T peek();
}
