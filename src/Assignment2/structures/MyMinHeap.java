package Assignment2.structures;

import Assignment2.lists.MyArrayList;

import java.util.Iterator;

public class MyMinHeap<T extends Comparable<T>> implements Iterable<T> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public void add(T element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        return heap.get(0);
    }

    public T extractMin() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        T min = heap.get(0);
        int lastIndex = heap.size() - 1;
        T lastElem = heap.get(lastIndex);
        heap.set(0, lastElem);
        heap.removeLast();
        heapifyDown(0);
        return min;
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int leftIndex = 2 * index + 1;
            int rightIndex = 2 * index + 2;
            int smallestIndex = index;
            if (leftIndex < size && heap.get(leftIndex) != null &&
                    heap.get(leftIndex).compareTo(heap.get(smallestIndex)) < 0) {
                smallestIndex = leftIndex;
            }
            if (rightIndex < size && heap.get(rightIndex) != null &&
                    heap.get(rightIndex).compareTo(heap.get(smallestIndex)) < 0) {
                smallestIndex = rightIndex;
            }
            if (smallestIndex != index) {
                swap(index, smallestIndex);
                index = smallestIndex;
            } else {
                break;
            }
        }
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    @Override
    public Iterator<T> iterator() {
        return heap.iterator();
    }
}
