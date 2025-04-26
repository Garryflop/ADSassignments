package Assignment3.BST;


public class TestBST {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        tree.put(5, "five");
        tree.put(3, "three");
        tree.put(7, "seven");
        tree.put(4, "four");

        System.out.println("Size (total nodes): " + tree.size());
        System.out.println("In-order traversal (key, value, subtree size):");
        for (BST.Entry<Integer, String> elem : tree) {
            System.out.printf("key=%d, value=%s, length=%d%n", elem.getKey(), elem.getValue(), elem.getLength());
        }

        tree.delete(3);
        System.out.println("After delete 3:");
        System.out.println("Size (total nodes): " + tree.size());

        for (BST.Entry<Integer, String> elem : tree) {
            System.out.printf("key=%d, value=%s, length=%d%n", elem.getKey(), elem.getValue(), elem.getLength());
        }

    }
}
