package Assignment3.BST;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.Entry<K, V>> {
    private Node root;
    private int size;

    private class Node {
        private K key;
        private V value;
        private Node left, right, parent;
        private int length;
        public Node(K key, V val, Node parent) {
            this.key = key;
            this.value = val;
            this.parent = parent;
            this.length = 1;
        }
    }
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (root == null) {
            root = new Node(key, value, null);
            size++;
            return;
        }
        Node current = root;
        Node parent = null;
        int cmp = 0;
        while (current != null) {
            parent = current;
            cmp = key.compareTo(current.key);
            if (cmp < 0) {
                current = current.left;
            }
            else if (cmp > 0) {
                current = current.right;
            }
            else {
                current.value = value;
                updateLengths(current);
                return;
            }
        }
        
        Node newNode = new Node(key, value, parent);
        if (cmp < 0) {
            parent.left = newNode;
        }
        else {
            parent.right = newNode;
        }
        size++;
        updateLengths(newNode);
    }

    private void updateLengths(Node node){
        while (node != null){
            int lenLeft = (node.left == null) ? 0 : node.left.length;
            int lenRight = (node.right == null) ? 0 : node.right.length;
            node.length = lenLeft + lenRight + 1;
            node = node.parent;
        }
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }

        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                current = current.left;
            }
            else if (cmp > 0) {
                current = current.right;
            }
            else {
                return current.value;
            }
        }
        return null;
    }

    public void delete(K key) {
        if (key == null) {
            return;
        }
        Node current = root;

        while (current != null && !key.equals(current.key)) {
            current = key.compareTo(current.key) < 0 ? current.left : current.right;
        }
        if (current == null) {
            return;
        }
        size--;

        if (current.left != null && current.right != null) {
            Node succ = current.right;
            while (succ.left != null) {
                succ = succ.left;
            }
            current.key = succ.key;
            current.value = succ.value;
            current = succ;
        }
        Node child = (current.left != null) ? current.left : current.right;
        Node parent = current.parent;
        if (parent == null) {
            root = child;
        }
        else if (parent.left == current) {
            parent.left = child;
        }
        else {
            parent.right = child;
        }
        if (child != null) {
            child.parent = parent;
        }
        updateLengths(parent);
    }



    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<Entry<K, V>>() {
            private Stack<Node> stack = new Stack<>();
            { pushLeft(root); }

            private void pushLeft(Node node) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Entry<K, V> next() {
                if (!hasNext()) throw new NoSuchElementException();
                Node node = stack.pop();
                if (node.right != null) pushLeft(node.right);
                return new Entry<>(node.key, node.value, node.length);
            }
        };
    }

    public static class Entry<K, V> {
        private final K key;
        private final V value;
        private final int length;

        public Entry(K key, V value, int length) {
            this.key = key;
            this.value = value;
            this.length = length;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
        public int getLength() { return length; }
    }

}
