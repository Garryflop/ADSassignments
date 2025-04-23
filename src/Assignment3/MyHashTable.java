package Assignment3;

public class MyHashTable<K, V> {

    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;


    @SuppressWarnings("unchecked")
    public MyHashTable() {
        chainArray = (HashNode<K, V>[]) new HashNode[M];
        size = 0;
    }


    @SuppressWarnings("unchecked")
    public MyHashTable(int M) {
        this.M = M;
        chainArray = (HashNode<K, V>[]) new HashNode[M];
        size = 0;
    }


    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int bucketIndex = hash(key);
        HashNode<K, V>  head = chainArray[bucketIndex];
        for (HashNode<K, V> curr = head; curr != null; curr = curr.next) {
            if (curr.key.equals(key)) {
                curr.value = value;
                return;
            }
        }
        HashNode<K, V> newNode = new HashNode<>(key, value);
        if (chainArray[bucketIndex] != null) {
            newNode.next = head;
        }
        chainArray[bucketIndex] = newNode;
        size++;
    }

    public V get(K key){
        if (key == null) {
            return null;
        }
        int bucketIndex = hash(key);
        for (HashNode<K, V> curr = chainArray[bucketIndex]; curr != null; curr = curr.next) {
            if (curr.key.equals(key)) {
                return curr.value;
            }
        }
        return null;
    }

    public V remove(K key){
        if (key == null) {
            return null;
        }
        int bucketIndex = hash(key);
        HashNode<K, V> curr = chainArray[bucketIndex];
        HashNode<K, V> prev = null;
        while (curr != null) {
            if (curr.key.equals(key)) {
                if (prev != null) {
                    prev.next = curr.next;
                }
                else {
                    chainArray[bucketIndex] = curr.next;
                }
                size--;
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }

    public boolean contains(V value){
        if (value == null) {
            return false;
        }
        for (HashNode<K, V> head : chainArray) {
            for (HashNode<K, V> curr = head; curr != null; curr = curr.next) {
                if (curr.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public K getKey(V value){
        if (value == null) {
            return null;
        }
        for (HashNode<K, V> head : chainArray) {
            for (HashNode<K, V> curr = head; curr != null; curr = curr.next) {
                if (curr.value.equals(value)) {
                    return curr.key;
                }
            }
        }
        return null;
    }

}
