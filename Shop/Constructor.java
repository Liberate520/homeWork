package homeWork.Shop;

class Constructor implements Comparable<Constructor> {
    private String name;
    private int priority;
    private int id;
    private static int nextId = 1;

    public Constructor(String name, int priority) {
        this.name = name;
        this.priority = priority;
        this.id = nextId;
        nextId++;
    }

    @Override
    public int compareTo(Constructor other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}