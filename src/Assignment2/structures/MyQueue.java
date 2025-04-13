package Assignment2.structures;

import Assignment2.lists.MyLinkedList;

public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> queue;
    public MyQueue() {
        queue = new MyLinkedList<>();
    }
    public void enqueue(T value) {
        queue.add(value);
    }
    public T dequeue() {
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        T element = queue.getFirst();
        queue.removeFirst();
        return element;
    }

    public T peek() {
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return queue.getFirst();
    }

    public boolean isEmpty() {
        return queue.size() == 0;
    }

    public int size() {
        return queue.size();
    }
}
