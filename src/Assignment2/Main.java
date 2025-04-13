package Assignment2;

import Assignment2.lists.MyArrayList;
import Assignment2.lists.MyLinkedList;
import Assignment2.structures.MyStack;
import Assignment2.structures.MyQueue;
import Assignment2.structures.MyMinHeap;

public class Main {
    public static void main(String[] args) {
        System.out.println("MyArrayList");
        testMyArrayList();

        System.out.println("\nMyLinkedList");
        testMyLinkedList();

        System.out.println("\nMyStack");
        testMyStack();

        System.out.println("\nMyQueue");
        testMyQueue();

        System.out.println("\nMyMinHeap");
        testMyMinHeap();
    }
    
    private static void testMyArrayList() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(5);
        arrayList.add(3);
        arrayList.add(8);
        arrayList.add(1);

        System.out.println("Original MyArrayList:");
        print(arrayList);

        arrayList.set(0, 10);
        arrayList.add(2, 7);
        System.out.println("After set and add at index 2:");
        print(arrayList);

        arrayList.sort();
        System.out.println("After bubble sort:");
        print(arrayList);

        arrayList.removeFirst();
        arrayList.removeLast();
        System.out.println("After removeFirst and removeLast:");
        print(arrayList);

        arrayList.clear();
        System.out.println("After clear, size = " + arrayList.size());
    }

    private static void testMyLinkedList() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(4);
        linkedList.add(9);
        linkedList.add(2);
        linkedList.add(6);

        System.out.println("Original MyLinkedList:");
        print(linkedList);

        linkedList.add(0, 15);
        linkedList.add(2, 12);
        System.out.println("After ADDING:");
        print(linkedList);

        System.out.println("Element at index 3: " + linkedList.get(3));
        linkedList.set(3, 100);
        System.out.println("After SET:");
        print(linkedList);

        linkedList.sort();
        System.out.println("After SORTING:");
        print(linkedList);

        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("After removeFirst and removeLast:");
        print(linkedList);

        linkedList.clear();
        System.out.println("size: " + linkedList.size());
    }

    private static void testMyStack() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("peek: " + stack.peek());
        System.out.println("Pop : " + stack.pop());
        System.out.println("size: " + stack.size());
    }


    private static void testMyQueue() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        System.out.println("peek: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
    }

    private static void testMyMinHeap() {
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.add(15);
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(5);
        minHeap.add(25);

        print(minHeap);
        System.out.println("peek: " + minHeap.peek());

        System.out.print("Extracting elements in order: ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.extractMin() + " ");
        }
        System.out.println();
    }


    private static <T> void print(Iterable<T> arr) {
        for (T i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
