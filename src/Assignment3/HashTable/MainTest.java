package Assignment3.HashTable;

import java.util.Random;

public class MainTest {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random rnd = new Random();
//        int id = 0;
//        MyTestingClass key = new MyTestingClass(id, "Name" + rnd.nextInt(1000));
//        Student value = new Student("Student" + "1", rnd.nextInt(100));
//        table.put(key, value);
        for (int i = 0; i < 10000; i++) {
            int id = rnd.nextInt(1000000);
            MyTestingClass key = new MyTestingClass(id, "Name" + rnd.nextInt(1000));
            Student value = new Student("Student" + i, rnd.nextInt(100));
            table.put(key, value);
        }

        System.out.println("Bucket distribution after inserting 10000 elements:");
        for (int i = 0; i < table.getBucketCount(); i++) {
            System.out.printf("Bucket %2d: %4d entries\n", i, table.getBucketSize(i));
        }
    }
}
