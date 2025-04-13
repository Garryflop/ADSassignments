package Assignment2.lists;

import Assignment2.interfaces.MyList;


import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] arr;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        arr = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void increaseCapacity(int minCapacity) {
        if (minCapacity > arr.length){
            int newCapacity = Math.max(minCapacity * 2, arr.length * 2);
            Object[] newElements = new Object[newCapacity];
            for (int i = 0; i < size; i++){
                newElements[i] = arr[i];
            }
            arr = newElements;
        }

    }

    @Override
    public void add(T element) {
        increaseCapacity(size + 1);
        arr[size++] = element;
    }

    @Override
    public void set(int index, T element) {
        checkIndex(index);
        arr[index] = element;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        increaseCapacity(size + 1);
        for (int i = size; i > index; i--){
            arr[i] = arr[i - 1];
        }
        arr[index] = element;
        size++;

    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) arr[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getFirst() {
        if (size == 0){
            throw new RuntimeException("The list is empty");
        }
        return (T) arr[0];
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getLast() {
        if (size == 0){
            throw new RuntimeException("The list is empty");
        }
        return (T) arr[size - 1];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++){
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null;
        size--;
    }

    @Override
    public void removeFirst() {
        if (size == 0){
            throw new RuntimeException("The list is empty");
        }
        remove(0);
    }

    @Override
    public void removeLast() {
        if (size == 0){
            throw new RuntimeException("The list is empty");
        }
        remove(size - 1);
    }

    @Override
    public void sort() {
        boolean swapped;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - 1 - i; j++) {
                T current = (T) arr[j];
                T next = (T) arr[j + 1];
                if (current.compareTo(next) > 0) {
                    arr[j] = next;
                    arr[j + 1] = current;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }


    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++){
            if (arr[i] == null && object == null){
                return i;
            }
            if (arr[i] == null && arr[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = 0; i < size; i++){
            if (arr[i] == null && object == null){
                return i;
            }
            if (arr[i] != null && arr[i].equals(object)){
                return i;
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
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++){
            result[i] = arr[i];
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++){
            arr[i] = null;
        }
        size = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }
            @Override
            public T next() {
                if (!hasNext()){
                    throw new RuntimeException("No more elements");
                }
                return (T) arr[index++];
            }
        };
    }
}
