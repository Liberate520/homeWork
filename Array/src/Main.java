public class Main {
    public static void main(String[] args) {
        ArrayGroup group = new ArrayGroup();

        group.addNumbers(123234891);
        group.addNumbers(125);
        group.addNumbers(123323);
        group.addNumbers(19);

        group.sortBy();

        for (ArrayNumbers i : group){

            System.out.println(i);
        }
    }
}