public class Main {
    public static void main(String[] args) {
        Collection<Integer> collection = new Collection<>();
        collection.add(3);
        collection.add(45);
        collection.add(67);
        collection.add(2);
        for (var element : collection) {
            System.out.println(element);
        }
    }
}
