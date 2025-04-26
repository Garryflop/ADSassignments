package Assignment3.HashTable;

public class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof MyTestingClass)){
            return false;
        }
        MyTestingClass other = (MyTestingClass) obj;
        return id == other.id && (name == null ? other.name == null : name.equals(other.name));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.length());
        return result;
    }
}
