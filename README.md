

# Data Structures Documentation for ASSIGNMENT2 ADS COURSE

This project implements custom data structures in Java, including:

- `MyList` (Interface)
- `MyArrayList` (Dynamic array list)
- `MyLinkedList` (Singly linked list)
- `MyMinHeap` (Minimum binary heap)
- `MyStack` (LIFO stack)
- `MyQueue` (FIFO queue)

Each structure is designed for educational purposes, mimicking Java Collections API functionality.

---

## Interface: MyList<T>
Defines a common interface for list-based data structures.

### Methods
- `void add(T element)` — Adds an element to the end.
- `void add(int index, T element)` — Adds an element at a specified index.
- `void set(int index, T element)` — Replaces an element at index.
- `T get(int index)` — Returns the element at index.
- `T getFirst()` — Returns the first element.
- `T getLast()` — Returns the last element.
- `void remove(int index)` — Removes the element at index.
- `void removeFirst()` — Removes the first element.
- `void removeLast()` — Removes the last element.
- `void sort()` — Sorts the list.
- `int indexOf(Object obj)` — Returns the first index of the object.
- `int lastIndexOf(Object obj)` — Returns the last index of the object.
- `boolean exists(Object obj)` — Checks if the object exists in the list.
- `Object[] toArray()` — Converts the list to an array.
- `int size()` — Returns the number of elements.
- `void clear()` — Clears the list.
- `Iterator<T> iterator()` — Returns an iterator.

---

## Class: MyArrayList<T>
An implementation of `MyList` using a dynamic array.

### Key Features
- Backed by an array with automatic resizing.
- Implements all `MyList` methods.
- Efficient memory access.

---

## Class: MyLinkedList<T>
An implementation of `MyList` using a singly linked list.

### Key Features
- Node-based structure.
- Efficient insertions/removals at ends.
- Implements all `MyList` methods.

---

## Class: MyMinHeap
A generic minimum heap implementation based on binary heap structure.

### Key Features
- Backed by `MyArrayList`.
- Supports heap operations:
  - `void add(T element)` — Inserts an element and maintains heap invariant.
  - `T peek()` — Returns the minimum element.
  - `T extractMin()` — Removes and returns the minimum element.
  - `boolean isEmpty()` — Checks if heap is empty.
  - `int size()` — Returns current heap size.

---

## Class: MyStack<T>
A stack implementation following LIFO (Last In First Out) principle.

### Key Features
- Backed by `MyLinkedList` or `MyArrayList`.
- Operations:
  - `void push(T element)` — Adds an element to the top.
  - `T pop()` — Removes and returns the top element.
  - `T peek()` — Returns the top element without removing.
  - `boolean isEmpty()` — Checks if stack is empty.
  - `int size()` — Returns the number of elements.

---

## Class: MyQueue<T>
A queue implementation following FIFO (First In First Out) principle.

### Key Features
- Backed by `MyLinkedList` or `MyArrayList`.
- Operations:
  - `void enqueue(T element)` — Adds an element to the rear.
  - `T dequeue()` — Removes and returns the front element.
  - `T peek()` — Returns the front element without removing.
  - `boolean isEmpty()` — Checks if queue is empty.
  - `int size()` — Returns the number of elements.

---

## Notes
- All structures are generic using Java generics (`<T>`).
- Null checks and bounds validations included.
- Custom exceptions thrown for invalid operations.

---

