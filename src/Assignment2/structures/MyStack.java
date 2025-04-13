package Assignment2.structures;

import Assignment2.lists.MyArrayList;

public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> stack;

    public MyStack() {
        stack = new MyArrayList<>();
    }
    public void push(T value) {
        stack.add(value);
    }
    public T pop() {
        if (isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        T element = stack.get(stack.size()-1);
        stack.removeLast();
        return element;
    }

    public T peek() {
        if (isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return stack.getLast();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public int size() {
        return stack.size();
    }
}
