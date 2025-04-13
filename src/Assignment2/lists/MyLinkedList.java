package Assignment2.lists;

import Assignment2.interfaces.MyList;

import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;
        MyNode(T data) {
            this.data = data;
        }
    }
    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private MyNode getNode(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++)
                current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--)
                current = current.prev;
        }
        return current;
    }

    @Override
    public void add(T element) {
        MyNode newNode = new MyNode(element);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T element) {
        MyNode node = getNode(index);
        node.data = element;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        MyNode newNode = new MyNode(element);
        if (index == 0) {
            if (head == null) {
                head = tail = newNode;
            }
            else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        }
        else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        else {
            MyNode currentNode = getNode(index);
            MyNode prevNode = currentNode.prev;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            prevNode.next = currentNode;
            currentNode.prev = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        if (head == null){
            throw new RuntimeException("List is empty");
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (tail == null){
            throw new RuntimeException("List is empty");
        }
        return tail.data;
    }

    @Override
    public void remove(int index) {
        MyNode toRemove = getNode(index);
        if (toRemove.prev != null) {
            toRemove.prev.next = toRemove.next;
        } else {
            head = toRemove.next;
        }
        if (toRemove.next != null) {
            toRemove.next.prev = toRemove.prev;
        } else {
            tail = toRemove.prev;
        }
        toRemove.next = toRemove.prev = null;
        size--;
    }


    @Override
    public void removeFirst() {
        if (head == null){
            throw new RuntimeException("List is empty");
        }
        remove(0);
    }

    @Override
    public void removeLast() {
        if (head == null){
            throw new RuntimeException("List is empty");
        }
        remove(size - 1);
    }

    @Override
    public void sort() {
        if (size <= 1){
            return;
        }
        boolean swapped = true;
        while (swapped){
            swapped = false;
            MyNode current = head;
            while (current != null && current.next != null){
                if (current.data.compareTo(current.next.data) > 0){
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (MyNode currentNode = head; currentNode != null; currentNode = currentNode.next, index++) {
            if (object == null && currentNode.data == null) {
                return index;
            }
            if (object != null && object.equals(currentNode.data)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = size-1;
        for (MyNode currentNode = tail; currentNode != null; currentNode = currentNode.prev, index--) {
            if (object == null && currentNode.data == null) {
                return index;
            }
            if (object != null && object.equals(currentNode.data)) {
                return index;
            }

        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (MyNode currentNode = head; currentNode != null; currentNode = currentNode.next) {
            array[i++] = currentNode.data;
        }
        return array;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        MyNode currentNode = head;
        while (currentNode != null) {
            MyNode nextNode = currentNode.next;
            currentNode.prev = currentNode.next = null;
            currentNode.data = null;
            currentNode = nextNode;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode currentNode = head;
            @Override
            public boolean hasNext() {
                return currentNode != null;
            }
            @Override
            public T next() {
                if (currentNode == null){
                    throw new RuntimeException("No more elements");
                }
                T data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
    }
}
