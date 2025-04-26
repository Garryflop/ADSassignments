package Assignment3.HashTable;

public class Student {
    private String fullName;
    private int grade;

    public Student(String fullName, int grade) {
        this.fullName = fullName;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return fullName + " (" + grade + ")";
    }
}
